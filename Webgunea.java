import java.util.ArrayList;

public class Webgunea {
  private final String id;
  private final String url;
  private ArrayList<Webgunea> webguneZerrenda;

  public Webgunea(String url, String id) {
    this.id = id;
    this.url = url;
    this.webguneZerrenda = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public ArrayList<Webgunea> getWebguneZerrenda() {
    return webguneZerrenda;
  }

  public void setWebguneZerrenda(ArrayList<Webgunea> webguneZerrenda) {
    this.webguneZerrenda = webguneZerrenda;
  }
  
}
