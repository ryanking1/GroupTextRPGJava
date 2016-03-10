import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import org.sql2o.*;

public class Monster {
  private String monsterName;
  private int monsterLevel;
  private int monsterId;
  private int monsterDefense;
  private int monsterAttack;
  private int monsterSpeed;
  private int monsterStamina;
  private int monsterGold;
  private int monsterExp;

  public Monster(String monsterName, int monsterLevel) {
    this.monsterName = monsterName;
    this.monsterLevel = monsterLevel;
    this.monsterId = monsterId;
    this.setStats();
    this.setMonsterGold();
    this.setMonsterExperience();
  }

  public void setStats() {
    if (monsterLevel <=5) {
      monsterAttack = 4;
      monsterDefense = 4;
      monsterSpeed = 4;
      monsterStamina = 8;
    } else if (monsterLevel >=6 && monsterLevel <=8) {
      monsterAttack = 6;
      monsterDefense = 6;
      monsterSpeed = 6;
      monsterStamina = 12;
    } else if (monsterLevel >=9 && monsterLevel <=11) {
      monsterAttack = 8;
      monsterDefense = 8;
      monsterSpeed = 8;
      monsterStamina = 16;
    } else if (monsterLevel >=12 && monsterLevel <=15) {
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

  public int setMonsterGold() {
    monsterGold = ThreadLocalRandom.current().nextInt(5, 11 + 1);
    return monsterGold;
  }

  public int setMonsterExperience() {
    if (monsterLevel == 1) {
      monsterExp = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    } else if(monsterLevel == 2) {
        monsterExp = ThreadLocalRandom.current().nextInt(2, 4 + 1);
    } else if (monsterLevel == 3 || monsterLevel == 4 || monsterLevel == 5) {
        monsterExp = ThreadLocalRandom.current().nextInt(3, 5 + 1);
    } else if (monsterLevel == 6 || monsterLevel == 7 || monsterLevel == 8) {
        monsterExp = ThreadLocalRandom.current().nextInt(4, 6 + 1);
    } else {
        monsterExp = ThreadLocalRandom.current().nextInt(5, 7 + 1);
    }
    return monsterExp;
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

  public int getMonsterLevel() {
      return monsterLevel;
  }

  public int monsterAttack(int monsterAttack, int heroDefense) {
    int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    int damage = (monsterAttack * (random)) - heroDefense;

    if(damage > 0){
      return damage;
    } else {
    damage = 0;
    }
    return damage;
  }

  @Override
  public boolean equals(Object otherMonster){
    if (!(otherMonster instanceof Monster)) {
      return false;
    } else {
      Monster newMonster = (Monster) otherMonster;
      return this.getMonsterName().equals(newMonster.getMonsterName()) && this.getMonsterLevel() == newMonster.getMonsterLevel() && this.getMonsterId() == newMonster.getMonsterId() && this.getMonsterDefense() == newMonster.getMonsterDefense() && this.getMonsterAttack() == newMonster.getMonsterAttack() && this.getMonsterSpeed() == newMonster.getMonsterSpeed() && this.getMonsterStamina() == newMonster.getMonsterStamina() && this.getMonsterGold() == newMonster.getMonsterGold() && this.getMonsterExp() == newMonster.getMonsterExp();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO monster(monster_name, monster_defense, monster_attack, monster_gold, monster_speed, monster_stamina, monster_exp, monster_level) VALUES (:monsterName, :monsterDefense, :monsterAttack, :monsterGold, :monsterSpeed, :monsterStamina, :monsterExp, :monsterLevel)";
      this.monsterId = (int) con.createQuery(sql, true)
        .addParameter("monsterName", this.monsterName)
        .addParameter("monsterDefense", this.monsterDefense)
        .addParameter("monsterAttack", this.monsterAttack)
        .addParameter("monsterGold", this.monsterGold)
        .addParameter("monsterSpeed", this.monsterSpeed)
        .addParameter("monsterStamina", this.monsterStamina)
        .addParameter("monsterExp", this.monsterExp)
        .addParameter("monsterLevel", this.monsterLevel)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Monster> all() {
    String sql = " SELECT * FROM monster ORDER BY name";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Monster.class);
    }
  }

  public void updateMonsterStamina(int newMonsterStamina) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE monster SET monster_stamina = :newMonsterStamina WHERE id = :id";
      con.createQuery(sql)
      .addParameter("newMonsterStamina", newMonsterStamina)
      .addParameter("id", monsterId)
      .executeUpdate();
    }
  }

  public static Monster find(int monsterId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT id AS monsterId, monster_name AS monsterName, monster_defense AS monsterDefense, monster_attack AS monsterAttack, monster_gold AS monsterGold, monster_speed AS monsterSpeed, monster_stamina AS monsterStamina,  monster_exp AS monsterExp, monster_level AS monsterLevel FROM monster WHERE id = :id";
      Monster monster = con.createQuery(sql)
      .addParameter("id", monsterId)
      .executeAndFetchFirst(Monster.class);
      return monster;
    }
  }

  public Boolean isAlive() {
    int stamina = getMonsterStamina();
    boolean isAlive = true;
    if (stamina < 1) {
      isAlive = false;
    }
    return isAlive;
  }


  public static Monster findMonsterLevel(int monsterId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT monster_level FROM monster WHERE id = :id";
      Monster monster = con.createQuery(sql)
      .addParameter("id", monsterId)
      .executeAndFetchFirst(Monster.class);
      return monster;
    }
  }
}
