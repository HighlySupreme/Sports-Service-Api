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

    private Match[] mockMatches;

    @Test
    public void testGetAllMatchesByStatus() {
        mockMatches = new Match[] {
                new Match.MatchBuilder().setStatusType(StatusType.COMPLETED).build(),
                new Match.MatchBuilder().setStatusType(StatusType.COMPLETED).build(),
                new Match.MatchBuilder().setStatusType(StatusType.SCHEDULED).build(),
                new Match.MatchBuilder().setStatusType(StatusType.Live).build(),
                new Match.MatchBuilder().setStatusType(StatusType.COMPLETED).build(),
                new Match.MatchBuilder().setStatusType(StatusType.SCHEDULED).build()
        };

        String apiUrl = dataSourceUrl + "/api/${api.version}/match";
        when(restTemplate.getForObject(apiUrl, Match[].class)).thenReturn(mockMatches);

        List<Match> completedMatches = matchService.getAllMatchesByStatus(StatusType.COMPLETED);

        Assertions.assertEquals(4, completedMatches.size());

    }

}
