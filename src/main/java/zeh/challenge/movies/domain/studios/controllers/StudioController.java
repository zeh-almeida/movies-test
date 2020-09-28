package zeh.challenge.movies.domain.studios.controllers;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zeh.challenge.movies.domain.commons.controllers.BaseController;
import zeh.challenge.movies.domain.studios.models.responses.GetStudio;
import zeh.challenge.movies.domain.studios.models.responses.GetStudioDetailed;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/studios", produces = MediaTypes.HAL_JSON_VALUE)
public class StudioController extends BaseController<GetStudio, GetStudioDetailed> {

    @GetMapping
    @Override
    public ResponseEntity<Page<EntityModel<GetStudio>>> index(@RequestParam(defaultValue = "0") final int pageNumber) {
        return ResponseEntity.ok(this.restService.getAll(checkPage(pageNumber)).map(model -> addModelLink(model, model.getId())));
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<GetStudioDetailed>> get(@PathVariable("id") final long id) {
        final Optional<GetStudioDetailed> model = this.restService.get(id);
        return this.addModelLink(model, id);
    }
}
