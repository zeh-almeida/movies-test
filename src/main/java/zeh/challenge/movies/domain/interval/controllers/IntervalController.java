package zeh.challenge.movies.domain.interval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zeh.challenge.movies.domain.interval.models.beans.WinnerProducer;
import zeh.challenge.movies.domain.interval.services.IntervalService;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/intervals", produces = MediaTypes.HAL_JSON_VALUE)
public class IntervalController {

    @Autowired
    private IntervalService restService;

    @GetMapping
    public ResponseEntity<Collection<WinnerProducer>> getWinningProducers() {
        return ResponseEntity.ok(this.restService.getWinningProducers());
    }
}
