import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

// public class Item {
//   private int id;
//   private String name;
//   private int attackBonus;
//   private int defenseBonus;
//   private int speedBonus;
//   private int staminaBonus;
//   private String type;
//
// public Item(String type, String name, int attackBonus, int defenseBonus, int speedBonus, int staminaBonus){
//   this.type = type;
//   this.name = name;
//   this.attackBonus = attackBonus;
//   this.defenseBonus = defenseBonus;
//   this.speedBonus = speedBonus;
//   this.staminaBonus = staminaBonus;
// }
//
//
// Item.createHiPotion();
//
// public static Item createHiPotion(){
//   Item item = new Item (potion, hiPotion, 0,0,0,5);
//   return item;
// }
//
// public static Item createPotion(){
//   Item item = new Item (potion, potion, 0,0,0,10);
//   return item;
// }
//
//
//   public void potion() {
//     name = "Mountain Dew";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 5;
//   }
//
//   public void hiPotion() {
//     name = "Monster Energy Drink";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 10;
//   }
//
//   public void StarterWeapon() {
//     name = "Dorito Shuriken";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void starterFedora() {
//     name = "Wicker Fedora";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void starterTrenchCoat() {
//     name = "Frayed Sleeveless Trench Coat";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void medSwiftWeapon() {
//     name = "Gun-chucks";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 1;
//     staminaBonus = 4;
//   }
//
//   public void medSwiftFedora() {
//     name = "Pinstripe Trillby";
//     attackBonus = 0;
//     defenseBonus = 0;
//     speedBonus = 1;
//     staminaBonus = 0;
//   }
//
//   public void medSwiftTrenchCoat() {
//     name = "Suit Vest";
//     attackBonus = 0;
//     defenseBonus = 1;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void highSwiftWeapon() {
//     name = "Replica of Haruko's Bass from FLCL";
//     attackBonus = 1;
//     defenseBonus = 0;
//     speedBonus = 2;
//     staminaBonus = 6;
//   }
//
//   public void highSwiftFedora() {
//     name = "Rainbow Dash's Winged Fedora";
//     attackBonus = 1;
//     defenseBonus = 0;
//     speedBonus = 2;
//     staminaBonus = 0;
//   }
//
//   public void highSwiftTrenchCoat() {
//     name = "Replica of Vash Stampede from Trigun's Trench Coat";
//     attackBonus = 0;
//     defenseBonus = 3;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void medStrongWeapon() {
//     name = "Katana";
//     attackBonus = 1;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 4;
//   }
//
//   public void medStrongFedora() {
//     name = "Black and White Checked Trillby";
//     attackBonus = 1;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void medStrongTrenchCoat() {
//     name = "Army Surplus Trench Coat";
//     attackBonus = 0;
//     defenseBonus = 1;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void highStrongWeapon() {
//     name = "Replica of the Death Sythe from Soul Eater";
//     attackBonus = 2;
//     defenseBonus = 0;
//     speedBonus = 1;
//     staminaBonus = 6;
//   }
//
//   public void highStrongFedora() {
//     name = "Satin Fedora";
//     attackBonus = 2;
//     defenseBonus = 0;
//     speedBonus = 1;
//     staminaBonus = 0;
//   }
//
//   public void highStrongTrenchCoat() {
//     name = "Avaro Garay from Wand of Fortune's Sleeveless Battle Coat";
//     attackBonus = 0;
//     defenseBonus = 3;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void medHardWeapon() {
//     name = "Fingerless Leather Gloves";
//     attackBonus = 0;
//     defenseBonus = 1;
//     speedBonus = 0;
//     staminaBonus = 4;
//   }
//
//   public void medHardFedora() {
//     name = "Leather Trillby";
//     attackBonus = 1;
//     defenseBonus = 0;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void medHardTrenchCoat() {
//     name = "Flasher Coat";
//     attackBonus = 0;
//     defenseBonus = 1;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void highHardWeapon() {
//     name = "Replica of Ezra's Hammer from Fairy Tail";
//     attackBonus = 1;
//     defenseBonus = 1;
//     speedBonus = 1;
//     staminaBonus = 6;
//   }
//
//   public void highHardFedora() {
//     name = "Fine Wool Fedora";
//     attackBonus = 1;
//     defenseBonus = 2;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
//
//   public void highHardTrenchCoat() {
//     name = "Replica of Akai Uchiha's Coat From Naruto Shippuden";
//     attackBonus = 0;
//     defenseBonus = 3;
//     speedBonus = 0;
//     staminaBonus = 0;
//   }
// }
