/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 3 - Thymeleaf
 */
package com.bookstore.service;

import java.util.List;

public interface GenericDao<E, K> {
    List<E> list();
    E find(K key);
}
