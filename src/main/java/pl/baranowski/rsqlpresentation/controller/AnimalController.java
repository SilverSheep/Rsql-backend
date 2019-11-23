package pl.baranowski.rsqlpresentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.baranowski.rsqlpresentation.model.Animal;
import pl.baranowski.rsqlpresentation.repo.AnimalRepository;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/animals")
@RestController
public class AnimalController {

    private final AnimalRepository repository;

    @GetMapping()
    List<Animal> find(@Param("query") String query) {
      return repository.search(query);
    }
}
