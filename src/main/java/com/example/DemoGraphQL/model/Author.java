package com.example.DemoGraphQL.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author {
    @Id
    @Column(name = "author_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author_first_name", nullable = false)
    private String firstName;

    @Column(name = "author_last_name", nullable = false)
    private String lastName;

    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Author author = (Author)o;

        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
