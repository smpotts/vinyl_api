package com.spotts.vinyl_api;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Converts a VinylRecord into an EntityModel.
 */
@Component
public class VinylModelAssembler implements RepresentationModelAssembler<VinylRecord, EntityModel<VinylRecord>> {

    /**
     * Wraps the VinylRecord object and adds links to it.
     * @param record the record object
     * @return an EntityModel for the vinyl record
     */
    @Override
    public EntityModel<VinylRecord> toModel(VinylRecord record) {
        return EntityModel.of(record,
                linkTo(methodOn(VinylController.class).one(record.getRecordId())).withSelfRel(),
                linkTo(methodOn(VinylController.class).all()).withRel("records"));
    }
}
