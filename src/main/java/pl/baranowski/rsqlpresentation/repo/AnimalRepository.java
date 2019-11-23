package pl.baranowski.rsqlpresentation.repo;

import cz.jirutka.rsql.parser.RSQLParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.baranowski.rsqlpresentation.model.Animal;
import pl.baranowski.rsqlpresentation.rsql.CustomRsqlVisitor;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>, JpaSpecificationExecutor<Animal> {

    default List<Animal> search(String query) {
        if(query != null) {
            final var rootNode = new RSQLParser().parse(query);
            final var spec = rootNode.accept(new CustomRsqlVisitor<Animal>());
            return findAll(spec);
        }
        else {
           return findAll();
        }
    }
}
