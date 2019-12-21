package view;

import javax.swing.*;

import model.Database;

public class BookshelfView extends JFrame {

  public BookshelfView(Database database) {
    super();
    this.setTitle("Bookshelf");
    this.setSize(1000, 1000);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //create background
  }

  public void render() {
    this.setVisible(true);

  }

}
