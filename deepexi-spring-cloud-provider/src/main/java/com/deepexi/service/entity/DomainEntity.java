package com.deepexi.service.entity;

public abstract class DomainEntity<T,R> {


    private T id;

    private R repo;

    public T getId(){
        return id;
    }

    protected R getRepo(){
        return repo;
    }

    public DomainEntity(T id, R repo){
        this.id = id;
        this.repo = repo;
    }
}
