package pl.longerownia.WebAppSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.longerownia.WebAppSpring.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
