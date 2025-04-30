package com.rookies3.myspringbootlab.repository;


import com.rookies3.myspringbootlab.entity.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookTest {

    public static BookRepositoryTest bookRepositoryTest;

    private String testIsbn = "924789621564";

    // BookRepositoryTest 생성, 책 넣기
    @BeforeAll
    public static void init(@Autowired BookRepository bookRepository) {
        bookRepositoryTest = new BookRepositoryTest(bookRepository);
        bookRepositoryTest.testCreateBook();
    }


    @Test
    public void testFindAll() {
        System.out.println("=== isbn 으로 찾기 ===");
        Book book = bookRepositoryTest.testFindByIsbn(testIsbn);

        System.out.println("=== 없는 isbn 조회 ===");
        Book notBook = bookRepositoryTest.testFindByIsbn("999999999999");

        System.out.println("=== author 로 조회 ===");
        bookRepositoryTest.testFindByAuthor("spring");

    }

    @Test
    public void testDeleteUpdate(){
        System.out.println("=== isbn 으로 update ===");
        bookRepositoryTest.UpdateBook(testIsbn, "루키", "루키", null);

        System.out.println("=== db 조회 ===");
        bookRepositoryTest.testFindByIsbn(testIsbn);

        Book book = bookRepositoryTest.testFindByIsbn(testIsbn);
        System.out.println("=== 책 삭제 ===");
        bookRepositoryTest.DeleteBook(book);

        System.out.println("=== db 조회 ===");
        bookRepositoryTest.testFindByIsbn(testIsbn);
    }


}
