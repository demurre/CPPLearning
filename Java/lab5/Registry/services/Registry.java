package Registry.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Registry.dal.ArticleDAO;
import Registry.dal.ArticleDAOFileImpl;
import Registry.dal.error.DAOAllReadyException;
import Registry.dal.error.DAOException;
import Registry.dal.error.DAONotFoundException;
import Registry.models.Article;

public class Registry implements CRUD, useCases {
    private ArticleDAO repo;

    public Registry() throws DAONotFoundException {
        repo = ArticleDAOFileImpl.build("");
    }

    @Override
    public Article save(Article a) throws DAOException {
        Article savedArticle = null;
        try {
            savedArticle = repo.save(a);
        } catch (DAOAllReadyException e) {
            System.err.println(e.getMessage());
        }
        return savedArticle;
    }

    @Override
    public Article get(String title) throws DAOException {
        try {
            return repo.get(title);
        } catch (DAONotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Article> getAll() throws DAOException {
        return repo.getAll();
    }

    @Override
    public int count() throws DAOException {
        return repo.count();
    }

    @Override
    public Article update(Article a) throws DAOException {
        try {
            return repo.update(a);
        } catch (DAONotFoundException e) {
            System.err.println(e.getMessage());
        }
        return a;
    }

    @Override
    public void delete(String title) throws DAOException {
        try {
            repo.delete(title);
        } catch (DAONotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Article> getArticlesOrderedByTitle() throws DAOException {
        return repo.getAll().stream()
                .sorted(Comparator.comparing(Article::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> getArticlesOrderedByPagesCount() throws DAOException {
        return repo.getAll().stream()
                .sorted(Comparator.comparingInt(Article::getPagesCount))
                .collect(Collectors.toList());
    }

    @Override
    public List<Article> getTheMostArticles(int pagesLimit) throws DAOException {
        return repo.getAll().stream()
                .filter(article -> article.getPagesCount() > pagesLimit)
                .collect(Collectors.toList());
    }

    @Override
    public int countTheMostArticlesInTopic(String topic, int pagesLimit) throws DAOException {
        return (int) repo.getAll().stream()
                .filter(article -> article.getTopic().equalsIgnoreCase(topic) && article.getPagesCount() > pagesLimit)
                .count();
    }
}
