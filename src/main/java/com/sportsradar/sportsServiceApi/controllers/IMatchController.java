package com.sportsradar.sportsServiceApi.controllers;

import com.sportsradar.sportsServiceApi.modules.Match;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/${api.version}/match")
public interface IMatchController {

    @GetMapping("/completed")
    ResponseEntity<List<Match>> getAllCompletedMatches();


}
