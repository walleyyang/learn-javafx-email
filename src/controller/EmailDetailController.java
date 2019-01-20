package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import model.Singleton;

public class EmailDetailController implements Initializable {

  private Singleton singleton;
  
  @FXML
  private Label senderLabel;

  @FXML
  private Label subjectLabel;

  @FXML
  private WebView webView;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    singleton = Singleton.getInstance();
    subjectLabel.setText("Subject: " + singleton.getMessage().getSubject());
    senderLabel.setText("Sender: " + singleton.getMessage().getSender());
    
    webView.getEngine().loadContent(singleton.getMessage().getContent());
  }

}
