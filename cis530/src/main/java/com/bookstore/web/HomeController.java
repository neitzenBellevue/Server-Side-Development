/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Gold, P. (2021). Bellevue University 
 */ 
// Credited Professor Gold due to following along his classroom instructions.

package com.bookstore.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookstore.model.Book;
import com.bookstore.service.impl.MemBookDao;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method=RequestMethod.GET)
    public String showHome(Model model) {
        MemBookDao bookDao = new MemBookDao();
        List<Book> books = bookDao.list();

        for (Book book : books){
            System.out.println(book.toString());
        }

        model.addAttribute("books", books);

        return "index";
    }

    @RequestMapping(method=RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    @RequestMapping(method=RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {
        return "contact";
    }

    
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }
    
    @RequestMapping(method=RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model){
        String isbn = id;
        System.out.println(id);
        
        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());
        for(String author : book.getAuthors()){
            System.out.println(author);
        }

        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}



