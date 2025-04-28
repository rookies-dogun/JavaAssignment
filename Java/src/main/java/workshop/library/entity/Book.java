package workshop.library.entity;

public class Book {




    private String title;
    private String author;
    private String publishYear;
    private String isbn;
    private boolean isAvailable;

    public Book(){}
    public Book(String title, String author, String isbn, String publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.isbn = isbn;
        this.isAvailable = true;
    }
    public boolean checkOut(){
        if(this.isAvailable){
            this.isAvailable = false;
            return true;
        }else {
            return false;
        }
    }

    public boolean returnBook(){
        if(this.isAvailable){
            return false;
        }else{
            this.isAvailable = true;
            return true;
        }
    }
    @Override
    public String toString() {
        return "책 제목: " + this.title + " 저자: " + this.author + " isbn: " + this.isbn + " 출판년도: " + this.publishYear + " 대출 가능 여부: " + this.isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
