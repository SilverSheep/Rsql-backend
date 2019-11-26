package pl.baranowski.rsqlpresentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.baranowski.rsqlpresentation.model.Animal;
import pl.baranowski.rsqlpresentation.repo.AnimalRepository;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/animals")
@RestController
@CrossOrigin
public class AnimalController {

    private final AnimalRepository repository;

    @GetMapping
    List<Animal> find(@RequestParam(value = "query", required = false) String query) {
      return repository.search(query);
    }
}
