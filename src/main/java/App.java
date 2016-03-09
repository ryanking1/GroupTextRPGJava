import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

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
      int heroStamina = hero.getStamina();
      request.session().attribute("maxStamina", heroStamina);
      model.put("hero", hero);
      model.put("template", "templates/fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Redirects to actual fight page where fighting happens
    get("/fight/:heroId/monster/:monsterId", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int heroId = Integer.parseInt(request.params(":heroId"));
      int monsterId = Integer.parseInt(request.params(":monsterId"));
      Hero hero = Hero.find(heroId);
      Monster monster = Monster.find(monsterId);
      model.put("hero", hero);
      model.put("monster", monster);
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
      Monster monster = new Monster(monsterName, monsterLevel);
      monster.save();
      model.put("monster", monster);
      model.put("hero", hero);
      model.put("template", "templates/fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

     post("/regularAttack/:heroId/monster/:monsterId", (request, response) -> {
      int heroId = Integer.parseInt(request.params(":heroId"));
      int monsterId = Integer.parseInt(request.params(":monsterId"));
      Hero hero = Hero.find(heroId);
      Monster monster = Monster.find(monsterId);
      int attackType = 1;
      response.redirect("/fight/" + heroId + "/monster/" + monsterId);
      return null;
      });

      post("/heavyAttack/:heroId/monster/:monsterId", (request, response) -> {
       int heroId = Integer.parseInt(request.params(":heroId"));
       int monsterId = Integer.parseInt(request.params(":monsterId"));
       Hero hero = Hero.find(heroId);
       Monster monster = Monster.find(monsterId);
       int attackType = 2;
       response.redirect("/fight/" + heroId + "/monster/" + monsterId);
       return null;
       });
  }
}
