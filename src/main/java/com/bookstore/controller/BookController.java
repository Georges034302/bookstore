package com.bookstore.controller;

import com.bookstore.service.BookService;
import com.bookstore.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/", maxAge = 3600)
@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public String add(@RequestBody Book book) {
        bookService.saveBook(book);
        return "New Book is added.";
    }

    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        try {
            Book book = bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Integer id) {
        try {
            Book existBook = bookService.update(book, id);
            bookService.saveBook(existBook);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/rating/{id}")
    public ResponseEntity<Book> updateRating(@RequestBody Book book, @PathVariable Integer id) {
        try {
            Book existBook = bookService.updateRating(book, id);
            bookService.saveBook(existBook);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getRating/{id}")
    public double getRating(@PathVariable Integer id) {
        try {
            return bookService.getRating(id);
        } catch (NoSuchElementException ex) {
            return HttpStatus.NOT_FOUND.value();
        }
    }
    
    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/status/{id}")
    public boolean status(@PathVariable Integer id) {
        try {
            return bookService.status(id);
        } catch (NoSuchElementException ex) {
            return HttpStatus.NOT_FOUND.isError();
        }
    }
    
    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/status/{id}")
    public ResponseEntity<Book> changeStatus(@RequestBody Book book, @PathVariable Integer id) {
        try {
            Book existBook = bookService.changeStatus(book, id);
            bookService.saveBook(existBook);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "https://bookstore-react-frontend.herokuapp.com/")//@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        bookService.delete(id);
        return "Deleted book with id "+id;
    }
}
