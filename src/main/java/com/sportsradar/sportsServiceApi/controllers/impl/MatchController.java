package com.sportsradar.sportsServiceApi.controllers.impl;

import com.sportsradar.sportsServiceApi.controllers.IMatchController;
import com.sportsradar.sportsServiceApi.enums.StatusType;
import com.sportsradar.sportsServiceApi.modules.Match;
import com.sportsradar.sportsServiceApi.services.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController implements IMatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public ResponseEntity<List<Match>> getAllCompletedMatches() {
        try {
            List<Match> matchList = matchService.getAllMatchesByStatus(StatusType.COMPLETED);

            if (matchList != null) {
                return ResponseEntity.ok(matchList);
            } else {
                return ResponseEntity.noContent().build();
            }

        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<Match>> getAllLiveMatches() {
        try {
            List<Match> matchList = matchService.getAllMatchesByStatus(StatusType.Live);

            if (matchList != null) {
                return ResponseEntity.ok(matchList);
            } else {
                return ResponseEntity.noContent().build();
            }

        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    public ResponseEntity<List<Match>> getAllMatches() {
        try {
            List<Match> matchList = matchService.getAllMatchesByStatus();

            if (matchList != null) {
                return ResponseEntity.ok(matchList);
            } else {
                return ResponseEntity.noContent().build();
            }

        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
