package com.krish.booklibrary.model;

import java.util.List;

public class Data {
    private List<Book> books;
    private List<User> users;
    private List<BookIssue> issues;
    private List<BookReview> reviews;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    private List<Author> authors;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<BookIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<BookIssue> issues) {
        this.issues = issues;
    }

    public List<BookReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<BookReview> reviews) {
        this.reviews = reviews;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    private List<Member> members;

}
