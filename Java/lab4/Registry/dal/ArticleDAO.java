package Registry.dal;

import java.util.List;

import Registry.models.Article;

public interface ArticleDAO {
    // Create
    Article save(Article a);

    // Read
    Article get(String title);

    List<Article> getAll();

    int count();

    // Update
    Article update(Article a);

    // Delete
    void delete(String title);
}
