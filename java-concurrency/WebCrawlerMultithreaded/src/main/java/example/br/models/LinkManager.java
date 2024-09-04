package example.br.models;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LinkManager {
    private final ConcurrentLinkedQueue<String> linkQueue = new ConcurrentLinkedQueue<>();
    private final Set<String> visitedLinks = ConcurrentHashMap.newKeySet();

    public void addLink(String link) {
        if (visitedLinks.add(link)) { // Add returns false if the link is already in the set
            linkQueue.offer(link);
        }
    }

    public String getNextLink() {
        return linkQueue.poll();
    }
}
