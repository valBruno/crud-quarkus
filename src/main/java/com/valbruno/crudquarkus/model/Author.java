package com.valbruno.model;

import java.util.ArrayList;
import java.util.List;

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
public class Author {

    Long id;
    String name;
    String secondName;
    List<GenreEnum> genres = new ArrayList<>();
    
}
