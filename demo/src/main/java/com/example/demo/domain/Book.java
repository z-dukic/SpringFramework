package com.example.demo.domain;

import javax.persistence.*;
import java.util.Set;

// Govori hibernatu da je entitet
@Entity
public class Book {

    @Id //Ovo će bit key
    @GeneratedValue(strategy = GenerationType.AUTO) //Ovo znači da će baza sama dodjeljivati key
    private Long id;
    private String title;
    private String isbn;

    //Više na više veza, autor može imati više knjiga, više knjiga može imati isto autora
    //Join table, spoji tablice
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author>authors;

    public Book(){

    }

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
