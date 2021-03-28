package pl.longerownia.WebAppSpring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.longerownia.WebAppSpring.repositories.AuthorRepository;
import pl.longerownia.WebAppSpring.repositories.BookRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());
        model.addAttribute("authors",authorRepository.findAll());

        return  "books/list";
    };
}
