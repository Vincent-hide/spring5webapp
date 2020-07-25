package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author hide = new Author("Hide", "Hiro");
        Book textbook = new Book("How to code spring-boot", "sb");

        hide.getBooks().add(textbook);
        textbook.getAuthors().add(hide);

        authorRepository.save(hide);
        bookRepository.save(textbook);

        Author suho = new Author("Suho", "Vincent");
        Book notebook = new Book("How to code Java", "java");

        suho.getBooks().add(notebook);
        notebook.getAuthors().add(suho);

        authorRepository.save(suho);
        bookRepository.save(notebook);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
