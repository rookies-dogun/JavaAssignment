package main.java.workshop.library.control;

import main.java.workshop.library.entity.Book;
import main.java.workshop.library.entity.Library;

public class LibraryManagementSystem {



    public static void main(String[] args) {
        Library library = new Library("중앙도서관");

        addSampleBooks(library);
        displayAvailableBooks(library);

        String isbn = "978-89-01-12345-6";
        testFindBooks(library,isbn);
        testCheckOut(library,isbn);
        testReturn(library,isbn);
    }

    public static void addSampleBooks(Library library){
        System.out.println("===== 도서 추가 =====");
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", "2022"));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", "2015"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", "2008"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", "2018"));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", "2005"));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", "2019"));
    }

    public static void displayAvailableBooks(Library library){

        System.out.println("===== 이용 가능한 도서 출력 =====");
        library.getAvailableBooks().forEach(System.out::println);
    }

    public static void testFindBooks(Library library, String isbn){
        System.out.println("===== 책 찾기 테스트 =====");
        Book book = library.findBookByIsbn(isbn);
        if(book != null){
            System.out.println(book.toString());
        }else{
            System.out.println("찾는 책이 없습니다.");
        }
    }
    public static void testCheckOut(Library library, String isbn){

        System.out.println("===== 책 대출 테스트 =====");
        library.checkoutBook(isbn);

    }
    public static void testReturn(Library library, String isbn){
        System.out.println("===== 책 반납 테스트 =====");
        library.returnBook(isbn);
    }
}
