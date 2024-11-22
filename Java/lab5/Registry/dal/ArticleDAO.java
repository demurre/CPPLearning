package Registry.dal;

import java.util.List;

import Registry.dal.error.DAOException;
import Registry.models.Article;

public interface ArticleDAO {
    // Create
    Article save(Article a) throws DAOException;

    // Read
    Article get(String title) throws DAOException;

    List<Article> getAll() throws DAOException;

    int count() throws DAOException;

    // Update
    Article update(Article a) throws DAOException;

    // Delete
    void delete(String title) throws DAOException;
}
