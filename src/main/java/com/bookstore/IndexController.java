package com.bookstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>"+
        "<html>"+
            "<body>"+
                "<h1>Welcome to Bookstore Spring-boot API</h1>"+
                "<ul>"+
                    "<li>Fetch all books: https://bookstore-springboot-backend.herokuapp.com/book/getAll</li>"+
                    "<li>Create book (GET): https://bookstore-springboot-backend.herokuapp.com/book/add {book}</li>"+
                    "<li>Read book (GET): https://bookstore-springboot-backend.herokuapp.com/book/{id}</li>"+
                    "<li>Update book (PUT): https://bookstore-springboot-backend.herokuapp.com/book/{id}</li>"+
                    "<li>Delete book (DELETE): https://bookstore-springboot-backend.herokuapp.com/book/{id}</li>"+
                    "<li>Update book rating (PUT): https://bookstore-springboot-backend.herokuapp.com/book/rating/ {book} {id}</li>"+
                    "<li>Update book rating (PUT): https://bookstore-springboot-backend.herokuapp.com/book/status/ {book} {id}</li>"+
                "</ul>"+
            "</body>"+       
        "</html>");
        return sb.toString();
    }
}