package Registry.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Registry.dal.error.DAOAllReadyException;
import Registry.dal.error.DAONotFoundException;
import Registry.models.Article;

public class ArticleDAOMapImpl implements ArticleDAO {
    private static ArticleDAOMapImpl dao;
    private Map<String, Article> source;

    public ArticleDAOMapImpl() {
        source = new HashMap<String, Article>();
    }

    public static synchronized ArticleDAOMapImpl build() {
        if (dao == null)
            dao = new ArticleDAOMapImpl();
        return dao;
    }

    @Override
    public Article save(Article a) throws DAOAllReadyException {
        if (source.containsKey(a.getTitle()))
            throw new DAOAllReadyException("Article is already used");
        return source.put(a.getTitle(), a);
    }

    @Override
    public Article get(String title) throws DAONotFoundException {
        if (source.containsKey(title))
            return source.get(title);
        else
            throw new DAONotFoundException("Article not found");
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
    public Article update(Article article) throws DAONotFoundException {
        if (source.containsKey(article.getTitle())) {
            return source.put(article.getTitle(), article);
        }
        throw new DAONotFoundException("Article does not exist");
    }

    @Override
    public void delete(String title) throws DAONotFoundException {
        source.remove(title);
        throw new DAONotFoundException("Article does not exist");
    }

}
