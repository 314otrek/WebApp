package pl.longerownia.WebAppSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.longerownia.WebAppSpring.domain.Author;

public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
