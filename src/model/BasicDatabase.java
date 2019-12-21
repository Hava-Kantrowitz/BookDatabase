package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BasicDatabase implements Database {

  private ArrayList<Book> database = new ArrayList<>();

  @Override
  public void createDatabase(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    String title;
    String author;
    String input;

    while (sc.hasNextLine()) {
      input = sc.nextLine();
      author = parseAuthor(input).stripTrailing();
      title = parseTitle(input).stripTrailing();
      Book book = new Book(title, author);
      database.add(book);
    }
  }

  /**
   * Must be in form Title by Author
   */
  private String parseTitle(String input) {

    StringBuilder title = new StringBuilder();

    String[] words = input.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (words[i].contentEquals("by")) {
        for (int j = 0; j < i; j++) {
          title.append(words[j]).append(" ");
        }
        i = words.length;
      }
    }

    return title.toString();
  }

  private String parseAuthor(String input) {
    StringBuilder author = new StringBuilder();

    String[] words = input.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (words[i].contentEquals("by")) {
        for (int j = i+1; j < words.length; j++) {
          author.append(words[j]).append(" ");
        }
        i = words.length;
      }
    }

    return author.toString();
  }

  @Override
  public ArrayList<Book> getBooksByAuthor(String author) throws IllegalArgumentException {
    ArrayList<Book> authorBooks = new ArrayList<>();
    for (Book b : database) {
      if (author.toLowerCase().equals(b.getAuthor().toLowerCase())) {
        authorBooks.add(b);
      }
    }

    if (authorBooks.size() < 1) {
      throw new IllegalArgumentException("There are no books by this author in the database");
    }

    return authorBooks;
  }

  @Override
  public Book getBookByTitle(String title) throws IllegalArgumentException {
    Book book = null;
    for (Book b : database) {
      if (title.toLowerCase().equals(b.getTitle().toLowerCase())) {
        book = b;
      }
    }

    if (book == null) {
      throw new IllegalArgumentException("This book does not exist within database");
    }

    return book;
  }

  @Override
  public String getTitleByBook(Book book) {
    return book.getTitle();
  }

  @Override
  public String getAuthorByBook(Book book) {
    return book.getAuthor();
  }

  @Override
  public void addBook(String title, String author) {
    Book addedBook = new Book(title, author);
    database.add(addedBook);
  }

  @Override
  public String getRecommendation(Book book) {
    return null;
  }

  @Override
  public void alphabetize() {

  }

  @Override
  public void saveDatabase(String fileName) throws FileNotFoundException {
    PrintWriter file = new PrintWriter(fileName);
    for (Book b : database) {
      file.println(b.getTitle() + " by " + b.getAuthor());
    }
  }

  @Override
  public void favorite(Book book) {
    book.makeFavorite();
  }

  @Override
  public void unFavorite(Book book) {
    book.unFavorite();
  }

  @Override
  public void removeBook(Book book) {
    database.remove(book);
  }
}
