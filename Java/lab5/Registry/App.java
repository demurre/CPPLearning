package Registry;

import Registry.dal.error.DAOException;
import Registry.models.Article;
import Registry.presentation.TUI;
import Registry.services.Registry;

public class App {
    public static void main(String[] args) throws DAOException {
        System.out.println("Registry");
        Article first = new Article("Science",
                "Informatics",
                14);
        Article sec = new Article("Java",
                "Informatics",
                10);
        Registry service = new Registry();
        service.save(first);
        service.save(sec);
        TUI tui = new TUI();
        tui.showMenu(service);
    }
}
