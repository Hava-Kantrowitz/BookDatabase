package model;

public class Book {

  private String title;
  private String author;
  private boolean isFavorite;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public void makeFavorite() {
    isFavorite = true;
  }

  public void unFavorite() {
    isFavorite = false;
  }

  public boolean isFavorite() {
    return isFavorite;
  }

}
