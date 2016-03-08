import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.Random;

public class Battle {

  private int monsterSpeed;
  private int monsterAttack;
  private int monsterDefense;
  private int monsterStamina;
  private int heroSpeed;
  private int heroAttack;
  private int heroDefense;
  private int heroStamina;


  public boolean regSpeedCheck() {
    if (heroSpeed >= monsterSpeed) {
      return true;
    } else {
      return false;
    }
  }

  public boolean powerSpeedCheck() {
    if (heroSpeed * (0.8) >= monsterSpeed) {
      return true;
    } else {
      return false;
    }
  }

  public int regularHeroAttack() {
    Random rand = new Random();
    int range = 2 - 1 + 1;
    int rn = rand.nextInt(range) + 1;
    int damage = (heroAttack * (rn)) - monsterDefense;

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
    int damage = (int)((heroAttack * (rn) - monsterDefense) * 1.3);

    if(damage > 0){
      return (int)damage;
    } else {
    damage = 0;
    }
    return (int)damage;
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
    int damage = (monsterAttack * (rn)) - heroDefense;

    if(damage > 0){
      return damage;
    } else {
    damage = 0;
    }
    return damage;
  }

  public void startBattle(int hero_id, int monster_id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO battle (hero_id, monster_id, hero_win) VALUES (:hero_id, :monster_id, :hero_win)";
      con.createQuery(sql)
      .addParameter("hero_id", hero_id)
      .addParameter("monster_id", monster_id)
      .addParameter("hero_win", false)
      .executeUpdate();
    }
  }

  public boolean determineWinner() {
    boolean monsterWin = true;
    if (monsterStamina == 0){
      monsterWin = false;
    }
    return monsterWin;
  }

  public void finishBattle() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE battle SET hero_win = true WHERE monster_id = :id";
      con.createQuery(sql)
      .addParameter("hero_win", true)
      .executeUpdate();
    }
  }
}
