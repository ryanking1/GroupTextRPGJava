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
}
