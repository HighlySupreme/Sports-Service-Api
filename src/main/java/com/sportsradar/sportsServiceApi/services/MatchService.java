package com.sportsradar.sportsServiceApi.services;

import com.sportsradar.sportsServiceApi.enums.StatusType;
import com.sportsradar.sportsServiceApi.modules.Match;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MatchService {

    @Value("${data.source.url}")
    private String dataSourceUrl;

    /**
     *
     * Function returns a list of all matches from the /match/all uri
     *
     * @return List<Match>
     */
    public List<Match> getAllMatches() {
        RestTemplate restTemplate = new RestTemplate();
        String url = dataSourceUrl + "/match/all";
        Match[] matches = restTemplate.getForObject(url, Match[].class);

        if (matches == null) {
            return null;
        }

        return Arrays.stream(matches).toList();
    }

    /**
    *
    * Function returns all matches from the /match/all uri
    *
    * @return List<Match>
    */
    public List<Match> getAllMatchesByStatus() {
        return getAllMatchesByStatus(null);
    }

    /**
    *
    * Function returns all matches from the /match/all uri by status;
    * If no status is passed the function returns all matches.
    *
    * @param statusType
    * @return List<Match>
    */
    public List<Match> getAllMatchesByStatus(StatusType statusType) {
        List<Match> matches = getAllMatches();

        return matches.stream()
                .filter(m -> statusType == null ||
                    m.getStatus().equals(statusType)).toList();

    }

    /**
     *
     * Function returns all matches from the /match/all uri by teamName;
     *
     * @param teamName
     * @return List<Match>
     */
    public List<Match> getAllMatchesByTeamName(String teamName) {
        List<Match> matches = getAllMatches();

        return matches.stream()
                .filter(m -> StringUtils.isBlank(teamName) || StringUtils.containsIgnoreCase(m.getHome_team(), teamName) || StringUtils.containsIgnoreCase(m.getAway_team(), teamName))
                .toList();
    }





}
