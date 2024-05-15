/*
 * Eitzen, N. (2024). CIS 530 Server Side Development. Bellevue University
 * Assignment 8 - OpenAPI/Swagger
 */

package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookstore.model.Book;
import com.bookstore.service.dao.BookDao;

public class RestBookDao implements BookDao {

    @Override
    public List<Book> list(String key) {
        Object doc = getBooksDoc(key);

        List<Book> books = new ArrayList<Book>();

        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index)));
        }

        return books;
        // Code provided by Professor
    }

    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        Book book = new Book(isbn, title, desc, numOfPages, infoUrl);

        return book;
        // Code provided by Professor
    }

    public Object getBooksDoc(String isbnString){
        String openLibraryUrl = "https://openlibrary.org/api/books";

        RestTemplate template = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(header);
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, entity,String.class);
        String bookList = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(bookList);
        // Parts of code provided by Professor
    }
}
