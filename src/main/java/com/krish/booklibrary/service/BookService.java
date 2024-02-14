package com.krish.booklibrary.service;

import com.krish.booklibrary.model.Book;
import com.krish.booklibrary.model.SubscribeBook;
import com.krish.booklibrary.model.BookReview;
import com.krish.booklibrary.model.SearchResult;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BookService {
    List<Book> getBooks();

    Optional<Book> getBook(Long id);

    Book saveBook(Book book);

    BookReview saveBookReview(BookReview review);

    void deleteBook(Long bookId);

    List<BookReview> getBookReviews(Long bookId);

    BookReview saveReview(BookReview review);

    void deleteReview(Long id);

    List<SubscribeBook> getSubscribeBooks(Long bookId);

    SubscribeBook saveSubscribeBook(SubscribeBook issue);

    List<Book> subscribedBooks();

    void deleteBookIssue(Long id);

    CompletableFuture<SearchResult> googleBookSearch(String searchKey);




}
