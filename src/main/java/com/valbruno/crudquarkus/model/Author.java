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
public class Author {

    Long id;
    String name;
    String secondName;
    List<GenreEnum> genres = new ArrayList<>();
    
}
