/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 9 - Crud Operations
 */

package com.bookstore.service;

import java.util.List;

public interface GenericCrudDao<E,K> {
    void add(E entity);
    void update(E entity);
    boolean remove(K key);
    List<E> list(K key);
    E find(K key);
}
