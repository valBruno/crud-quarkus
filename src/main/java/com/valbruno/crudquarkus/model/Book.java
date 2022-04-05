package com.valbruno.crudquarkus.model;

import com.valbruno.crudquarkus.enums.GenreEnum;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter 
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    Long id;
    String title;
    String subTitle;
    String ISBN;
    String ISBN13;
    Author author;
    List<GenreEnum> genres = new ArrayList<>();
    
}
