/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 10 - Authorization in Action
 */

package com.bookstore.service;

import java.util.List;

public interface GenericDao<E, K> {
    List<E> list(K key);
    E find(K key);
}
