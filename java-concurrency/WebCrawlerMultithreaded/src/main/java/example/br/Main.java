package example.br;

import example.br.models.WebCrawler;

public class Main {
    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler(10); // Number of threads
        crawler.startCrawling("https://www.istqb.org");

        // Wait for the crawling to finish
        try {
            Thread.sleep(30000); // 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        crawler.shutdown();
    }
}