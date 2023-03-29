package com.example.jurnal.services;

import java.util.List;

public interface BaseService<Z> {
    Z save(Z t);
    Z findById(Long id);
    Z delete(Long id);
    Z update(Long id, Z z);
    List<Z> findAll();
}
