package com.spotts.vinyl_api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class VinylController {

    private final VinylRepository repository;
    private final VinylModelAssembler assembler;

    VinylController(VinylRepository repository, VinylModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/records")
    CollectionModel<EntityModel<VinylRecord>> all() {
        List<EntityModel<VinylRecord>> records = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(records, linkTo(methodOn(VinylController.class).all()).withSelfRel());
    }

    @PostMapping("/records")
    VinylRecord newRecord(@RequestBody VinylRecord record) {
        return repository.save(record);
    }

    @GetMapping("/records/{id}")
    EntityModel<VinylRecord> one(@PathVariable Long id) {
        VinylRecord record = repository.findById(id)
                .orElseThrow(() -> new VinylNotFoundException(id));
        return assembler.toModel(record);
    }

    @PutMapping("/records/{id}")
    VinylRecord replaceRecord(@RequestBody VinylRecord newRecord, @PathVariable Long id) {
        return repository.findById(id)
                .map(record -> {
                    record.setArtist(newRecord.getArtist());
                    record.setName(newRecord.getName());
                    return repository.save(record);
                })
                .orElseGet(() -> {
                    newRecord.setRecordId(id);
                    return repository.save(newRecord);
                });
    }

    @DeleteMapping("/records/{id}")
    void deleteRecord(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
