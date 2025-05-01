package workshop.book.entity;

public class Publication {

    private String title;
    private String publishDate;
    private int page;
    private int price;


    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    public Publication() {

    }

    public String getPublishDate() {
        return publishDate;
    }
    public String getTitle() {
        return title;
    }
    public int getPrice() {
        return price;
    }
    public int getPage() {
        return page;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "Publication [title=" + title + ", publishDate=" + publishDate + ", page=" + page;
    }
}
