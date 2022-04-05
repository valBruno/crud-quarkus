package com.valbruno.crudquarkus.model;

import lombok.*;

@Getter 
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {
    
    Long id;
    String name;
}
