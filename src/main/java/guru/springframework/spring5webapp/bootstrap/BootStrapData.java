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
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author hide = new Author("Hide", "Hiro");
        Book textbook = new Book("How to code spring-boot", "sb");
        Publisher boss = new Publisher();
        boss.setName("BOSS");
        boss.setAddressLine1("XYZ");
        boss.setState("Ontario");
        boss.setCity("Toronto");
        boss.setZip("XXX-XXX-XXX");

        publisherRepository.save(boss);

        System.out.println("Publisher Count: " + publisherRepository.count());

        hide.getBooks().add(textbook);
        textbook.getAuthors().add(hide);
        textbook.setPublisher(boss);
        boss.getBooks().add(textbook);

        authorRepository.save(hide);
        bookRepository.save(textbook);
        publisherRepository.save(boss);

        Author suho = new Author("Suho", "Vincent");
        Book notebook = new Book("How to code Java", "java");

        suho.getBooks().add(notebook);
        notebook.getAuthors().add(suho);
        boss.getBooks().add(notebook);

        authorRepository.save(suho);
        bookRepository.save(notebook);
        publisherRepository.save(boss);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println(boss.getName() + " has " + boss.getBooks().size() + " book/s");
    }
}
