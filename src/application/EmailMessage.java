package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmailMessage {

  private SimpleStringProperty sender;
  private SimpleStringProperty subject;
  private IntegerProperty size;

  public EmailMessage(String Subject, String Sender, int size) {
    this.subject = new SimpleStringProperty(Subject);
    this.sender = new SimpleStringProperty(Sender);
    this.size = new SimpleIntegerProperty(size);
  }

  public String getSender() {
    return sender.get();
  }

  public String getSubject() {
    return subject.get();
  }

  public int getSize() {
    return size.get();
  }

}
