package view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ViewFactory {

  public Scene getMainScene() {
    Pane pane;

    try {
      pane = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
    } catch (IOException e) {
      pane = null;
      e.printStackTrace();
    }
    
    Scene scene = new Scene(pane);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    
    return scene;
  }
  
  public Scene getEmailDetailScene() {
    Pane pane;
    
    try {
      pane = FXMLLoader.load(getClass().getResource("EmailDetailLayout.fxml"));
    } catch (IOException e) {
      pane = null;
      e.printStackTrace();
    }
    
    Scene scene = new Scene(pane);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    
    return scene;
  }
  
  public Node resolveIcon(String treeitemValue) {
    String lowerCaseTreeItemValue = treeitemValue.toLowerCase();
    ImageView returnIcon;
    
    try {
      if (lowerCaseTreeItemValue.contains("inbox")) {
        returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/inbox.png")));
      }
      else if (lowerCaseTreeItemValue.contains("sent")) {
        returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/sent.png")));
      }
      else if (lowerCaseTreeItemValue.contains("spam")) {
        returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/spam.png")));
      }
      else if (lowerCaseTreeItemValue.contains("@")) {
        returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/email.png")));
      }
      else {
        returnIcon = new ImageView(new Image(getClass().getResourceAsStream("images/folder.png")));
      }
    } catch (NullPointerException e) {
      System.out.println("Invalid image location");
      e.printStackTrace();
      return new ImageView();
    }
    
    returnIcon.setFitHeight(16);
    returnIcon.setFitWidth(16);
    
    return returnIcon;
  }
  
}
