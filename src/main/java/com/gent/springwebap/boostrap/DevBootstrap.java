package com.gent.springwebap.boostrap;

import com.gent.springwebap.model.Author;
import com.gent.springwebap.model.Book;
import com.gent.springwebap.model.Publisher;
import com.gent.springwebap.repositories.AuthorRepository;
import com.gent.springwebap.repositories.BookRepository;
import com.gent.springwebap.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author : genti
 **/
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData(){
        //Creating objects for Author, Book and Publisher
        Publisher publisher = new Publisher("Gent","Prishtina");
        publisherRepository.save(publisher);

        Author filan = new Author("Filan","Fisteku");
        Book bookTest = new Book("Book title", "Book ISBN", publisher);

        filan.getBooks().add(bookTest);
        bookTest.getAuthors().add(filan);

        authorRepository.save(filan);
        bookRepository.save(bookTest);

        //Check console
        System.out.println("Author: " + filan.getFirstName() + " : " + filan.getLastName()
        +"\nBook: " + bookTest.getTitle() + " : " + bookTest.getIsbn());
    }
}
