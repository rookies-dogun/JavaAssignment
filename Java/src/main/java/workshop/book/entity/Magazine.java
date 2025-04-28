package workshop.book.entity;

public class Magazine extends Publication {

    private String publishPeriod;

    public Magazine() {
        super();

    }
    public Magazine(String title, String author, int page, int price, String publishPeriod) {
        super(title, author, page, price);
        this.publishPeriod = publishPeriod;

    }

    public String getPublishPeriod() {
        return publishPeriod;
    }
}
