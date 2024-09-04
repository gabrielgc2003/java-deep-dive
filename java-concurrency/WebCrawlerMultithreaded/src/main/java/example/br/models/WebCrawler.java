package example.br.models;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebCrawler {
    private final ExecutorService executorService;
    private final int numberOfThreads;

    public WebCrawler(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.executorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    public void startCrawling(String startUrl) {
        executorService.submit(new CrawlerTask(startUrl, this));
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
