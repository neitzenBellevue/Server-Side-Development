/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Gold, P. (2021). Bellevue University 
 */ 
// Credited Professor Gold due to following along his classroom instructions.

package com.bookstore.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookstore.model.Book;
import com.bookstore.model.BookOfTheMonth;
import com.bookstore.service.dao.BookOfTheMonthDao;
import com.bookstore.service.impl.MongoBookOfTheMonthDao;
import com.bookstore.service.impl.RestBookDao;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class HomeController {

    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String showHome(Model model) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int calMonth = cal.get(Calendar.MONTH) + 1;

        RestBookDao bookDao = new RestBookDao();
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));

        StringBuilder isbnBuilder = new StringBuilder();
        isbnBuilder.append("ISBN:");

        for (BookOfTheMonth monthlyBook : monthlyBooks) {
            isbnBuilder.append(monthlyBook.getISBN()).append(",");
        }

        String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() - 1);

        List<Book> books = bookDao.list(isbnString);

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
        RestBookDao bookDao = new RestBookDao();

        Book book = bookDao.find(id);

        model.addAttribute("book", book);

        return "monthly-books/view";
    }
}



