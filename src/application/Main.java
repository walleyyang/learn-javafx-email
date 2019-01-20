package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewFactory;
import javafx.scene.Scene;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    ViewFactory viewFactory = new ViewFactory();
    
    Scene scene = viewFactory.getMainScene();
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }

}
