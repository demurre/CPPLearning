package Registry.services;

import java.util.List;

import Registry.models.Article;

public interface useCases {
    // Print a list of all articles sorted alphabetically
    List<Article> getArticlesOrderedByTitle();

    // Print the specified number of articles sorted by the number of pages
    List<Article> getArticlesOrderedByPagesCount();

    // List articles with more than the specified number of pages
    List<Article> getTheMostArticles(int pagesLimit);

    // Determine the number of articles in a given subject that have more than a
    // given number of pages
    int countTheMostArticlesInTopic(String topic, int pagesLimit);
}
