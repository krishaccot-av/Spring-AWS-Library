package com.krish.booklibrary.service;

import com.krish.booklibrary.model.Book;
import com.krish.booklibrary.model.BookIssue;
import com.krish.booklibrary.model.BookReview;
import com.krish.booklibrary.repository.BookIssueRepository;
import com.krish.booklibrary.repository.BookRepository;
import com.krish.booklibrary.repository.BookReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    BookRepository repository;
    BookReviewRepository reviewRepository;
    BookIssueRepository issueRepository;


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
    public List<BookIssue> getBookIssues(Long bookId) {
        return issueRepository.findByBookId(bookId);
    }

    @Override
    public BookIssue saveBookIssue(BookIssue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public void deleteBookIssue(Long id) {
        issueRepository.deleteById(id);
    }


    public BookServiceImpl(BookRepository repository, BookReviewRepository reviewRepository, BookIssueRepository issueRepository)
    {
        this.repository = repository;
        this.reviewRepository=reviewRepository;
        this.issueRepository = issueRepository;
    }
}
