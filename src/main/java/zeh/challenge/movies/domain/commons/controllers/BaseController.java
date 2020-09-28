package zeh.challenge.movies.domain.commons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import zeh.challenge.movies.domain.commons.services.RestService;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public abstract class BaseController<GetModel, GetDetailedModel> {

    @Autowired
    protected RestService<GetModel, GetDetailedModel> restService;

    protected static int checkPage(final int pageNumber) {
        return Math.max(pageNumber, 0);
    }

    public abstract ResponseEntity<Page<EntityModel<GetModel>>> index(final int pageNumber);

    public abstract ResponseEntity<EntityModel<GetDetailedModel>> get(final long id);

    protected <T> CollectionModel<EntityModel<T>> addCollectionLink(final Page<EntityModel<T>> data, final int pageNumber) {
        final Class<? extends BaseController> currentClass = this.getClass();
        final WebMvcLinkBuilder linkBuilder = linkTo(methodOn(currentClass).index(pageNumber));

        return CollectionModel.of(data,
                linkBuilder.withSelfRel().withType(HttpMethod.GET.name()).withMedia(String.valueOf(pageNumber)));
    }

    protected <T> ResponseEntity<EntityModel<T>> addModelLink(final Optional<T> data, final long id) {
        if (data.isPresent()) {
            final EntityModel<T> model = this.addModelLink(data.get(), id);
            return ResponseEntity.ok(model);

        } else {
            return ResponseEntity.noContent().build();
        }
    }

    protected <T> EntityModel<T> addModelLink(final T data, final long id) {
        final EntityModel<T> model = EntityModel.of(data);

        final Class<?> currentClass = this.getClass();
        final WebMvcLinkBuilder linkBuilder = linkTo(currentClass);

        model.add(linkBuilder
                .slash(id)
                .withSelfRel()
                .withType(HttpMethod.GET.name()));

        model.add(linkBuilder
                .slash(id)
                .withRel("update")
                .withType(HttpMethod.PUT.name()));

        model.add(linkBuilder
                .slash(id)
                .withRel("delete")
                .withType(HttpMethod.DELETE.name()));

        return model;
    }
}
