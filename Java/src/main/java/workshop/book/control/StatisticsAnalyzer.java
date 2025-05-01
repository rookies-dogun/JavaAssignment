package workshop.book.control;


import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.*;

public class StatisticsAnalyzer {

    // 데이터 그룹핑
    public Map<String, List<Publication>> groupByPublication(Publication[] publications) {
        Map<String, List<Publication>> publicationMap = new HashMap<>();

        // 1차 전처리 ( 값을 분류 )
        for (Publication publication : publications) {
            if(publicationMap.containsKey(getPublicationType(publication))) {
                publicationMap.get(getPublicationType(publication)).add(publication);
            }else{
                List<Publication> publicationList = new ArrayList<>();
                publicationList.add(publication);
                publicationMap.put(getPublicationType(publication), publicationList);
            }


        }
        System.out.println(publicationMap);
        return publicationMap;
    }

    // 1). 타입별 평균 가격 계산 메서드
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, List<Publication>> publicationMap = groupByPublication(publications);

        // 합산
        Map<String, Double> averagePriceByType = new HashMap<>();
        for (String type : publicationMap.keySet()) {
            List<Publication> publicationList = publicationMap.get(type);
            Double averagePrice = (double) (publicationList.stream().mapToInt(Publication::getPrice).sum() / publicationList.size());
            averagePriceByType.put(type, averagePrice);

        }


        return averagePriceByType;


    }

    // 2). 출판물 유형 분포 계산 메서드
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, List<Publication>> publicationMap = groupByPublication(publications);
        Map<String, Double> distribution = new HashMap<>();

        int totalCount = publications.length;

        for (String type : publicationMap.keySet()) {
            int typeCount = publicationMap.get(type).size();
            double percentage = (double) typeCount / totalCount * 100;
            distribution.put(type, percentage);
        }
        return distribution;
    }

    // 3). 특정 연도 출판물 비율 계산 메서드
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {

        List<Publication> yearPublication = Arrays.stream(publications)
                .filter(publication -> publication.getPublishDate().substring(0, 4).equals(year))
                .toList();
        if (yearPublication.isEmpty()) return 0;

        return (double) yearPublication.size() / publications.length;

    }


    public String getPublicationType(Publication publication) {
        if (publication instanceof Novel) {
            return "소설";
        } else if (publication instanceof Magazine) {
            return "잡지";
        } else if (publication instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }


    // 5). 통계 정보 출력 메서드
    public void printStatistics(Publication[] publications) {

        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("=== 1). 타입별 평균 가격 계산 메서드 ===");
        Map<String, Double> averagePriceByType = calculateAveragePriceByType(publications);
        for (String type : averagePriceByType.keySet()) {
            System.out.println(type + " : " + df.format(averagePriceByType.get(type)));
        }

        System.out.println("=== 2). 출판물 유형 분포 계산 메서드 ===");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.println(type + " : " + df.format(distribution.get(type) * 100)+ "%");
        }

        String year = "2007";
        System.out.println("=== 3). "+ year +"년 출판물 비율 계산 메서드 ===");
        System.out.println(df.format(calculatePublicationRatioByYear(publications, year)* 100) + "%");


    }


}
