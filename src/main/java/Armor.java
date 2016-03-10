import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Armor {
  private String armorName;
  private int armorId;
  private int armorDefense;


  public String getArmorName() {
    return armorName;
  }

  public int getArmorId() {
    return armorId;
  }

  public int getArmorDefense() {
    return armorDefense;
  }

  public void update(String armorName, int armorDefense, int id) {
    this.armorName = armorName;
    this.armorDefense = armorDefense;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero_armor SET armorName = :armorName, armorDefense = :armorDefense WHERE id = :id";
      con.createQuery(sql)
        .addParameter("armorName", armorName)
        .addParameter("armorDefense", armorDefense)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
}
