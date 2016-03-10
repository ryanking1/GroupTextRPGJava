// import java.util.List;
// import java.util.ArrayList;
// import org.sql2o.*;
// import java.util.Random;
//
// public class Battle {
//
// //Monster is placeholder
//   private int monsterSpeed = Monster.getMonsterSpeed();
//   private int monsterAttack = Monster.getAttack();
//   private int monsterDefense = Monster.getDefense();
//   private int monsterStamina = Monster.getStamina();
//   private int heroSpeed = Hero.getSpeed();
//   private int heroAttack = Hero.getAttack();
//   private int heroDefense = Hero.getDefense();
//   private int heroStamina = Hero.getStamina();
//   private Boolean heroWin;
//   private int hero_id;
//   private int monster_id;
//
//   public Battle(int hero_id, int monster_id) {
//     this.hero_id = hero_id;
//     this.monster_id = monster_id;
//     this.startBattle();
//   }
//
//   public static int getHeroId() {
//     return hero_id;
//   }
//
//   public static int getMonsterId() {
//     return monster_id;
//   }
//
//
//   public static Boolean getHeroWin() {
//     return herorWin;
//   }
//
//   public boolean regSpeedCheck() {
//     if (heroSpeed >= monsterSpeed) {
//       return true;
//     } else {
//       return false;
//     }
//   }
//
//   public boolean powerSpeedCheck() {
//     if (heroSpeed(0.8) >= monsterSpeed) {
//       return true;
//     } else {
//       return false;
//     }
//   }
//
//   public int regularHeroAttack() {
//     Random rand = new Random();
//     int range = 2 - 1 + 1;
//     int rn = rand.nextInt(range) + 1;
//     int damage = (heroAttack(rn)) - monsterDefense;
//
//     if(damage > 0){
//       return damage;
//     } else {
//     damage = 0;
//     }
//     return damage;
//   }
//
//   public int powerHeroAttack() {
//     Random rand = new Random();
//     int range = 2 - 1 + 1;
//     int rn = rand.nextInt(range) + 1;
//     int damage = (heroAttack(rn) - monsterDefense) * 1.3;
//
//     if(damage > 0){
//       return damage;
//     } else {
//     damage = 0;
//     }
//     return damage;
//   }
//
//   public Boolean monsterIsAlive(int damage) {
//     monsterStamina -= damage;
//     boolean isAlive = true;
//     if (monsterStamina < 1) {
//       isAlive = false;
//     }
//     return isAlive;
//   }
//
//   public int monsterAttack() {
//     Random rand = new Random();
//     int range = 2 - 1 + 1;
//     int rn = rand.nextInt(range) + 1;
//     int damage = (monsterAttack(rn)) - heroDefense;
//
//     if(damage > 0){
//       return damage;
//     } else {
//     damage = 0;
//     }
//     return damage;
//   }
//
//   public static void startBattle(int heroId, int monsterId) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "INSERT INTO battle (hero_id, monster_id, hero_win) VALUES (:hero_id, :monster_id, :hero_win)";
//       con.createQuery(sql)
//       .addParameter("hero_id", heroId)
//       .addParameter("monster_id", monsterId)
//       .addParameter("hero_win", false)
//       .executeUpdate();
//     }
//   }
//
//   public static void determineWinner() {
//     heroWin = false;
//       if (monsterStamina == 0){
//         heroWin = true;
//       }
//     return heroWin;
//     }
//
//   public static void finishBattle() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "UPDATE battle SET win = true WHERE monster_id = :id";
//       con.createQuery(sql)
//       .addParameter("id", monsterId)
//       .executeUpdate();
//     }
//   }
// }
