import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/neckbeard_quest_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteArmorQuery = "DELETE FROM armor *;";
      String deleteHeroQuery = "DELETE FROM hero *;";
      String deletePlayerQuery = "DELETE FROM player *;";
      String deleteMonsterQuery = "DELETE FROM monster *;";
      String deleteWeaponQuery = "DELETE FROM weapon *;";
      String deleteInventoryQuery = "DELETE FROM inventory *;";
      con.createQuery(deleteArmorQuery).executeUpdate();
      con.createQuery(deleteHeroQuery).executeUpdate();
      con.createQuery(deletePlayerQuery).executeUpdate();
      con.createQuery(deleteMonsterQuery).executeUpdate();
      con.createQuery(deleteWeaponQuery).executeUpdate();
      con.createQuery(deleteInventoryQuery).executeUpdate();
    }
  }
}
