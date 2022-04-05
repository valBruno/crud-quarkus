package com.valbruno.model;

import com.valbruno.crudquarkus.enums.GenreEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
