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
}
