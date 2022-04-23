package com.springbootcourse.repositories;

import com.springbootcourse.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}