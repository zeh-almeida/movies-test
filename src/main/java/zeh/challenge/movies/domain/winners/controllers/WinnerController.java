package zeh.challenge.movies.domain.winners.controllers;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zeh.challenge.movies.domain.commons.controllers.BaseController;
import zeh.challenge.movies.domain.winners.models.responses.GetWinner;
import zeh.challenge.movies.domain.winners.models.responses.GetWinnerDetailed;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/winners", produces = MediaTypes.HAL_JSON_VALUE)
public class WinnerController extends BaseController<GetWinner, GetWinnerDetailed> {

    @GetMapping
    @Override
    public ResponseEntity<Page<EntityModel<GetWinner>>> index(@RequestParam(defaultValue = "0") final int pageNumber) {
        return ResponseEntity.ok(this.restService.getAll(checkPage(pageNumber)).map(model -> addModelLink(model, model.getId())));
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<GetWinnerDetailed>> get(@PathVariable("id") final long id) {
        final Optional<GetWinnerDetailed> model = this.restService.get(id);
        return this.addModelLink(model, id);
    }
}
