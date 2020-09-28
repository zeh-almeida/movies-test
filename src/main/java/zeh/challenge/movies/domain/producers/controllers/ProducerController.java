package zeh.challenge.movies.domain.producers.controllers;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zeh.challenge.movies.domain.commons.controllers.BaseController;
import zeh.challenge.movies.domain.producers.models.responses.GetProducer;
import zeh.challenge.movies.domain.producers.models.responses.GetProducerDetailed;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/producers", produces = MediaTypes.HAL_JSON_VALUE)
public class ProducerController extends BaseController<GetProducer, GetProducerDetailed> {

    @GetMapping
    @Override
    public ResponseEntity<Page<EntityModel<GetProducer>>> index(@RequestParam(defaultValue = "0") final int pageNumber) {
        return ResponseEntity.ok(this.restService.getAll(checkPage(pageNumber)).map(model -> addModelLink(model, model.getId())));
    }

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<GetProducerDetailed>> get(@PathVariable("id") final long id) {
        final Optional<GetProducerDetailed> model = this.restService.get(id);
        return this.addModelLink(model, id);
    }
}
