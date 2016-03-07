import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Monster {
  private String monsterName;
  private int monsterId;
  private int monsterDefense;
  private int monsterAttack;
  private int monsterGold;
  private int monsterSpeed;
  private int monsterStamina;
  private int monsterExp;


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
