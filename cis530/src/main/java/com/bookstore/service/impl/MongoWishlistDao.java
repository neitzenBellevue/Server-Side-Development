/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 5 - MongoDB
 */

package com.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.bookstore.model.WishlistItem;
import com.bookstore.service.dao.WishlistDao;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<WishlistItem> list(){
        return (List<WishlistItem>) mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public void add(WishlistItem entity){
        mongoTemplate.save(entity);
    }

    @Override
    public void update(WishlistItem entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean remove(WishlistItem entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public WishlistItem find(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }


}
