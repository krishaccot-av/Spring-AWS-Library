package com.krish.booklibrary.repository;

import com.krish.booklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "SELECT b.* FROM subscribe_book s join book b on s.book_id=b.id", nativeQuery = true)
    List<Book> findBySubscribeBooks();
}
