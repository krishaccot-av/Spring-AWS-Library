package com.krish.booklibrary.controller;

import com.krish.booklibrary.model.Book;
import com.krish.booklibrary.model.BookIssue;
import com.krish.booklibrary.model.BookReview;
import com.krish.booklibrary.service.BookService;
import com.krish.booklibrary.service.BookServiceImpl;
import com.krish.booklibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

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

    @PostMapping("save")
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
        review.setBook(bookService.getBook(bookId).get());
        review.setUser(userService.getUser(username).get());
        return bookService.saveBookReview(review);
    }

    @DeleteMapping("reviews/{id}")
    public void deleteBookReview(@PathVariable Long id){
        bookService.deleteReview(id);
    }

    @GetMapping("/issues/{bookId}")
    public List<BookIssue> getBookIssues(@PathVariable Long bookId) {
        return bookService.getBookIssues(bookId);
    }

    @PostMapping("issues/{bookId}/{username}")
    public BookIssue saveBookIssue(@PathVariable Long bookId,@PathVariable String username, @RequestBody BookIssue issue){
        issue.setBook(bookService.getBook(bookId).get());
        issue.setUser(userService.getUser(username).get());
        return bookService.saveBookIssue(issue);
    }

    @DeleteMapping("issues/{id}")
    public void deleteBookIssue(@PathVariable Long id){
        bookService.deleteBookIssue(id);
    }


}
