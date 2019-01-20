package model;

import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleData {
  
  private final ObservableList<EmailMessage> Inbox = FXCollections.observableArrayList(
      new EmailMessage("Water Bill", "billing@fakewatercompany.com", 100, "Content"),
      new EmailMessage("Water Bill", "billing@fakewatercompany.com", 100, "Content"),
      new EmailMessage("Water Bill", "billing@fakewatercompany.com", 100, "Content"),
      new EmailMessage("Water Bill", "billing@fakewatercompany.com", 100, "Content")
      );
  
  private final ObservableList<EmailMessage> Sent = FXCollections.observableArrayList(
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Water Bill", "billing@fakewatercompany.com", 100, "Content"),
      new EmailMessage("Phone Bill", "billing@fakephonecompany.com", 99, "Content"),
      new EmailMessage("You Inherited $1 Million Dollars!", "phishing@spamemail.com", 125, "Content")
      );
  
  private final ObservableList<EmailMessage> Spam = FXCollections.observableArrayList(
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content"),
      new EmailMessage("Congrats You Won!", "marketing@spamemail.com", 5540040, "Content")
      );
  
  public Map<String, ObservableList<EmailMessage>> emailFolders = new HashMap<>();
  
  public SampleData() {
    emailFolders.put("Inbox", Inbox);
    emailFolders.put("Sent", Sent);
    emailFolders.put("Spam", Spam);
  }
  

}
