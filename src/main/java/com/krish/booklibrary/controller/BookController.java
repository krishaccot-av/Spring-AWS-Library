package com.krish.booklibrary.controller;

import com.krish.booklibrary.model.*;
import com.krish.booklibrary.service.BookService;
import com.krish.booklibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    BookService bookService;

    UserService userService;
    public BookController(BookService bookService,UserService userService)
    {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<Book> getAllBooks()
    {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBook(@PathVariable Long id)
    {
        return bookService.getBook(id);
    }

    @PostMapping("")
    public Book saveBook(@RequestBody Book book) {
        System.out.println("${---:"+book.getTitle());
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @GetMapping("/reviews/{bookId}")
    public List<BookReview> getBookReviews(@PathVariable Long bookId) {
        return bookService.getBookReviews(bookId);
    }

    @PostMapping("reviews/{bookId}/{username}")
    public BookReview saveBookReview(@PathVariable Long bookId,@PathVariable String username, @RequestBody BookReview review){
        bookService.getBook(bookId).ifPresent(review::setBook);
        userService.getUser(username).ifPresent(review::setUser);
        return bookService.saveBookReview(review);
    }

    @DeleteMapping("reviews/{id}")
    public void deleteBookReview(@PathVariable Long id){
        bookService.deleteReview(id);
    }

    @GetMapping("/subscriptions/{bookId}")
    public List<SubscribeBook> getBookIssues(@PathVariable Long bookId) {
        return bookService.getSubscribeBooks(bookId);
    }

    @GetMapping("/subscriptions")
    public List<Book> getIssuedBooks() {
        return bookService.subscribedBooks();
    }

    @PostMapping("subscriptions/{bookId}/{username}")
    public SubscribeBook saveBookIssue(@PathVariable Long bookId, @PathVariable String username, @RequestBody SubscribeBook issue){
        bookService.getBook(bookId).ifPresent(issue::setBook);
        userService.getUser(username).ifPresent(issue::setUser);
        return bookService.saveSubscribeBook(issue);
    }

    @DeleteMapping("subscriptions/{id}")
    public void deleteBookIssue(@PathVariable Long id){
        bookService.deleteBookIssue(id);
    }

    @GetMapping("google/search/{searchKey}")
    public List<BookItem> searchGoogleBooks(@PathVariable String searchKey) {
        CompletableFuture<SearchResult> task = bookService.googleBookSearch(searchKey);
        try {
            SearchResult res =  task.get();
            return res.items.stream().filter(item -> (item.volumeInfo.pageCount != null? item.volumeInfo.pageCount : 0)>200).toList();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
