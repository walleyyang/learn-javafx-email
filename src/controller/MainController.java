package controller;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.EmailMessage;
import model.SampleData;
import model.Singleton;
import view.ViewFactory;

public class MainController implements Initializable {

  @FXML
  private WebView messageRenderer;

  @FXML
  private Button Button1;
  
  @FXML
  private TreeView<String> emailFoldersTreeView;
  private TreeItem<String> root = new TreeItem<>();
  private SampleData sampleData = new SampleData();
  private MenuItem showDetails = new MenuItem("show details");
  private Singleton singleton;

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

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ViewFactory viewFactory = new ViewFactory();
    singleton = Singleton.getInstance();
    subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("subject"));
    senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("sender"));
    sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessage, String>("size"));
    
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
    root.setGraphic(viewFactory.resolveIcon(root.getValue()));
    
    TreeItem<String> Inbox = new TreeItem<String>("Inbox", viewFactory.resolveIcon("Inbox"));
    TreeItem<String> Sent = new TreeItem<String>("Sent", viewFactory.resolveIcon("Sent"));
      TreeItem<String> Subitem1 = new TreeItem<String>("Subitem1", viewFactory.resolveIcon("Subitem1"));
      TreeItem<String> Subitem2 = new TreeItem<String>("Subitem2", viewFactory.resolveIcon("Subitem2"));
      Sent.getChildren().addAll(Subitem1, Subitem2);
    TreeItem<String> Spam = new TreeItem<String>("Spam", viewFactory.resolveIcon("Spam"));
    TreeItem<String> Trash = new TreeItem<String>("Trash", viewFactory.resolveIcon("Trash"));
    
    root.getChildren().addAll(Inbox, Sent, Spam, Trash);
    root.setExpanded(true);
    
    emailTableView.setContextMenu(new ContextMenu(showDetails));
    
    emailTableView.setOnMouseClicked(e -> {
      EmailMessage message = emailTableView.getSelectionModel().getSelectedItem();
      if (message != null) {
        messageRenderer.getEngine().loadContent(message.getContent());
        singleton.setMessage(message);
      }
    });
    
    emailFoldersTreeView.setOnMouseClicked(e ->  {
      TreeItem<String> item = emailFoldersTreeView.getSelectionModel().getSelectedItem();
      if (item != null) {
        emailTableView.setItems(sampleData.emailFolders.get(item.getValue()));
      }
    });
    
    showDetails.setOnAction(e -> {      
      Scene scene = viewFactory.getEmailDetailScene();
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.show();
      
    });
  }
  


}
