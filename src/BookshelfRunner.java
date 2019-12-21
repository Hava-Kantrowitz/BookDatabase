import java.io.FileNotFoundException;

import model.BasicDatabase;
import view.BookshelfView;

public class BookshelfRunner {

  public static void main(String[] args) {
    BasicDatabase database = new BasicDatabase();
    try {
      database.createDatabase("C:\\Users\\havak\\IdeaProjects\\BookDatabase\\src\\TestingShelf");
    } catch (FileNotFoundException e) {
      System.out.println("The given file does not exist.");
    }

    BookshelfView view = new BookshelfView(database);
    view.render();
  }

}
