package Registry.services;

import java.util.List;

import Registry.models.Article;

public interface CRUD {
    // Create
    Article save(Article a);

    // Read
    Article get(String Title);

    List<Article> getAll();

    int count();

    // Update
    Article update(Article a);

    // Delete
    void delete(String Title);
}
