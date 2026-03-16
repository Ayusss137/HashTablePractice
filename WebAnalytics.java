import java.util.*;

public class WebAnalytics {

    private Map<String, Integer> pageViews = new HashMap<>();
    private Map<String, Set<String>> uniqueVisitors = new HashMap<>();
    private Map<String, Integer> trafficSources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSources.put(source, trafficSources.getOrDefault(source, 0) + 1);
    }

    public void showDashboard() {

        System.out.println("Page Views:");
        pageViews.forEach((k,v) -> System.out.println(k + " -> " + v));

        System.out.println("\nUnique Visitors:");
        uniqueVisitors.forEach((k,v) -> System.out.println(k + " -> " + v.size()));

        System.out.println("\nTraffic Sources:");
        trafficSources.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    public static void main(String[] args) {

        WebAnalytics system = new WebAnalytics();

        system.processEvent("/home","user1","google");
        system.processEvent("/home","user2","facebook");
        system.processEvent("/sports","user1","direct");

        system.showDashboard();
    }
}

