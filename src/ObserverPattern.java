import java.util.ArrayList;
import java.util.List;

// Subject
class NewsAgency {
    private final List<Subscriber> subscribers = new ArrayList<>();
    private String news;
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
    public void addNews(String news) {
        this.news = news;
        notifySubscribers();
    }
}

// Observer
interface Subscriber {
    void update(String news);
}

// Concrete Observer - Newspaper
class Newspaper implements Subscriber {
    @Override
    public void update(String news) {
        System.out.println("Newspaper received news: " + news);
    }
}

// Concrete Observer - TVChannel
class TVChannel implements Subscriber {
    @Override
    public void update(String news) {
        System.out.println("TV Channel received news: " + news);
    }
}

// Usage
public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Newspaper newspaper = new Newspaper();

        TVChannel tvChannel = new TVChannel();

        newsAgency.addSubscriber(newspaper);

        newsAgency.addSubscriber(tvChannel);

        newsAgency.addNews("Breaking News: NEW NEWS!");
    }
}

