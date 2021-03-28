package pl.longerownia.WebAppSpring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.longerownia.WebAppSpring.domain.Author;
import pl.longerownia.WebAppSpring.domain.Book;
import pl.longerownia.WebAppSpring.domain.Publisher;
import pl.longerownia.WebAppSpring.repositories.AuthorRepository;
import pl.longerownia.WebAppSpring.repositories.BookRepository;
import pl.longerownia.WebAppSpring.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publiserRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publiserRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisher.setCity("St Petersburg");
        publisher.setState("Fl");
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "122232");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE without EJB", "254151512125");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: "+bookRepository.count() );
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
