package com.sportsradar.sportsServiceApi.services;

import com.sportsradar.sportsServiceApi.enums.StatusType;
import com.sportsradar.sportsServiceApi.modules.Match;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Value("${data.source.url}")
    private String dataSourceUrl;

    /**
    *
    * Function returns all matches from the /match/all uri by status;
    * If no status is passed the function returns all matches.
    *
    * @param statusType
    * @return List<Match>
    */
    public List<Match> getAllMatchesByStatus(StatusType statusType) {
        RestTemplate restTemplate = new RestTemplate();
        String url = dataSourceUrl + "/match/all";
        Match[] matches = restTemplate.getForObject(url, Match[].class);

        if (matches == null) {
            return null;
        }

        return Arrays.stream(matches)
                .filter(m -> statusType == null ||
                        m.getStatus().equals(statusType))
                .collect(Collectors.toList());

    }



}
