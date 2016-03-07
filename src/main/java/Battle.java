import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Battle {

  private int monsterSpeed = Monster.getMonsterSpeed();
  private int heroSpeed = Hero.getSpeed();
  private int heroAttack = Hero.getAttack();
  private int heroDefense = Hero.getDefense();
  private int heroStamina = Hero.getStamina();

  public boolean speedCheck() {
    if (heroSpeed >= monsterSpeed) {
      return true;
    } else {
      return false;
    }
  }

  public int regularAttack() {
    damage =
  }
}
