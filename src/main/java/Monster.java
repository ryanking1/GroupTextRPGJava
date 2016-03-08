import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Monster {
  private String monsterName;
<<<<<<< HEAD
  private int monsterId;
  private int monsterLevel;
=======
  private int monsterLevel;
  private int monsterId;
>>>>>>> 1b9e9a04cfc17e94863781c0a7e1ad6f702df65c
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

  public String getMonsterName() {
    return monsterName;
  }

  public int getMonsterId() {
    return monsterId;
  }

  public int getMonsterDefense() {
    return monsterDefense;
  }

  public int getMonsterAttack() {
    return monsterAttack;
  }
  public int getMonsterGold() {
    return monsterGold;
  }
  public int getMonsterSpeed() {
    return monsterSpeed;
  }
  public int getMonsterStamina() {
    return monsterStamina;
  }
  public int getMonsterExp() {
    return monsterExp;
  }
}
