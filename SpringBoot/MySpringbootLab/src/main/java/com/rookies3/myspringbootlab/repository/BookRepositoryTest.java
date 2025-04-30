package com.rookies3.myspringbootlab.repository;


import com.rookies3.myspringbootlab.entity.Book;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class BookRepositoryTest {

    private final BookRepository bookRepository;

    @Transactional
    public void testCreateBook(){
        List<Book> books = List.of(
                new Book("rookies1", "rookies", "924789621564", 30000, LocalDate.now().plusDays(4)),
                new Book("test rookies", "test", "456489321756", 30000, LocalDate.now().plusMonths(1)),
                new Book("java spring rookies", "java", "89210354987", 30000, LocalDate.now().plusDays(12).plusMonths(2)),
                new Book("spring rookies", "spring", "98723136648", 30000, LocalDate.now().plusDays(7)),
                new Book("boot rookies", "spring", "763321564684", 30000, LocalDate.now().plusDays(40)));
        bookRepository.saveAll(books);

        System.out.println("test Create Book Success");
        books.stream().forEach(System.out::println);
    }

    public Book testFindByIsbn(String isbn){

        Book book = bookRepository.findByIsbn(isbn).orElse(null);

        if(book != null){

            System.out.println("=== book found ===");
            System.out.println(book);

        }else{
            System.out.println("=== Book not found ===");

        }
        return book;

    }
    public void testFindByAuthor(String author){
        List<Book> books = bookRepository.findByAuthor(author);
        if(books != null){
            System.out.println("=== books found ===");
            books.forEach(System.out::println);
        }else {
            System.out.println("=== Book not found ===");
        }
    }
    @Transactional
    public void UpdateBook(String updatingBookIsbn, String updatingAuthor, String updatingTitle, Integer updatingPrice){
        Book updatingBook =  testFindByIsbn(updatingBookIsbn);
        if(updatingBook != null){
            if(updatingAuthor != null){
                updatingBook.setAuthor(updatingAuthor);
            }
            if(updatingTitle != null){
                updatingBook.setTitle(updatingTitle);
            }
            if(updatingPrice != null){
                updatingBook.setPrice(updatingPrice);
            }


            System.out.println("=== Update Book Success ===");
        }
    }
    @Transactional
    public void DeleteBook(Book book){
        bookRepository.delete(book);
        System.out.println("=== Delete Book Success ===");

    }


}
