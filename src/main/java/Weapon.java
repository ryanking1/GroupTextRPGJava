import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Weapon {
  private String wepName;
  private int wepId;
  private int wepDamage;

  public String getWeaponName() {
    return wepName;
  }

  public int getWeaponId() {
    return wepId;
  }

  public int getWeaponDamage() {
    return wepDamage;
  }

  public void update(String wepName, int wepDamage, int id) {
    this.wepName = wepName;
    this.wepDamage = wepDamage;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero_weapon SET wepName = :wepName, wepDamage = :wepDamage WHERE id = :id";
      con.createQuery(sql)
        .addParameter("wepName", wepName)
        .addParameter("wepDamage", wepDamage)
        .addParameter("id", id)
        .executeUpdate();
    }
  }
}
