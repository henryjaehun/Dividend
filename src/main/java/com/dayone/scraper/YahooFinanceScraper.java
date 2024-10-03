package com.dayone.scraper;

import com.dayone.model.Company;
import com.dayone.model.Dividend;
import com.dayone.model.ScrapedResult;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YahooFinanceScraper {

    private static final String STATISTICS_URL =
            "https://finance.yahoo.com/quote/%s/history/?frequency=1mo&period1=%d&period2=%d";

    public ScrapedResult scrap(Company company) {
        var scrapResult = new ScrapedResult();
        scrapResult.setCompany(company);

        try {
            long start = 0;
            long end = 0;
            String url = String.format(STATISTICS_URL, company.getTicker(), start, end);
            Connection connection = Jsoup.connect(url);
            Document document = connection.get(); //get 으로 요청하고 파싱된 데이터 도큐멘트에 삽입

            Elements parsingDivs = document.getElementsByAttributeValue("data-testid", "history-table");
            Element tableEle = parsingDivs.get(0); // 테이블 전체

            Element tbody = tableEle.children().get(1);

            List<Dividend> dividends = new ArrayList<>();
            for (Element e : tbody.children()) {
                String txt = e.text();
                if (!txt.endsWith("Dividend")) {
                    continue;
                }

                String[] splits = txt.split(" ");
                String month = splits[0];
                int day = Integer.valueOf(splits[1].replace(",", ""));
                int year = Integer.valueOf(splits[2]);
                String dividend = splits[3];

//                System.out.println(year + "/" + month + "/" + day + " -> " + dividend);
            }
            scrapResult.setDividendEntities(dividends);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return scrapResult;
    }
}
