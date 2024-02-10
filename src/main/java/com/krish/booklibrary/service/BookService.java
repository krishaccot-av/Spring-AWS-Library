package com.krish.booklibrary.service;

import com.krish.booklibrary.model.Book;
import com.krish.booklibrary.model.BookIssue;
import com.krish.booklibrary.model.BookReview;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();

    Optional<Book> getBook(Long id);

    Book saveBook(Book book);

    BookReview saveBookReview(BookReview review);

    void deleteBook(Long bookId);

    List<BookReview> getBookReviews(Long bookId);

    BookReview saveReview(BookReview review);

    void deleteReview(Long id);

    List<BookIssue> getBookIssues(Long bookId);

    BookIssue saveBookIssue(BookIssue issue);

    void deleteBookIssue(Long id);




}
