package pl.longerownia.WebAppSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.longerownia.WebAppSpring.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
