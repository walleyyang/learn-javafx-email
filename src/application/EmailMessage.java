package application;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmailMessage {
  
  public static Map<String, Integer> formattedValues = new HashMap<String, Integer>();

  private SimpleStringProperty sender;
  private SimpleStringProperty subject;
  private SimpleStringProperty size;

  public EmailMessage(String Subject, String Sender, int size) {
    this.subject = new SimpleStringProperty(Subject);
    this.sender = new SimpleStringProperty(Sender);
    this.size = new SimpleStringProperty(formatSize(size));
  }

  public String getSender() {
    return sender.get();
  }

  public String getSubject() {
    return subject.get();
  }

  public String getSize() {
    return size.get();
  }
  
  private String formatSize(int size) {
    String returnValue;
    
    if (size <= 0) {
      returnValue = "0";
    }
    else if (size < 1024) {
      returnValue = size + " B";
    }
    else if (size < 1048576) {
      returnValue = size/1024 + " kB";
    }
    else {
      returnValue = size/1048576 + " MB";
    }
    
    formattedValues.put(returnValue,  size);
     
    return returnValue;
  }

}
