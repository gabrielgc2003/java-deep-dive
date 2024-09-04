package example.br.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CrawlerTask implements Runnable{
    private final String url;
    private final WebCrawler webCrawler;

    public CrawlerTask(String url, WebCrawler webCrawler) {
        this.url = url;
        this.webCrawler = webCrawler;
    }

    @Override
    public void run() {
        try {
            Document document = fetchAndParse(url);
            processDocument(document);
        } catch (IOException | InterruptedException e) {
            System.err.println("Error crawling " + url + ": " + e.getMessage());
        }
    }

    private Document fetchAndParse(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Jsoup.parse(response.body());
    }

    private void processDocument(Document document) {
        // Extract links from the document
        System.out.println("Crawled: " + document.title());
    }
}
