package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

public class MainController implements Initializable {

  @FXML
  private WebView messageRenderer;

  @FXML
  private Button Button1;

  @FXML
  void Button1Action(ActionEvent event) {
    System.out.println("button1 clicked");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    messageRenderer.getEngine().loadContent("<html>test test</html>");
  }

}
