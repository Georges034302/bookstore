package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {        
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {       
        return bookRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
       bookRepository.deleteById(id);        
    }

    @Override
    public Book update(Book book, int id) {
        Book existBook = getBook(id);
        existBook.update(book.getAuthor(),book.getYear(), book.getUrl(), book.isFinished(), book.getRating());
        return existBook;
    }

    @Override
    public Book updateRating(Book book, int id) {
        Book existBook = getBook(id);
        existBook.setRating(book.getRating());
        return existBook;
    }

    @Override
    public Double getRating(int id) {
        return getBook(id).getRating();
    }

    @Override
    public boolean status(int id) {
        return getBook(id).isFinished();
    }

    @Override
    public Book changeStatus(Book book, int id) {
        Book existBook = getBook(id);
        existBook.setFinished(book.isFinished());
        return existBook;
    }
}
