package pl.baranowski.rsqlpresentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import pl.baranowski.rsqlpresentation.model.Animal;
import pl.baranowski.rsqlpresentation.repo.AnimalRepository;
import pl.baranowski.rsqlpresentation.service.RSQLService;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/animals")
@RestController
@CrossOrigin
public class AnimalController {

    private final RSQLService rsqlService;
    private final AnimalRepository repository;

    @GetMapping
    Page<Animal> find(@RequestParam(value = "query", required = false) String query, Pageable pageable) {
        Optional<Specification<Animal>> specification = rsqlService.toSpecification(query);

        if (specification.isPresent()) {
            return repository.findAll(specification.get(), pageable);
        }

        return repository.findAll(pageable);
    }
}
