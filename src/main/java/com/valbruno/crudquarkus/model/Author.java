package com.valbruno.crudquarkus.model;

import com.valbruno.crudquarkus.enums.GenreEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter 
@Setter
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @OneToMany(mappedBy="author")
    private Set<Book> books = new HashSet<>();

    @Column(name = "GENRE")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER, targetClass = GenreEnum.class)
    @CollectionTable(name = "AUTHOR_GENRES",
            joinColumns = @JoinColumn(name = "FK_AUTHOR", referencedColumnName = "ID"),
            foreignKey = @ForeignKey(name = "FK_AUTHOR_GENRE"))
    private Set<GenreEnum> genres = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(secondName, author.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, secondName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
