package com.rest.restapi.controller;

import java.util.List;
import java.util.Optional;

import com.rest.restapi.Entities.bookClass;
import com.rest.restapi.service.bookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class book {

    
    @Autowired
     private bookService bService;

     //handler method
    @GetMapping("/books")
     public ResponseEntity<List<bookClass>> getBooks(){
        List<bookClass> list = bService.getAllBooks();
         if(list.size()<1)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         return ResponseEntity.of(Optional.of(list));
     }

     @GetMapping("/books/{id}")
     public ResponseEntity<bookClass> getBooks(@PathVariable("id") int id){
            bookClass b = this.bService.getBookById(id);
            if(b == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.of(Optional.of(b));

     }

     @PostMapping("/books")
     public bookClass add(@RequestBody bookClass book){
         bookClass b =  this.bService.addBook(book);
         //System.out.println(b);
         return b;
     }

     @DeleteMapping("/books/{id}")
     public void delBook(@PathVariable("id") int bid){
        this.bService.delBook(bid);
        // bookClass b = this.bService.delBook(bid);
        // return b;
     }

     @PutMapping("/books/{id}")
     public void update(@RequestBody bookClass book, @PathVariable("id") int bid){
            this.bService.update(book, bid);
     }
}
