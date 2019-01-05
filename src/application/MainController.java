package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

public class MainController implements Initializable {

  @FXML
  private WebView messageRenderer;

  @FXML
  private Button Button1;

  @FXML
  private TableColumn<EmailMessage, String> subjectCol;

  @FXML
  private TableColumn<EmailMessage, String> senderCol;

  @FXML
  private TableColumn<EmailMessage, Integer> sizeCol;

  @FXML
  private TableView<EmailMessage> emailTableView;

  @FXML
  void Button1Action(ActionEvent event) {
    System.out.println("button1 clicked");
  }

  final ObservableList<EmailMessage> data = FXCollections.observableArrayList(
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040),
      new EmailMessage("Water Bill", "billing@fakewatercompany.com", 100),
      new EmailMessage("Phone Bill", "billing@fakephonecompany.com", 99),
      new EmailMessage("You Inherited $1 Million Dollars!", "phishing@spamemail.com", 125));

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    messageRenderer.getEngine().loadContent("<html>test test</html>");

    subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("subject"));
    senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("sender"));
    sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, Integer>("size"));
    
    emailTableView.setItems(data);
  }

}
