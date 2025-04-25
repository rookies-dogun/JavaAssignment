package main.java.workshop.library.entity;


import java.util.ArrayList;
import java.util.List;

public class Library {

    private String title;
    private List<Book> books;

    public Library(String title) {
        this.title = title;
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("도서가 추가되었습니다.:"+ book.getTitle());
    }


    public Book findBookByTitle(String title) {
        return this.books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }
    public Book findBookByIsbn(String isbn) {
        return this.books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
    public Book findBookByAuthor(String author) {
        return this.books.stream().filter(b -> b.getTitle().equals(author)).findFirst().orElse(null);
    }

    public void checkoutBook(String isbn){
        Book book = findBookByIsbn(isbn);
        if(book == null){
            System.out.println("대출 가능한 책이 없습니다.");
        }else if(!book.isAvailable()){
            System.out.println("현재 대출상태입니다.");
        }else{
            book.checkOut();
            System.out.println("대출이 완료되었습니다.");
            System.out.println("대출된 도서 정보:");
            System.out.println(book.toString());
        }
    }

    public void returnBook(String isbn){
        Book book = findBookByIsbn(isbn);

        if(book == null){
            System.out.println("반납 가능한 책이 없습니다.");
        }else if(book.isAvailable()){
            System.out.println("현재 대출상태가 아닙니다.");
        }else{
            book.checkOut();
            System.out.println("반납이 완료되었습니다.");
            System.out.println("반납된 도서 정보:");
            System.out.println(book.toString());
        }

    }

    public List<Book> getAvailableBooks() {
        return this.books.stream().filter(Book::isAvailable).toList();
    }

    public List<Book> getAllBooks() {
        return this.books;
    }


    public long getTotalBooks() {
        return this.books.size();
    }


    public long getAvailableBooksCount() {
        return this.books.stream().filter(Book::isAvailable).count();

    }
    public long getBorrowedBooksCount() {
        return this.books.stream().filter(book -> !book.isAvailable()).count();
    }



}
