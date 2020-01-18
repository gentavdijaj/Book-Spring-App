package com.gent.springwebap.repositories;

import com.gent.springwebap.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : genti
 **/
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
