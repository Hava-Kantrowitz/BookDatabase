package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Database {

  ArrayList<Book> getBooksByAuthor(String author);
  Book getBookByTitle(String title);
  String getTitleByBook(Book book);
  String getAuthorByBook(Book book);
  void addBook(String title, String author);
  void createDatabase(String fileName) throws FileNotFoundException;
  String getRecommendation(Book book);
  void alphabetize();
  void saveDatabase(String fileName) throws FileNotFoundException;
  void favorite(Book book);
  void unFavorite(Book book);
  void removeBook(Book book);

}
