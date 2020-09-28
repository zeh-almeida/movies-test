package zeh.challenge.movies.domain.movies.controllers;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zeh.challenge.movies.domain.commons.controllers.BaseController;
import zeh.challenge.movies.domain.movies.models.responses.GetMovie;
import zeh.challenge.movies.domain.movies.models.responses.GetMovieDetailed;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/movies", produces = MediaTypes.HAL_JSON_VALUE)
public class MovieController extends BaseController<GetMovie, GetMovieDetailed> {

    @GetMapping
    public ResponseEntity<Page<EntityModel<GetMovie>>> index(@RequestParam(defaultValue = "0") final int pageNumber) {
        return ResponseEntity.ok(this.restService.getAll(checkPage(pageNumber)).map(model -> addModelLink(model, model.getId())));
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<GetMovieDetailed>> get(@PathVariable("id") final long id) {
        final Optional<GetMovieDetailed> model = this.restService.get(id);
        return this.addModelLink(model, id);
    }
}
