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

  public lowLevelMonster(int monsterLevel) {
    this.monsterLevel = monsterLevel;
    this.monsterId = monsterId;
    this.setStats();
    this.setLowMonsterGold();
    this.setLowMonsterExperience();
  }

  public medLevelMonster(int monsterLevel) {
    this.monsterLevel = monsterLevel;
    this.monsterId = monsterId;
    this.setStats();
    this.setMedMonsterGold;
    this.setMedMonsterExperience;
  }

  public highLevelMonster(int monsterLevel) {
    this.monsterLevel = monsterLevel;
    this.monsterId = monsterId;
    this.setStats();
    this.setHighMonsterGold;
    this.setHighMonsterExperience;
  }

  public setStats() {
    if (monsterLevel == 1) {
      monsterAttack = 4;
      monsterDefense = 4;
      monsterSpeed = 4;
      monsterStamina = 8;
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
