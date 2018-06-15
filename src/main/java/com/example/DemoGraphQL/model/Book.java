package com.example.DemoGraphQL.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @Column(name="book_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="book_title", nullable = false)
    private String title;

    @Column(name="book_isbn", nullable = false)
    private String isbn;

    @Column(name="book_pageCount", nullable = false)
    private int pageCount;

    @ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
    private Author author;

    public Book() {
    }

    public Book(String title, String isbn, int pageCount, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.author = author;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
