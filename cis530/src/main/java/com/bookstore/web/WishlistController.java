/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 4 - Forms and Data Validation
 */

package com.bookstore.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookstore.model.WishlistItem;
import com.bookstore.service.impl.MemWishlistDao;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @RequestMapping(method=RequestMethod.GET)
    public String showWishlist(Model model){
        MemWishlistDao list = new MemWishlistDao();
        List<WishlistItem> wishlist = list.list();
        model.addAttribute("wishlist", wishlist);
        return "wishlist/list";
    }

    @RequestMapping(method=RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model){
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult){
        System.out.println(wishlistItem.toString());
        System.out.println(bindingResult.getAllErrors());

        if(bindingResult.hasErrors()){
            return "wishlist/new";
        }
        else return "redirect:/wishlist";
    }
}
