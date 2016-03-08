import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Random;

public class Battle {


  private int monsterSpeed = Monster.getMonsterSpeed();
  private int monsterAttack = Monster.getMonsterAttack();
  private int monsterDefense = Monster.getMonsterDefense();
  private int monsterStamina = Monster.getMonsterStamina();
  private int heroSpeed = Hero.getSpeed();
  private int heroAttack = Hero.getAttack();
  private int heroDefense = Hero.getDefense();
  private int heroStamina = Hero.getStamina();


  public boolean regSpeedCheck() {
    if (heroSpeed >= monsterSpeed) {
      return true;
    } else {
      return false;
    }
  }

  public boolean powerSpeedCheck() {
    if (heroSpeed(0.8) >= monsterSpeed) {
      return true;
    } else {
      return false;
    }
  }

  public int regularHeroAttack() {
    Random rand = new Random();
    int range = 2 - 1 + 1;
    int rn = rand.nextInt(range) + 1;
    int damage = (heroAttack(rn)) - monsterDefense;

    if(damage > 0){
      return damage;
    } else {
    damage = 0;
    }
    return damage;
  }

  public int powerHeroAttack() {
    Random rand = new Random();
    int range = 2 - 1 + 1;
    int rn = rand.nextInt(range) + 1;
    int damage = (heroAttack(rn) - monsterDefense) * 1.3;

    if(damage > 0){
      return damage;
    } else {
    damage = 0;
    }
    return damage;
  }

  public Boolean monsterIsAlive(int damage) {
    monsterStamina -= damage;
    boolean isAlive = true;
    if (monsterStamina < 1) {
      isAlive = false;
    }
    return isAlive;
  }

  public int monsterAttack() {
    Random rand = new Random();
    int range = 2 - 1 + 1;
    int rn = rand.nextInt(range) + 1;
    int damage = (monsterAttack(rn)) - heroDefense;

    if(damage > 0){
      return damage;
    } else {
    damage = 0;
    }
    return damage;
  }
}
