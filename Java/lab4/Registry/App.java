package Registry;

import Registry.models.Article;
import Registry.presentation.TUI;
import Registry.services.Registry;

public class App {
    public static void main(String[] args) {
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
        // for (Article s : service.getAll()) {
        // System.out.println(s);
        // }
        TUI tui = new TUI();
        tui.showMenu(service);
    }
}
