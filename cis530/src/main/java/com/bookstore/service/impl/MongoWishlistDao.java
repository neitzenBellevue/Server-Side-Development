/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 9 - Crud Operations
 */

package com.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.bookstore.model.WishlistItem;
import com.bookstore.service.dao.WishlistDao;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<WishlistItem> list(String username){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));

        return mongoTemplate.find(query, WishlistItem.class);
    }

    @Override
    public void add(WishlistItem entity){
        mongoTemplate.save(entity);
    }

    @Override
    public void update(WishlistItem entity) {
        WishlistItem wishlistItem = mongoTemplate.findById(entity.getId(), WishlistItem.class);
        if (wishlistItem != null) {
            wishlistItem.setISBN(entity.getISBN());
            wishlistItem.setTitle(entity.getTitle());
            wishlistItem.setUsername(entity.getUsername());
            mongoTemplate.save(wishlistItem);
        }
    }

    @Override
    public boolean remove(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));
        mongoTemplate.remove(query, WishlistItem.class);
        return true;
    }

    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}
