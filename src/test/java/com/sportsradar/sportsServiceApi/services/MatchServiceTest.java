package com.sportsradar.sportsServiceApi.services;

import com.sportsradar.sportsServiceApi.enums.StatusType;
import com.sportsradar.sportsServiceApi.modules.Match;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MatchServiceTest {

    @Value("${data.source.url}")
    private String dataSourceUrl;

    @Autowired
    private MatchService matchService;

    @MockBean
    private RestTemplate restTemplate;

    private Match[] mockMatches = new Match[] {
            new Match.MatchBuilder().setId(1).setStatusType(StatusType.COMPLETED).setHomeTeam("Sacramento Kings").build(),
            new Match.MatchBuilder().setId(2).setStatusType(StatusType.COMPLETED).setHomeTeam("Portland Trail Blazers").setAwayTeam("Milwaukee Bucks").build(),
            new Match.MatchBuilder().setId(3).setStatusType(StatusType.SCHEDULED).setHomeTeam("Denver Nuggets").setAwayTeam("Brooklyn Nets").build(),
            new Match.MatchBuilder().setId(4).setStatusType(StatusType.Live).setHomeTeam("Detroit Redwings").setAwayTeam("Los Angeles Kings").build(),
            new Match.MatchBuilder().setId(5).setStatusType(StatusType.COMPLETED).setHomeTeam("Chicago Blackhawks").build(),
            new Match.MatchBuilder().setId(6).setStatusType(StatusType.SCHEDULED).setAwayTeam("Chicago Blackhawks").build()
    };

    @Test
    public void testGetAllMatchesByStatus() {
        String apiUrl = dataSourceUrl + "/api/${api.version}/match";
        when(restTemplate.getForObject(apiUrl, Match[].class)).thenReturn(mockMatches);

        List<Match> completedMatches = matchService.getAllMatchesByStatus(StatusType.COMPLETED);
        List<Match> liveMatches = matchService.getAllMatchesByStatus(StatusType.Live);
        List<Match> allMatches = matchService.getAllMatchesByStatus();

        Assertions.assertEquals(4, completedMatches.size());
        Assertions.assertEquals(1, liveMatches.size());
        Assertions.assertEquals(6, allMatches.size());

    }

    @Test
    public void testGetAllMatchesByTeamName() {
        String apiUrl = dataSourceUrl + "/api/${api.version}/match";
        when(restTemplate.getForObject(apiUrl, Match[].class)).thenReturn(mockMatches);

        List<Match> nameMatch1 = matchService.getAllMatchesByTeamName("Sacramento");
        List<Match> nameMatch2 = matchService.getAllMatchesByTeamName("lOS");
        List<Match> nameMatch3 = matchService.getAllMatchesByTeamName("Olimpija");
        List<Match> nameMatch4 = matchService.getAllMatchesByTeamName("");

        Assertions.assertEquals(nameMatch1.get(0).getId(), 1);

        Assertions.assertEquals(nameMatch2.get(0).getId(), 4);
        Assertions.assertEquals(nameMatch2.get(1).getId(), 6);

        Assertions.assertEquals(nameMatch3.size(), 0);

        Assertions.assertEquals(nameMatch4.size(), 6);

    }

}
