package Registry.dal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import Registry.dal.error.DAOException;
import Registry.dal.error.DAONotFoundException;
import Registry.models.Article;

public class ArticleDAOFileImpl implements ArticleDAO {
    private static ArticleDAOFileImpl dao;
    private final String REPO_FOLDER_NAME;

    public ArticleDAOFileImpl(String repoFolderName) {
        REPO_FOLDER_NAME = repoFolderName;
    }

    private static final String DEFAULT_REPO_FOLDER_NAME = "article_repo";

    public static synchronized ArticleDAOFileImpl build(String repoFolderName) throws DAONotFoundException {
        if (dao == null) {
            if (repoFolderName != "") {
                try {
                    Files.createDirectories(Paths.get(repoFolderName));
                } catch (IOException e) {
                    throw new DAONotFoundException("Folder not found");
                }
                dao = new ArticleDAOFileImpl(repoFolderName);
            } else {
                try {
                    Files.createDirectories(Paths.get(DEFAULT_REPO_FOLDER_NAME));
                } catch (IOException e) {
                    throw new DAONotFoundException("Folder not found");
                }
            }
            dao = new ArticleDAOFileImpl(DEFAULT_REPO_FOLDER_NAME);
        }
        return dao;
    }

    @Override
    public Article save(Article article) throws DAOException {
        String fileName = REPO_FOLDER_NAME + "/" + article.getTitle();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
            out.writeObject(article);
            out.close();
        } catch (FileNotFoundException e) {
            throw new DAONotFoundException();
        } catch (IOException e) {
            throw new DAOException();
        }
        return article;
    }

    @Override
    public Article get(String title) throws DAOException {
        String fileName = REPO_FOLDER_NAME + "/" + title;
        File file = new File(fileName);
        if (!file.exists()) {
            throw new DAONotFoundException("Article '" + title + "' not found.");
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (Article) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DAOException("Error reading article: " + e.getMessage());
        }
    }

    @Override
    public List<Article> getAll() throws DAOException {
        List<Article> list = new LinkedList<>();
        File dir = new File(REPO_FOLDER_NAME);
        for (File f : dir.listFiles()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
                Article a = (Article) in.readObject();
                list.add(a);
            } catch (IOException | ClassNotFoundException e) {
                throw new DAOException();
            }
        }
        return list;
    }

    @Override
    public int count() {
        File dir = new File(REPO_FOLDER_NAME);
        return dir.listFiles().length;
    }

    @Override
    public Article update(Article updatedArticle) throws DAOException {
        String fileName = REPO_FOLDER_NAME + "/" + updatedArticle.getTitle();
        File file = new File(fileName);
        if (!file.exists()) {
            throw new DAONotFoundException("Article '" + updatedArticle.getTitle() + "' not found.");
        }
        file.delete();
        return save(updatedArticle);
    }

    @Override
    public void delete(String title) throws DAOException {
        String fileName = REPO_FOLDER_NAME + "/" + title;
        File file = new File(fileName);
        if (!file.exists()) {
            throw new DAONotFoundException("Article '" + title + "' not found.");
        }
        if (!file.delete()) {
            throw new DAOException("Error deleting article '" + title + "'.");
        }
    }
}
