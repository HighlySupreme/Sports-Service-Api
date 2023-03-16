package com.sportsradar.sportsServiceApi.controllers;

import com.sportsradar.sportsServiceApi.modules.Match;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/${api.version}/match")
public interface IMatchController {

    @RequestMapping(value = "/completed", method = RequestMethod.GET, produces = "application/json")
    @Operation(summary = "Get all completed matches", responses = {
            @ApiResponse(responseCode = "200", description = "List of completed matches"),
            @ApiResponse(responseCode = "404", description = "No matches found", content = @Content)
    })
    ResponseEntity<List<Match>> getAllCompletedMatches();

    @GetMapping("/live")
    @Operation(summary = "Get all live matches", responses = {
            @ApiResponse(responseCode = "200", description = "List of live matches"),
            @ApiResponse(responseCode = "404", description = "No matches found", content = @Content)
    })
    ResponseEntity<List<Match>> getAllLiveMatches();

    @GetMapping("/all")
    @Operation(summary = "Get all matches", responses = {
            @ApiResponse(responseCode = "200", description = "List of all matches"),
            @ApiResponse(responseCode = "404", description = "No matches found", content = @Content)
    })
    ResponseEntity<List<Match>> getAllMatches();
    @GetMapping()
    @Operation(summary = "Get all matches by team name", responses = {
            @ApiResponse(responseCode = "200", description = "List of matches for the specified team",
                    content = @Content(schema = @Schema(implementation = Match.class))),
            @ApiResponse(responseCode = "404", description = "No matches found", content = @Content)
    })
    ResponseEntity<List<Match>> getAllMatchesByTeamName(@PathParam("name") String name);


}
