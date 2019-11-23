package pl.baranowski.rsqlpresentation.repo;

import cz.jirutka.rsql.parser.RSQLParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.baranowski.rsqlpresentation.model.Animal;
import pl.baranowski.rsqlpresentation.rsql.CustomRsqlVisitor;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "notebook", path = "notebook")
public interface AnimalRepository extends JpaRepository<Animal, Long>, JpaSpecificationExecutor<Animal> {

    default List<Animal> findByName(@Param("name") String name) {
        if(name != null) {
            final var rootNode = new RSQLParser().parse(name);
            final var spec = rootNode.accept(new CustomRsqlVisitor<Animal>());
            return findAll(spec);
        }
        else {
           return findAll();
        }
    }
}
