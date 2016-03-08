import java.util.List;
import java.util.ArrayList;
// import org.apache.commons.lang.WordUtils;
// import java.util.Date;
// import java.util.Calendar;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
import org.sql2o.*;

public class Hero {
  private int id;
  private int beardChoice;
  private String name;
  private int experience;
  private int gold;
  private int attack;
  private int defense;
  private int speed;
  private int stamina;
  private final static int MIN_STAMINA = 0;
  private final static int MIN_ATTACK = 0;
  private final static int MIN_DEFENSE = 0;
  private final static int MIN_SPEED = 0;
  private final static int MIN_GOLD = 0;
  private final static int MAX_STAMINA = 50;
  private final static int MAX_ATTACK = 15;
  private final static int MAX_DEFENSE = 15;
  private final static int MAX_SPEED = 15;
  private final static int MAX_GOLD = 15;


  public Hero(String name, int beardChoice) {
    this.name = name;
    this.beardChoice = beardChoice;
    this.setExperience();
    this.setStats(beardChoice);
  }

  public int getId() {
    return id;
  }

  public int getExperience() {
    return experience;
  }

  public String getName() {
    return name;
  }

  public int getCurrency() {
    return gold;
  }

  public int getAttack() {
    return attack;
  }

  public int getDefense() {
    return defense;
  }

  public int getSpeed() {
    return speed;
  }

  public int getStamina() {
    return stamina;
  }

  public int setExperience() {
    experience = 0;
  }

  public void setStats(int beardChoice) {
    if (beardChoice == 1) {
      this.speed = 5;
      this.defense = 3;
      this.attack = 3;
      this.stamina = 10;
    } else if (beardChoice == 2) {
      this.speed = 3;
      this.defense = 5;
      this.attack = 3;
      this.stamina = 10;
    } else {
      this.speed = 3;
      this.defense = 3;
      this.attack = 5;
      this.stamina = 10;
    }
  }

  public Boolean isAlive() {
    int stamina = getStamina();
    boolean isAlive = true;
    if (stamina < 1) {
      isAlive = false;
    }
    return isAlive;
  }

  public static getMonsterLevel(int attack, intdefense, int speed) {
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
    int monsterLevel = (attack + defense + speed)/3;
    // (int) Math.ceil(statAverage / 100.0) - 2;
    return monsterLevel;
  }

  public void levelUpAttack() {
    try(Connection con = DB.sql20.open()) {
      String sql = "UPDATE hero SET attack = attack + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpDefense() {
    try(Connection con = DB.sql20.open()) {
      String sql = "UPDATE hero SET defense = defense + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpSpeed() {
    try(Connection con = DB.sql20.open()) {
      String sql = "UPDATE hero SET speed = speed + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpStamina() {
    try(Connection con = DB.sql20.open()) {
      String sql = "UPDATE hero SET speed = speed + 2 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO hero(beard_choice, name, experience, gold, attack, defense, speed, stamina) VALUES (:beardChoice, :name, :experience, :gold, :attack, :defense, :speed, :stamina)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("beardChoice", this.beardChoice)
        .addParameter("name", this.name)
        .addParameter("experience", this.experience)
        .addParameter("gold", this.gold)
        .addParameter("attack", this.attack)
        .addParameter("defense", this.defense)
        .addParameter("speed", this.speed)
        .addParameter("stamina", this.stamina)
        .executeUpdate()
        .getKey();
    }
  }

  public void delete() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "DELETE FROM hero WHERE id = :id";
     con.createQuery(sql)
     .addParameter("id", id)
     .executeUpdate();

    String inventoryDeleteQuery = "DELETE FROM inventory WHERE hero_id = :id";
    con.createQuery(inventoryDeleteQuery)
    .addParameter("id", this.getId())
    .executeUpdate();

    String battleDeleteQuery = "DELETE FROM battle WHERE hero_id = :id";
    con.createQuery(weaponDeleteQuery)
    .addParameter("id", this.getId())
    .executeUpdate();
    }

  public void update(String newName) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET name = :newName WHERE id = :id";
      con.createQuery(sql)
      .addParameter("title", newTitle)
      .addParameter("copies", newCopies)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public static Hero find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM books WHERE id = :id";
      Hero hero = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Hero.class);
      return hero;
    }
  }

  public static List<Hero> all() {
    String sql = " SELECT * FROM hero ORDER BY name";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Hero.class);
    }
  }

}
