/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 4 - Forms and Data Validation
 */

package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bookstore.model.WishlistItem;
import com.bookstore.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao{
    private List<WishlistItem> wishlist = new ArrayList<WishlistItem>();

    public MemWishlistDao(){
        List<String> list1 = Arrays.asList("148487", "Computer Book");
        List<String> list2 = Arrays.asList("125487", "Science Book");
        List<String> list3 = Arrays.asList("879874", "History Book");
        List<String> list4 = Arrays.asList("145488", "Fun Book");
        List<String> list5 = Arrays.asList("879632", "Boring Book");
        wishlist.add(new WishlistItem(list1.get(0), list1.get(1)));
        wishlist.add(new WishlistItem(list2.get(0), list2.get(1)));
        wishlist.add(new WishlistItem(list3.get(0), list3.get(1)));
        wishlist.add(new WishlistItem(list4.get(0), list4.get(1)));
        wishlist.add(new WishlistItem(list5.get(0), list5.get(1)));
    }

    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        for(WishlistItem book : wishlist){
            if(book.getISBN().equals(key)) return book;
        }
        return new WishlistItem();
    }
}
