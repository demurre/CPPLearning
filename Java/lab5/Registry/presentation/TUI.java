package Registry.presentation;

import java.util.List;
import java.util.Scanner;

import Registry.dal.error.DAOException;
import Registry.models.Article;
import Registry.services.Registry;

public class TUI {
    public void showMenu(Registry service) throws DAOException {
        String title, topic;
        int number, limit;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Registry List");
            System.out.println("1. Use cases");
            System.out.println("2. List of all articles");
            System.out.println("3. Update the article");
            System.out.println("4. Add an article");
            System.out.println("5. Delete article");
            System.out.println("6. Exit");
            System.out.println("\nChoose option: ");
            number = scanner.nextInt();
            scanner.nextLine();
            List<Article> tempArticle;

            switch (number) {
                case 1:
                    System.out.println("1. Print a list of all articles sorted alphabetically");
                    System.out.println("2. Print the specified number of articles sorted by the number of pages");
                    System.out.println("3. List articles with more than the specified number of pages");
                    System.out.println(
                            "4. Determine the number of articles in a given subject that have more than a given number of pages");
                    System.out.println("\nChoose option: ");

                    int subNumber = scanner.nextInt();
                    switch (subNumber) {
                        case 1:
                            tempArticle = service.getArticlesOrderedByTitle();
                            for (Article a : tempArticle)
                                System.out.println(a);
                            break;
                        case 2:
                            tempArticle = service.getArticlesOrderedByPagesCount();
                            for (Article a : tempArticle)
                                System.out.println(a);
                            break;
                        case 3:
                            System.out.println("Input PagesLimit: ");
                            limit = scanner.nextInt();
                            tempArticle = service.getTheMostArticles(limit);
                            for (Article a : tempArticle)
                                System.out.println(a);
                            break;
                        case 4:
                            System.out.println("Input topic: ");
                            topic = scanner.next();
                            System.out.println("Input PagesLimit: ");
                            limit = scanner.nextInt();
                            System.out.println(service.countTheMostArticlesInTopic(topic, limit));
                            break;
                        default:
                            System.out.println("Invalid sub-option");
                    }
                    break;
                case 2:
                    tempArticle = service.getAll();
                    for (Article a : tempArticle)
                        System.out.println(a);
                    break;
                case 3:
                    System.out.println("Input title: ");
                    title = scanner.nextLine();
                    if (title != null) {
                        System.out.println("Input new topic: ");
                        topic = scanner.next();
                        System.out.println("Input new pages count: ");
                        limit = scanner.nextInt();
                        service.update(new Article(title, topic, limit));
                        System.out.println("Successful");
                    }
                    break;
                case 4:
                    System.out.println("Input title: ");
                    title = scanner.nextLine();
                    System.out.println("Input topic: ");
                    topic = scanner.nextLine();
                    System.out.println("Input pages count: ");
                    limit = scanner.nextInt();
                    service.save(new Article(title, topic, limit));
                    break;
                case 5:
                    System.out.println("Input article title: ");
                    title = scanner.nextLine();
                    service.delete(title);
                    System.out.println("Deleted");
                    break;
                default:
                    System.out.println("Exit");
            }

        } while (number != 6);

        scanner.close();
    }
}