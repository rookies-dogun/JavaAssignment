package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
    }

    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public int calculateDiscountedPrice() {
        int discount = 0;
        for (Publication item : items) {
            if (item instanceof Novel) {
                discount += (int) (((Novel) item).getPrice() * 0.15);
            } else if (item instanceof ReferenceBook) {
                discount += (int) (((ReferenceBook) item).getPrice() * 0.2);

            } else if (item instanceof Magazine) {
                discount += (int) (((Magazine) item).getPrice() * 0.1);

            } else {
                continue;
            }
        }
        return discount;
    }



    public List<Publication> getItems() {
        return items;
    }
    public void printItems() {

        int i = 1;
        for (Publication item : items) {
            if (item instanceof Novel) {
                System.out.println(i + ". " + item.getTitle() + " [소설] " + " 저자 : " + ((Novel) item).getAuthor() + ", 장르 :" + ((Novel) item).getGenre() + ", " + item.getPage() + "쪽, " + item.getPrice() + "원, 출판일:" + item.getPublishDate());
            } else if (item instanceof ReferenceBook) {
                System.out.println(i + ". " + item.getTitle() + " [참고서] " + ", 분야 :" + ((ReferenceBook) item).getField() + ", " + item.getPage() + "쪽, " + item.getPrice() + "원, 출판일:" + item.getPublishDate());

            } else if (item instanceof Magazine) {
                System.out.println(i + ". " + item.getTitle() + " [잡지] " + ", 발행주기 :" + ((Magazine) item).getPublishPeriod() + ", " + item.getPage() + "쪽, " + item.getPrice() + "원, 출판일:" + item.getPublishDate());
            } else {
                continue;
            }
            i++;
        }
    }

}
