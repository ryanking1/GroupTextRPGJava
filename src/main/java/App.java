import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    //VIEW LOGIN
    get("/login", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/login.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //GETS HERO vtl AFTER CHARACTER IS CREATED
    get("/hero/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Hero hero = Hero.find(id);
      model.put("hero", hero);
      model.put("template", "templates/hero.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //fight instantiation page
    get("/fight/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Hero hero = Hero.find(id);
      model.put("hero", hero);
      model.put("template", "templates/fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    //CREATE PLAYER OBJECT
    post("/login/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String userName = request.queryParams("userName");
      String password = request.queryParams("password");
      Player player = new Player(userName, password);
      player.save();
      response.redirect("/login");
      return null;
    });

    //LOGIN WITH EXISTING PLAYER
    get("/login/existing", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String userName = request.queryParams("userName");
      String password = request.queryParams("password");
      if (Player.find(userName, password) instanceof Player) {
        Player player = Player.find(userName, password);
        model.put("player", player);
        response.redirect(String.format("/%d", player.getId()));
      } else {
        response.redirect("/login");
      }
      return null;
    });

    //VIEW PLAYER START SCREEN
    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Player player = Player.find(Integer.parseInt(request.params(":id")));
      model.put("player", player);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //SUBMITS BEARD CHOICE AND PLAYER NAME FORM
    post("/createHero", (request, response) -> {
       int beardChoice = Integer.parseInt(request.queryParams("heroType"));
       String name = request.queryParams("heroName");
       Hero newHero = new Hero(name, beardChoice);
       newHero.save();
       int heroId = newHero.getId();
       response.redirect("/hero/" + heroId);
       return null;
     });

     //REDIRECTS TO BOSS FIGHT/CHEST(unfinished)
     post("/fightBoss", (request, response) -> {
      int heroId = Integer.parseInt(request.queryParams("heroId"));
      response.redirect("/hero/" + heroId);
      return null;
    });

    //SUBMITS ON CLICK OF FIGHT MONSTER AND REDIRECTS TO fight.vtl
    post("/fight/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String monsterSplit = request.queryParams("monsterLevel");
      String[] parts = monsterSplit.split(":");
      String monsterName = parts[0];
      int monsterLevel = Integer.parseInt(parts[1]);
      int heroId = Integer.parseInt(request.params(":id"));
      Hero hero = Hero.find(heroId);
      int heroStamina = hero.getStamina();
      request.session().attribute("maxStamina", heroStamina);
      Monster monster = new Monster(monsterName, monsterLevel);
      monster.save();
      model.put("monster", monster);
      model.put("hero", hero);
      model.put("template", "templates/fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   post("/regularAttack/:heroId/monster/:monsterId", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    int maxStamina = request.session().attribute("maxStamina");
    int heroId = Integer.parseInt(request.params(":heroId"));
    int monsterId = Integer.parseInt(request.params(":monsterId"));
    Hero hero = Hero.find(heroId);
    Monster monster = Monster.find(monsterId);
    int heroDefense = hero.getDefense();
    int heroAttack = hero.getAttack();
    int heroSpeed = hero.getSpeed();
    int monsterDefense = monster.getMonsterDefense();
    int monsterSpeed = monster.getMonsterSpeed();
    int monsterAttack = monster.getMonsterAttack();
    int heroDamage = hero.regAttack(heroAttack, monsterDefense);
    int monsterDamage = monster.monsterAttack(monsterAttack, heroDefense);
    int newHeroStamina = hero.getStamina() - monsterDamage;
    int newMonsterStamina = monster.getMonsterStamina() - heroDamage;

    if(hero.regSpeedCheck(heroSpeed, monsterSpeed) == true) {
      monster.updateMonsterStamina(newMonsterStamina);
      hero.updateStamina(newHeroStamina);
    } else {
      hero.updateStamina(newHeroStamina);
      monster.updateMonsterStamina(newMonsterStamina);
      }
      model.put("maxStamina", maxStamina);
      model.put("hero", hero);
      model.put("monster", monster);
      model.put("heroDamage", heroDamage);
      model.put("monsterDamage", monsterDamage);
      model.put("template", "templates/in-fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heavyAttack/:heroId/monster/:monsterId", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     int maxStamina = request.session().attribute("maxStamina");
     int heroId = Integer.parseInt(request.params(":heroId"));
     int monsterId = Integer.parseInt(request.params(":monsterId"));
     Hero hero = Hero.find(heroId);
     Monster monster = Monster.find(monsterId);
     int heroDefense = hero.getDefense();
     int heroAttack = hero.getAttack();
     int heroSpeed = hero.getSpeed();
     int monsterDefense = monster.getMonsterDefense();
     int monsterSpeed = monster.getMonsterSpeed();
     int monsterAttack = monster.getMonsterAttack();
     int heroDamage = hero.heavyAttack(heroAttack, monsterDefense);
     int monsterDamage = monster.monsterAttack(monsterAttack, heroDefense);
     int newHeroStamina = hero.getStamina() - monsterDamage;
     int newMonsterStamina = monster.getMonsterStamina() - heroDamage;

     if(hero.regSpeedCheck(heroSpeed, monsterSpeed) == true) {
       if(monster.isAlive() == false || hero.isAlive() == false) {
        } else {
          monster.updateMonsterStamina(newMonsterStamina);
          if(monster.isAlive() == false || hero.isAlive() == false) {
          } else {
          hero.updateStamina(newHeroStamina);
     }}} else {
       if(monster.isAlive() == false || hero.isAlive() == false) {
       } else {
         hero.updateStamina(newHeroStamina);
         if(monster.isAlive() == false || hero.isAlive() == false) {
       } else {
         monster.updateMonsterStamina(newMonsterStamina);
     }}}
       model.put("maxStamina", maxStamina);
       model.put("hero", hero);
       model.put("monster", monster);
       model.put("heroDamage", heroDamage);
       model.put("monsterDamage", monsterDamage);
       model.put("template", "templates/in-fight.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

    post("/heavyAttack/:heroId/monster/:monsterId", (request, response) -> {
     int heroId = Integer.parseInt(request.params(":heroId"));
     int monsterId = Integer.parseInt(request.params(":monsterId"));
     Hero hero = Hero.find(heroId);
     Monster monster = Monster.find(monsterId);

     response.redirect("/fight/" + heroId + "/monster/" + monsterId);
     return null;
     });

    get("/fight/:heroId/monster/:monsterId", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int heroId = Integer.parseInt(request.params(":heroId"));
      int monsterId = Integer.parseInt(request.params(":monsterId"));
      Hero hero = Hero.find(heroId);
      Monster monster = Monster.find(monsterId);
      model.put("hero", hero);
      model.put("monster", monster);
      model.put("template", "templates/in-fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/monsterDefeat/:heroId/monster/:monsterId", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int heroId = Integer.parseInt(request.params(":heroId"));
      int monsterId = Integer.parseInt(request.params(":monsterId"));
      Hero hero = Hero.find(heroId);
      Monster monster = Monster.find(monsterId);
      int maxStamina = request.session().attribute("maxStamina");
      model.put("maxStamina", maxStamina);
      model.put("hero", hero);
      model.put("monster", monster);
      model.put("template", "templates/battle-win.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heroDefeat/:heroId/monster/:monsterId", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int heroId = Integer.parseInt(request.params(":heroId"));
      int monsterId = Integer.parseInt(request.params(":monsterId"));
      Hero hero = Hero.find(heroId);
      Monster monster = Monster.find(monsterId);
      model.put("hero", hero);
      model.put("monster", monster);
      model.put("template", "templates/battle-loss.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
