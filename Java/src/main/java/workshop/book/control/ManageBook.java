package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

    public static void main(String[] args) {
        ShoppingCart bookCatalog = new ShoppingCart();

        bookCatalog.addItem(new Novel("마이크로소프트", "2007-10-31", 325, 9900, "Bill Gates", "과학"));
        bookCatalog.addItem(new Novel("빠삐용", "2007-03-21", 200, 10000, "Bill Gates", "현대소설"));
        bookCatalog.addItem(new Novel("소년", "2021-05-25", 100, 6000, "Bill Gates", "현대소설"));

        bookCatalog.addItem(new Magazine("경영과 컴퓨터", "2007-10-03", 72, 9000, "매월"));
        bookCatalog.addItem(new Magazine("잡지 테스터", "2009-10-03", 72, 6000, "매주"));
        bookCatalog.addItem(new Magazine("SKT 경영", "2024-09-03", 72, 5000, "매월"));

        bookCatalog.addItem(new ReferenceBook("Spring Boot", "2016-07-23", 500, 32500, "필드"));
        bookCatalog.addItem(new ReferenceBook("Boot", "2018-07-23", 500, 43000, "필드"));
        bookCatalog.addItem(new ReferenceBook("Spring", "2019-07-23", 500, 17000, "필드"));

        // 분석 시작
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        System.out.println("=== 도서 목록 ===");
        bookCatalog.printItems();


        analyzer.printStatistics(bookCatalog.getItems().toArray(new Publication[0]));

    }


}
