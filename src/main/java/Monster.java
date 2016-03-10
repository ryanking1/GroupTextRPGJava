import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
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

  public Monster(int monsterLevel) {
    this.monsterLevel = monsterLevel;
    this.monsterId = monsterId;
    this.setStats();
    this.setMonsterGold();
    this.setMonsterExperience();
  }

  public void setStats() {
    if (monsterLevel ==3) {
      monsterAttack = 4;
      monsterDefense = 4;
      monsterSpeed = 4;
      monsterStamina = 8;
    } else if (monsterLevel >=4 && monsterLevel <=5) {
      monsterAttack = 6;
      monsterDefense = 6;
      monsterSpeed = 6;
      monsterStamina = 12;
    } else if (monsterLevel >=6 && monsterLevel <=7) {
      monsterAttack = 8;
      monsterDefense = 8;
      monsterSpeed = 8;
      monsterStamina = 16;
    } else if (monsterLevel >=8 && monsterLevel <=9) {
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
    } else if (monsterLevel == 2) {
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

  public static int getHeroMonsterLevel() {

      return monsterLevel;
  }

  @Override
  public boolean equals(Object otherMonster){
    if (!(otherMonster instanceof Monster)) {
      return false;
    } else {
      Monster newMonster = (Monster) otherMonster;
      return this.getName().equals(newMonster.getName()) && this.getmonsterLevel() == newMonster.getmonsterLevel() && this.getMonsterId() == newMonster.getMonsterId() && this.getMonsterDefense() == newMonster.getMonsterDefense() && this.getmonsterAttack() == newMonster.getmonsterAttack() && this.getmonsterSpeed() == newMonster.getmonsterSpeed() && this.getmonsterStamina() == newMonster.getmonsterStamina() && this.getmonsterGold() == newMonster.getmonsterGold() && this.getmonsterExp() == newMonster.getmonsterExp();
    }
  }

  public static List<Monster> all() {
    String sql = " SELECT * FROM monster ORDER BY name";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Monster.class);
    }
  }

  public static Monster find(int monsterId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM monster WHERE id = :id";
      Monster monster = con.createQuery(sql)
      .addParameter("id", monsterId)
      .executeAndFetchFirst(Monster.class);
      return monster;
    }
  }

  public static Monster findMonsterLevel() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT monster_level FROM monster WHERE id = :id";
      Monster monster = con.createQuery(sql)
      .addParameter("id", monsterId)
      .executeAndFetchFirst(Monster.class);
      return monster;
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM monster WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();

      String joinDelete = "DELETE FROM battle WHERE monster_id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void update(String newName) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE monster SET name = :newName WHERE id = :id";
      con.createQuery(sql)
      .addParameter("name", newName)
      .addParameter("id", monsterId)
      .executeUpdate();
    }
  }
}
