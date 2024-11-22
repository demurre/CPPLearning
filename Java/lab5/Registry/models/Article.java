package Registry.models;

import java.io.Serializable;
import java.util.Objects;

public class Article implements Comparable<Article>, Serializable {

    private String title;
    private String topic;
    private int pagesCount;

    public Article(String title, String topic, int pagesCount) {
        this.title = title;
        this.topic = topic;
        this.pagesCount = pagesCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == "")
            return;
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        if (topic == "")
            return;
        this.topic = topic;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        if (pagesCount < 0)
            return;
        this.pagesCount = pagesCount;
    }

    @Override
    public String toString() {
        return "Article: " + title + " in topic: " + topic + " has " + pagesCount + " pages";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Article article = (Article) o;
        return pagesCount == article.pagesCount && Objects.equals(title, article.title)
                && Objects.equals(topic, article.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, topic, pagesCount);
    }

    @Override
    public int compareTo(Article other) {
        if (this.equals(other))
            return 0;
        return this.pagesCount - other.pagesCount;
    }

}