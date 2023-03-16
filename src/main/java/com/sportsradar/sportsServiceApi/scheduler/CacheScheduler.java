package com.sportsradar.sportsServiceApi.scheduler;

import com.sportsradar.sportsServiceApi.enums.StatusType;
import com.sportsradar.sportsServiceApi.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class CacheScheduler {

    private final MatchService matchService;

    @Autowired
    public CacheScheduler(MatchService matchService) {
        this.matchService = matchService;
    }

    @Scheduled(fixedRate = 60000) // runs every minute
    public void cacheLiveMatches() {
        matchService.getAllMatchesByStatus(StatusType.Live);
    }
}