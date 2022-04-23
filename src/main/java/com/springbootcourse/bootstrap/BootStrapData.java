package com.springbootcourse.bootstrap;

import com.springbootcourse.domain.Author;
import com.springbootcourse.domain.Book;
import com.springbootcourse.domain.Publisher;
import com.springbootcourse.repositories.AuthorRepository;
import com.springbootcourse.repositories.BookRepository;
import com.springbootcourse.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Publisher");
        publisher.setCity("UFA");
        publisher.setState("Bashkortostan");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author author1 = new Author("First Name 1", "Surname 2");
        Book book = new Book("Book", "1234");
        author1.getBooks().add(book);
        book.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(book);

        Author author2 = new Author("First Name 2", "Surname 2");
        Book newBook = new Book("New Book", "5678");
        author2.getBooks().add(newBook);
        book.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(newBook);

        System.out.println("Number of books: " + bookRepository.count());
    }
}