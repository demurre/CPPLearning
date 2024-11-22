package Registry.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Registry.dal.ArticleDAOMapImpl;
import Registry.models.Article;

public class Registry implements CRUD, useCases {
    private ArticleDAOMapImpl repo;

    public Registry() {
        repo = new ArticleDAOMapImpl();
    }

    @Override
    public Article save(Article a) {
        Article savedArticle = repo.save(a);
        if (savedArticle == null)
            return null;
        return savedArticle;
    }

    @Override
    public Article get(String title) {
        return repo.get(title);
    }

    @Override
    public List<Article> getAll() {
        return repo.getAll();
    }

    @Override
    public int count() {
        return repo.count();
    }

    @Override
    public Article update(Article a) {
        return repo.update(a);
    }

    @Override
    public void delete(String title) {
        repo.delete(title);
    }

    @Override
    public List<Article> getArticlesOrderedByTitle() {
        return repo.getAll().stream()
                .sorted(Comparator.comparing(Article::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> getArticlesOrderedByPagesCount() {
        return repo.getAll().stream()
                .sorted(Comparator.comparingInt(Article::getPagesCount))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> getTheMostArticles(int pagesLimit) {
        return repo.getAll().stream()
                .filter(article -> article.getPagesCount() > pagesLimit)
                .collect(Collectors.toList());
    }

    @Override
    public int countTheMostArticlesInTopic(String topic, int pagesLimit) {
        return (int) repo.getAll().stream()
                .filter(article -> article.getTopic().equalsIgnoreCase(topic) && article.getPagesCount() > pagesLimit)
                .count();
    }
}
