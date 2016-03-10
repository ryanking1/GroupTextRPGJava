import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.util.concurrent.ThreadLocalRandom;

public class Hero {
  private int id;
  private int level;
  private int exp_to_next_level;
  private int beardChoice;
  private String name;
  private int experience;
  private int gold;
  private int attack;
  private int defense;
  private int speed;
  private int stamina;
  private boolean treasure_one;
  private boolean treasure_two;
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

  public boolean regSpeedCheck(int heroSpeed, int monsterSpeed) {
    if (heroSpeed >= monsterSpeed) {
      return true;
    } else {
      return false;
    }
  }

  public int regAttack(int heroAttack, int monsterDefense) {
    int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    int damage = ((heroAttack * (random)) - monsterDefense);

    if(damage > 0){
      return damage;
    } else {
    damage = 0;
    }
    return damage;
  }

  public int heavyAttack(int heroAttack, int monsterDefense) {
    int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    int damage = (int)(((heroAttack * (random)) - monsterDefense) * 1.5);

    if(damage > 0){
      return (int)damage;
    } else {
    damage = 0;
    }
    return (int)damage;
  }

  public void firstWeaponBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftWeapon = "UPDATE hero SET speed = speed + 1, stamina = stamina + 4 WHERE id = :id";
        con.createQuery(swiftWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardWeapon = "UPDATE hero SET defense = defense + 1, stamina = stamina + 4 WHERE id = :id";
        con.createQuery(hardWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongWeapon = "UPDATE hero SET attack = attack + 1, stamina = stamina + 4 WHERE id = :id";
        con.createQuery(strongWeapon)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void lastWeaponBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftWeapon = "UPDATE hero SET speed = speed + 2, stamina = stamina + 6, attack = attack + 1 WHERE id = :id";
        con.createQuery(swiftWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardWeapon = "UPDATE hero SET defense = defense + 2, stamina = stamina + 6, attack = attack + 1 WHERE id = :id";
        con.createQuery(hardWeapon)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongWeapon = "UPDATE hero SET attack = attack + 2, stamina = stamina + 6, speed = speed + 1 WHERE id = :id";
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
        String swiftHeadgear = "UPDATE hero SET speed = speed + 2, attack = attack + 1 WHERE id = :id";
        con.createQuery(swiftHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardHeadgear = "UPDATE hero SET defense = defense + 2, speed = speed + 1 WHERE id = :id";
        con.createQuery(hardHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongHeadgear = "UPDATE hero SET attack = attack + 2, speed = speed + 1 WHERE id = :id";
        con.createQuery(strongHeadgear)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void firstArmorBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftArmor = "UPDATE hero SET defense = defense + 1 WHERE id = :id";
        con.createQuery(swiftArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardArmor = "UPDATE hero SET defense = defense + 1 WHERE id = :id";
        con.createQuery(hardArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongArmor = "UPDATE hero SET defense = defense + 1 WHERE id = :id";
        con.createQuery(strongArmor)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }

  public void lastArmorBonus() {
    try(Connection con = DB.sql2o.open()) {
      if (beardChoice == 1) {
        String swiftArmor = "UPDATE hero SET defense = defense + 3 WHERE id = :id";
        con.createQuery(swiftArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else if (beardChoice == 2) {
        String hardArmor = "UPDATE hero SET defense = defense + 2 WHERE id = :id";
        con.createQuery(hardArmor)
        .addParameter("id", id)
        .executeUpdate();
      } else {
        String strongArmor = "UPDATE hero SET defense = defense + 3 WHERE id = :id";
        con.createQuery(strongArmor)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  }



  public int getId() {
    return id;
  }

  public int getLevel() {
    return level;
  }

  public int getBeardChoice() {
    return beardChoice;
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
      this.speed = 6;
      this.defense = 4;
      this.attack = 4;
      this.stamina = 10;
      this.level = 1;
    } else if (beardChoice == 2) {
      this.speed = 4;
      this.defense = 6;
      this.attack = 4;
      this.stamina = 10;
      this.level = 1;
    } else {
      this.speed = 4;
      this.defense = 4;
      this.attack = 6;
      this.stamina = 10;
      this.level = 1;
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

 public boolean getTreasureOne() {
   return treasure_one;
 }
 public boolean getTreasureTwo() {
   return treasure_two;
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
      String sql = "UPDATE hero SET attack = attack + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpDefense() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET defense = defense + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpSpeed() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET speed = speed + 1 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void levelUpStamina() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET stamina = stamina + 2 WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO hero(beard_choice, name, experience, gold, attack, defense, speed, stamina, level, exp_to_next_level, treasure_one, treasure_two) VALUES (:beardChoice, :name, :experience, :gold, :attack, :defense, :speed, :stamina, :level, :exp_to_next_level, :treasure_one, :treasure_two)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("beardChoice", this.beardChoice)
        .addParameter("name", this.name)
        .addParameter("experience", this.experience)
        .addParameter("gold", this.gold)
        .addParameter("attack", this.attack)
        .addParameter("defense", this.defense)
        .addParameter("speed", this.speed)
        .addParameter("stamina", this.stamina)
        .addParameter("level", this.level)
        .addParameter("exp_to_next_level", this.exp_to_next_level)
        .addParameter("treasure_one", false)
        .addParameter("treasure_two", false)
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
    con.createQuery(battleDeleteQuery)
    .addParameter("id", this.getId())
    .executeUpdate();
    }
  }

  public void update(String newName) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET name = :newName WHERE id = :id";
      con.createQuery(sql)
      .addParameter("name", newName)
      .addParameter("id", id)
      .executeUpdate();
    }
  }


  public void updateTreasureOneTrue() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE hero SET treasure_one = true WHERE id = :id";
        con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
      }
    }

  public void updateTreasureOneFalse() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE hero SET treasure_one = false WHERE id = :id";
        con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
      }
    }

  public void updateTreasureTwoTrue() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE hero SET treasure_two = true WHERE id = :id";
        con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
      }
    }

    public void updateTreasureTwoFalse() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "UPDATE hero SET treasure_two = false WHERE id = :id";
          con.createQuery(sql)
          .addParameter("id", id)
          .executeUpdate();
        }
      }

  public void updateStamina(int newHeroStamina) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET stamina = :newHeroStamina WHERE id = :id";
      con.createQuery(sql)
      .addParameter("newHeroStamina", newHeroStamina)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void updateGold(int gold) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET gold = :gold WHERE id = :id";
      con.createQuery(sql)
      .addParameter("gold", gold)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void updateExp(int experience) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET experience = :experience WHERE id = :id";
      con.createQuery(sql)
      .addParameter("experience", experience)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void updateLevel(int level) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET level = :level WHERE id = :id";
      con.createQuery(sql)
      .addParameter("level", level)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void updateExpToNextLevel(int experienceToNextLevel) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE hero SET exp_to_next_level = :experienceToNextLevel WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .addParameter("experienceToNextLevel", experienceToNextLevel)
      .executeUpdate();
    }
  }

  public Integer getNextLevelExp(int nextLevel) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT experience FROM level WHERE id = :nextLevel";
      int experience = con.createQuery(sql)
      .addParameter("nextLevel", nextLevel)
      .executeAndFetchFirst(Integer.class);
      return experience;
    }
  }

  public static Hero find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT id, beard_choice AS beardChoice, name, experience, gold, attack, defense, speed, stamina FROM hero WHERE id = :id";
      Hero hero = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Hero.class);
      return hero;
    }
  }
}
