package com.krish.booklibrary.repository;

import com.krish.booklibrary.model.SubscribeBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscribeBookRepository extends JpaRepository<SubscribeBook,Long> {
    List<SubscribeBook> findByBookId(Long bookId);



}
