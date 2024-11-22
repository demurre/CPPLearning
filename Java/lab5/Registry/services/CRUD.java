package Registry.services;

import java.util.List;

import Registry.dal.error.DAOException;
import Registry.models.Article;

public interface CRUD {
    // Create
    Article save(Article a) throws DAOException;

    // Read
    Article get(String Title) throws DAOException;

    List<Article> getAll() throws DAOException;

    int count() throws DAOException;

    // Update
    Article update(Article a) throws DAOException;

    // Delete
    void delete(String Title) throws DAOException;
}
