import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Inventory {
  private int id;
  private String name;
  private String classification;

  public int getItemId() {
    return id;
  }

  public String getClassification() {
    return classification;
  }

  public String getItemName() {
    return name;
  }
}
