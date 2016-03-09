import java.util.List;
import java.util.ArrayList;
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
  private Weapon weapon;
  private Armor armor;
  private Headgear headgear;
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

  public void firstWeaponBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftWeapon = "UPDATE heroes SET speed = speed + 1, stamina = stamina + 4 WHERE id = :id";
        con.createQuery(swiftWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardWeapon = "UPDATE heroes SET defense = defense + 1, stamina = stamina + 4 WHERE id = :id";
        con.createQuery(hardWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongWeapon = "UPDATE heroes SET attack = attack + 1, stamina = stamina + 4 WHERE id = :id";
        con.createQuery(strongWeapon)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void lastWeaponBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftWeapon = "UPDATE heroes SET speed = speed + 2, stamina = stamina + 6, attack = attack + 1 WHERE id = :id";
        con.createQuery(swiftWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardWeapon = "UPDATE heroes SET defense = defense + 2, stamina = stamina + 6, attack = attack + 1 WHERE id = :id";
        con.createQuery(hardWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongWeapon = "UPDATE heroes SET attack = attack + 2, stamina = stamina + 6, speed = speed + 1 WHERE id = :id";
        con.createQuery(strongWeapon)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void firstHeadgearBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftHeadgear = "UPDATE heroes SET speed = speed + 1 WHERE id = :id";
        con.createQuery(swiftHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardHeadgear = "UPDATE heroes SET defense = defense + 1 WHERE id = :id";
        con.createQuery(hardHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongHeadgear = "UPDATE heroes SET attack = attack + 1 WHERE id = :id";
        con.createQuery(strongHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void lastHeadgearBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftHeadgear = "UPDATE heroes SET speed = speed + 2, attack = attack + 1 WHERE id = :id";
        con.createQuery(swiftHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardHeadgear = "UPDATE heroes SET defense = defense + 2, speed = speed + 1 WHERE id = :id";
        con.createQuery(hardHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongHeadgear = "UPDATE heroes SET attack = attack + 2, speed = speed + 1 WHERE id = :id";
        con.createQuery(strongHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void firstArmorBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftArmor = "UPDATE heroes SET defense = defense + 1 WHERE id = :id";
        con.createQuery(swiftArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardArmor = "UPDATE heroes SET defense = defense + 1 WHERE id = :id";
        con.createQuery(hardArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongArmor = "UPDATE heroes SET defense = defense + 1 WHERE id = :id";
        con.createQuery(strongArmor)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void firstArmorBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftArmor = "UPDATE heroes SET defense = defense + 3 WHERE id = :id";
        con.createQuery(swiftArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardArmor = "UPDATE heroes SET defense = defense + 2 WHERE id = :id";
        con.createQuery(hardArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongArmor = "UPDATE heroes SET defense = defense + 3 WHERE id = :id";
        con.createQuery(strongArmor)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
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

  public void setExperience() {
    experience = 0;
  }

  //added by Michael for testing
  public void setStamina(int stamina){
    this.stamina = stamina;
  }

  public void setAttack(int attack){
    this.attack = attack;
  }

  @Override
  public boolean equals(Object otherHero){
    if(!(otherHero instanceof Hero)){
      return false;
    } else {
      Hero hero = (Hero) otherHero;
      return this.getId() == hero.getId();
    }
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

  public int getMonsterLevel(){
    this.attack = attack;
    this.defense = defense;
    this.speed = speed;
    int monsterLevel = (attack + defense + speed)/3;
    // (int) Math.ceil(statAverage / 100.0) - 2;
    return monsterLevel;
  }

  public void levelUpAttack() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE heroes SET attack = attack + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpDefense() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE heroes SET defense = defense + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpSpeed() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE heroes SET speed = speed + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpStamina() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE heroes SET stamina = stamina + 2 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO heroes(beard_choice, name, experience, gold, attack, defense, speed, stamina) VALUES (:beardChoice, :name, :experience, :gold, :attack, :defense, :speed, :stamina)";
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

  //implement all method for Hero Class
  public static List<Hero> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT id, beard_choice AS beardChoice, name, experience, gold, attack, defense, speed, stamina FROM heroes";
      List<Hero> heroes = con.createQuery(sql).executeAndFetch(Hero.class);
      return heroes;
    }
  }

  public void delete() {
   try(Connection con = DB.sql2o.open()) {
     String sql = "DELETE FROM heroes WHERE id = :id";
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

  public static List<Inventory> getInventory() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT inventory.* FROM inventory JOIN hero ON (inventory.hero_id = hero.id) WHERE hero.id = :id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Inventory.class);
    }
  }
}
