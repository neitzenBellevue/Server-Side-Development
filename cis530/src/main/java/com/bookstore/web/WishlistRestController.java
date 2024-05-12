/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 9 - Crud Operations
 */

package com.bookstore.web;

import com.bookstore.model.WishlistItem;
import com.bookstore.service.dao.WishlistDao;
import com.bookstore.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {
    WishlistDao wishlistDao = new MongoWishlistDao();

    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistItem> showWishlist(Authentication authentication) {
        String username = authentication.getName();
        return wishlistDao.list(username);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }
}
