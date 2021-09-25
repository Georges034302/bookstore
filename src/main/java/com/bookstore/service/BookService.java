package com.bookstore.service;

import com.bookstore.model.Book;
import java.util.List;

public interface BookService {
    public Book saveBook(Book book);

    public List<Book> getAllBooks();

    public Book getBook(int id);

    public void delete(int id);

    public Book update(Book book, int id);

    public Book updateRating(Book book, int id);

    public Double getRating(int id);

    public boolean status(int id);

    public Book changeStatus(Book book,int id);

}
