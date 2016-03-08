import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Monster {
  private String monsterName;
  private int monsterId;
  private int monsterLevel;
  private int monsterDefense;
  private int monsterAttack;
  private int monsterSpeed;
  private int monsterStamina;
  private int monsterGold;
  private int monsterExp;

  public Monster(int monsterLevel) {
    this.monsterLevel = monsterLevel;
    this.monsterId = monsterId;
    this.setStats();
    this.setMonsterGold();
    this.setMonsterExperience();
  }

  public void setStats() {
    if (monsterLevel >= 1 && monsterLevel <=2) {
      monsterAttack = 4;
      monsterDefense = 4;
      monsterSpeed = 4;
      monsterStamina = 8;
    } else if (monsterLevel >=3 && monsterLevel <=4) {
      monsterAttack = 6;
      monsterDefense = 6;
      monsterSpeed = 6;
      monsterStamina = 12;
    } else if (monsterLevel >=5 && monsterLevel <=6) {
      monsterAttack = 8;
      monsterDefense = 8;
      monsterSpeed = 8;
      monsterStamina = 16;
    } else if (monsterLevel >=7 && monsterLevel <=8) {
      monsterAttack = 10;
      monsterDefense = 10;
      monsterSpeed = 10;
      monsterStamina = 20;
    } else {
      monsterAttack = 12;
      monsterDefense = 12;
      monsterSpeed = 12;
      monsterStamina = 28;
    }
  }

  public static String getMonsterName() {
    return monsterName;
  }

  public static int getMonsterId() {
    return monsterId;
  }

  public static int getMonsterDefense() {
    return monsterDefense;
  }

  public static int getMonsterAttack() {
    return monsterAttack;
  }
  public static int getMonsterGold() {
    return monsterGold;
  }
  public static int getMonsterSpeed() {
    return monsterSpeed;
  }
  public static int getMonsterStamina() {
    return monsterStamina;
  }
  public static int getMonsterExp() {
    return monsterExp;
  }
}
