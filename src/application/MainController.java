package application;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

public class MainController implements Initializable {

  @FXML
  private WebView messageRenderer;

  @FXML
  private Button Button1;
  
  @FXML
  private TreeView<String> emailFoldersTreeView;
  private TreeItem<String> root = new TreeItem<String>();

  @FXML
  private TableColumn<EmailMessage, String> subjectCol;

  @FXML
  private TableColumn<EmailMessage, String> senderCol;

  @FXML
  private TableColumn<EmailMessage, String> sizeCol;

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
    sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("size"));
    
    emailTableView.setItems(data);
    
    sizeCol.setComparator(new Comparator<String>() { 
      Integer int1, int2;

      @Override
      public int compare(String o1, String o2) {
        int1 = EmailMessage.formattedValues.get(o1);
        int2 = EmailMessage.formattedValues.get(o2);
        
        return int1.compareTo(int2);
      }
      
    });
    
    emailFoldersTreeView.setRoot(root);
    
    root.setValue("test@gmail.com");
    root.setGraphic(resolveIcon(root.getValue()));
    
    TreeItem<String> Inbox = new TreeItem<String>("Inbox", resolveIcon("Inbox"));
    TreeItem<String> Sent = new TreeItem<String>("Sent", resolveIcon("Sent"));
      TreeItem<String> Subitem1 = new TreeItem<String>("Subitem1", resolveIcon("Subitem1"));
      TreeItem<String> Subitem2 = new TreeItem<String>("Subitem2", resolveIcon("Subitem2"));
      Sent.getChildren().addAll(Subitem1, Subitem2);
    TreeItem<String> Spam = new TreeItem<String>("Spam", resolveIcon("Spam"));
    TreeItem<String> Trash = new TreeItem<String>("Trash", resolveIcon("Trash"));
    
    root.getChildren().addAll(Inbox, Sent, Spam, Trash);
    root.setExpanded(true);
  }
  
  private Node resolveIcon(String treeitemValue) {
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
