import org.junit.Test;

import java.io.FileNotFoundException;

import model.BasicDatabase;
import model.Book;

import static org.junit.Assert.assertEquals;

public class BookTests {

  @Test
  public void testAddBook() {
    BasicDatabase database = new BasicDatabase();
    database.addBook("The Hunger", "Alma Katsu");
    Book hunger = new Book("The Hunger", "Alma Katsu");
    assertEquals(database.getBookByTitle("The Hunger").getTitle(), hunger.getTitle());
    assertEquals(database.getBooksByAuthor("Alma Katsu").get(0).getAuthor(), hunger.getAuthor());
  }

  @Test
  public void testNonemptyFile() throws FileNotFoundException {
    BasicDatabase database = new BasicDatabase();
    Book hunger = new Book("The Hunger", "Alma Katsu");
    database.createDatabase("C:\\Users\\havak\\IdeaProjects\\BookDatabase\\src\\TestingShelf");
    assertEquals(database.getBookByTitle("The Hunger").getTitle(), hunger.getTitle());
    assertEquals(database.getBookByTitle("we have always lived in the castle").getTitle(), "We Have Always Lived in the" +
            " Castle");
  }

  @Test
  public void testFile() throws FileNotFoundException {
    //THIS SAVE DOES NOT WORK
    BasicDatabase database = new BasicDatabase();
    database.createDatabase("C:\\Users\\havak\\IdeaProjects\\BookDatabase\\src\\TestingShelf");
    Book games = new Book("Hunger Games", "Suzanne Collins");
    database.addBook("Hunger Games", "Suzanne Collins");
    database.saveDatabase("C:\\Users\\havak\\IdeaProjects\\BookDatabase\\src\\TestingShelf");
  }

}
