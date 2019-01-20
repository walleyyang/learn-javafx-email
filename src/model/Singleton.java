package model;

public class Singleton {

  private Singleton() {}
  private static Singleton instance = new Singleton();
  
  public static Singleton getInstance() {
    return instance;
  }
  
  private EmailMessage message;
  
  public EmailMessage getMessage() {
    return message;
  }

  public void setMessage(EmailMessage message) {
    this.message = message;
  }  
  
}
