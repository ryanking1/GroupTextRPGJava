import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Inventory {
  private int id;
  private int heroId;
  private int itemId;
  private String name;

  public Inventory(int hero_id, int item_id) {
    this.hero_id = hero_id;
    this.item_id = item-id;
  }

  public int getId() {
    return id;
  }

  public int getHeroId() {
    return heroId;
  }

  public int getItemId() {
    return itemId;
  }

  public String getItemName() {
    return name;
  }

  public static void saveItemToInventory(int heroId, int itemId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO inventory(hero_id, item_id) VALUES (:heroId, :itemId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("heroId", this.heroId)
        .addParameter("itemId", this.itemId)
        .executeUpdate()
        .getKey();
    }
  }

  @Override
  public boolean equals(Object otherInventory){
    if (!(otherInventory instanceof Inventory)) {
      return false;
    } else {
      Inventory newInventory = (Inventory) otherInventory;
      return this.getHeroId()== newInventory.getHeroId() && this.getItemId() == newInventory.getItemId() && this.getId() == newInventory.getId();
    }
  }

  public static List<Inventory> all() {
    String sql = "SELECT * FROM inventory";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Inventory.class);
    }
  }

  public static Inventory find(int id) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM inventory WHERE id = :id";
     Inventory inventory = con.createQuery(sql)
     .addParameter("id", id)
     .executeAndFetchFirst(Inventory.class);
     return inventory;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM inventory WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
