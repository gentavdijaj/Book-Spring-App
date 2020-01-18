package com.gent.springwebap.repositories;

import com.gent.springwebap.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : genti
 **/
public interface BookRepository extends CrudRepository<Book, Long> {
}
