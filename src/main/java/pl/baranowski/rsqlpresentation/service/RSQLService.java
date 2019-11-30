package pl.baranowski.rsqlpresentation.service;

import com.github.tennaito.rsql.jpa.JpaPredicateVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RSQLService<T> {

    private final EntityManager entityManager;

    public Optional<Specification<T>> toSpecification(String query) {
        if (query == null) {
            return Optional.empty();
        }

        return Optional.ofNullable((Specification<T>) (root, criteriaQuery, criteriaBuilder) -> {
            final var visitor = new JpaPredicateVisitor<T>().defineRoot(root);

            final var rootNode = new RSQLParser().parse(query);
            return rootNode.accept(visitor, entityManager);
        });
    }
}
