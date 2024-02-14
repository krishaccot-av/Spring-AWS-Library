package com.krish.booklibrary.service;

import com.krish.booklibrary.model.Book;
import com.krish.booklibrary.model.SubscribeBook;
import com.krish.booklibrary.model.BookReview;
import com.krish.booklibrary.model.SearchResult;
import com.krish.booklibrary.repository.SubscribeBookRepository;
import com.krish.booklibrary.repository.BookRepository;
import com.krish.booklibrary.repository.BookReviewRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class BookServiceImpl implements BookService {


    BookRepository repository;
    BookReviewRepository reviewRepository;
    SubscribeBookRepository issueRepository;


    @Override
    public List<Book> getBooks() {
        return repository.findAll();

    }

    @Override
    public Optional<Book> getBook(Long id) {
        return repository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public BookReview saveBookReview(BookReview review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteBook(Long bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public List<BookReview> getBookReviews(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    @Override
    public BookReview saveReview(BookReview review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public SubscribeBook saveSubscribeBook(SubscribeBook issue) {
        return issueRepository.save(issue);
    }

    @Override
    public List<Book> subscribedBooks() {
        return repository.findBySubscribeBooks();
    }

    @Override
    public List<SubscribeBook> getSubscribeBooks(Long bookId) {
        return issueRepository.findByBookId(bookId);
    }

    @Override
    public void deleteBookIssue(Long id) {
        issueRepository.deleteById(id);
    }

    @Value("${googlebookapikey}")
    private String googleApiKey;
    @Override
    @Async
    public CompletableFuture<SearchResult> googleBookSearch(String searchKey) {

        RestTemplate restTemplate = new RestTemplate();
        SearchResult result =  restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes?q={searchKey}&key={googleApiKey}", SearchResult.class, searchKey, googleApiKey);
        return CompletableFuture.completedFuture(result);
    }


    public BookServiceImpl(BookRepository repository, BookReviewRepository reviewRepository, SubscribeBookRepository issueRepository)
    {
        this.repository = repository;
        this.reviewRepository=reviewRepository;
        this.issueRepository = issueRepository;
    }
}
