package com.valbruno.crudquarkus.model;

import com.valbruno.crudquarkus.enums.GenreEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter 
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SUBTITLE")
    private String subTitle;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "ISBN13")
    private String ISBN13;

    @ManyToOne
    @JoinColumn(name="FK_AUTHOR", nullable=false, foreignKey = @ForeignKey(name = "FK_BOOK_AUTHOR"))
    private Author author;

    @ManyToOne
    @JoinColumn(name="FK_PUBLISHER", nullable=false, foreignKey = @ForeignKey(name = "FK_BOOK_PUBLISHER"))
    private Publisher publisher;

    @Column(name = "GENRE")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER, targetClass = GenreEnum.class)
    @CollectionTable(name = "BOOK_GENRES",
            joinColumns = @JoinColumn(name = "FK_BOOK", referencedColumnName = "ID"),
            foreignKey = @ForeignKey(name = "FK_BOOK_GENRE"))
    private Set<GenreEnum> genres = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(subTitle, book.subTitle) && Objects.equals(ISBN, book.ISBN) && Objects.equals(ISBN13, book.ISBN13) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher) && Objects.equals(genres, book.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subTitle, ISBN, ISBN13, author, publisher, genres);
    }


}
