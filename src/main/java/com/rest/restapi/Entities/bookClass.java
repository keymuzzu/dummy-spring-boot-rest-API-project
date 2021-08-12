package com.rest.restapi.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book_table")
public class bookClass {
    @Column(name = "bookId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    public void setAuthor(Author author) {
        this.author = author;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    public Author getAuthor() {
        return author;
    }
   
    public bookClass(int id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public bookClass() {
    }
    @Override
    public String toString() {
        return "bookClass [author=" + author + ", id=" + id + ", name=" + name + "]";
    }
}
