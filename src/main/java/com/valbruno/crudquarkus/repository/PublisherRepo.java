package com.valbruno.crudquarkus.repository;

import com.valbruno.crudquarkus.model.Publisher;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublisherRepo implements PanacheRepository<Publisher> {

    public Publisher findByName(String name){
        return find("NAME", name).firstResult();
    }
}