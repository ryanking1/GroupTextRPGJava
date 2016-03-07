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
  private String name;
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


  public Hero(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
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

  public Boolean isAlive() {
    int stamina = getStamina();
    boolean isAlive = true;
    if (stamina < 1) {
      isAlive = false;
    }
    return isAlive
  }
}
