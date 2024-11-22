package Registry.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Registry.models.Article;

public class ArticleDAOMapImpl implements ArticleDAO {
    private Map<String, Article> source;

    public ArticleDAOMapImpl() {
        source = new HashMap<String, Article>();
    }

    @Override
    public Article save(Article a) {
        if (source.containsKey(a.getTitle()))
            return null;
        return source.put(a.getTitle(), a);
    }

    @Override
    public Article get(String title) {
        if (source.containsKey(title))
            return null;
        return source.get(title);
    }

    @Override
    public List<Article> getAll() {
        return new ArrayList<Article>(source.values());
    }

    @Override
    public int count() {
        return source.size();
    }

    @Override
    public Article update(Article article) {
        if (source.containsKey(article.getTitle())) {
            return source.put(article.getTitle(), article);
        }
        return null;
    }

    @Override
    public void delete(String title) {
        source.remove(title);
    }

}
