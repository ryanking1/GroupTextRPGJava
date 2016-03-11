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

    /*
    before loading the /index endpoint, check to see if there is an account object
    saved in session memory. If there is, proceed to /index. If there is NOT, halt
    the request with a 401 error, and display message "You are not welcome here"
    to the user
    */
    String[] restrictedEndPoints = {"/hero/*","/fight/*","/createHero","/fightBoss","/fight","/regularAttack/*","/heavyAttack/*","/monserDefeat/*","/heroDefeat/*"};

    for(String endpoint : restrictedEndPoints){

      before(endpoint, (request, response) -> {
      boolean authenticated = false;
      Player player = request.session().attribute("player");
      if (player instanceof Player){
        authenticated = true;
      }
      if (!authenticated) {
          halt(401, "What the fuck did you just fucking say about me, you little monster bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little clever comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.");
      }
      });
    }

    //REDIRECT FROM ROOT TO LOGIN
    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      response.redirect("/login");
      return null;
    });

    //VIEW LOGIN
    get("/login", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/login.vtl");
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

    /*
    1. take username and password input from user
    2. Check to see if the Account.find() method would result in an instance of an
       Account object
    3. If it does...
      -Create an account object
      -put account object into model
      -save account object into session memory
      -redirect to /index endpoint
    4. If it does NOT... halt get request with 401 error
    */

    //LOGIN WITH EXISTING PLAYER
    get("/login/existing", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String userName = request.queryParams("userName");
      String password = request.queryParams("password");
      if (Player.find(userName, password) instanceof Player) {
        Player player = Player.find(userName, password);
        model.put("player", player);
        request.session().attribute("player", player);
        response.redirect(String.format("/%d", player.getId()));
      } else {
        halt(401, "What the fuck did you just fucking say about me, you little monster bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little clever comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.");
      }
      return null;
    });

     //LOGOUT
    get("/logout", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      request.session().removeAttribute("account");
      response.redirect("/login");
      return null;
    });

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

    //VIEW PLAYER START SCREEN
    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Player player = Player.find(Integer.parseInt(request.params(":id")));
      model.put("player", player);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Intro Page 1
    get("/:id/intro1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/intro-1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Intro Page 2
    get("/:id/intro2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/intro-2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Intro Page 3
    get("/:id/intro3", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/intro-3.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //First Treasure Page
    get("/:heroId/treasure1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":heroId")));
      hero.firstWeaponBonus();
      hero.firstHeadgearBonus();
      hero.firstArmorBonus();
      hero.updateTreasureOneFalse();
      model.put("hero", hero);
      model.put("template", "templates/treasure2.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Last Treasure Page
    get("/:heroId/treasure2", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":heroId")));
      hero.lastWeaponBonus();
      hero.lastHeadgearBonus();
      hero.lastArmorBonus();
      hero.updateTreasureTwoFalse();
      model.put("hero", hero);
      model.put("template", "templates/treasure1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Speed Level Up
    post("/hero/:id/levelSpeed", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      int id = hero.getId();
      hero.levelUpSpeed();
      int level = hero.getLevel() + 1;
      hero.updateLevel(level);
      if(hero.findLevel(id) == 4 && hero.findExperience(id) == 0)
       {hero.updateTreasureOneTrue();}
      if(hero.findLevel(id) == 7 && hero.findExperience(id) == 0)
      {hero.updateTreasureTwoTrue();}
      Hero hero1 = Hero.find(id);
      model.put("hero", hero1);
      model.put("template", "templates/level-up.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Attack Level Up
    post("/hero/:id/levelAttack", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      int id = hero.getId();
      hero.levelUpAttack();
      int level = hero.getLevel() + 1;
      hero.updateLevel(level);

      if(hero.findLevel(id) == 4 && hero.findExperience(id) == 0)
       {hero.updateTreasureOneTrue();}
      if(hero.findLevel(id) == 7 && hero.findExperience(id) == 0)
      {hero.updateTreasureTwoTrue();}
      Hero hero1 = Hero.find(id);
      model.put("hero", hero1);
      model.put("template", "templates/level-up.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Defense Level Up
    post("/hero/:id/levelDefense", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      int id = hero.getId();
      hero.levelUpDefense();
      int level = hero.getLevel() + 1;
      hero.updateLevel(level);
      if(hero.findLevel(id) == 4 && hero.findExperience(id) == 0)
       {hero.updateTreasureOneTrue();}
      if(hero.findLevel(id) == 7 && hero.findExperience(id) == 0)
      {hero.updateTreasureTwoTrue();}
      Hero hero1 = Hero.find(id);
      model.put("hero", hero1);
      model.put("template", "templates/level-up.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //Defense Level Up
    post("/hero/:id/levelStamina", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      int id = hero.getId();
      hero.levelUpStamina();
      int level = hero.getLevel() + 1;
      hero.updateLevel(level);
      if(hero.findLevel(id) == 4 && hero.findExperience(id) == 0)
       {hero.updateTreasureOneTrue();}
      if(hero.findLevel(id) == 7 && hero.findExperience(id) == 0)
      {hero.updateTreasureTwoTrue();}
      Hero hero1 = Hero.find(id);
      model.put("hero", hero1);
      model.put("template", "templates/level-up.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //SUBMITS BEARD CHOICE AND PLAYER NAME FORM
    post("/createHero", (request, response) -> {
       int beardChoice = Integer.parseInt(request.queryParams("heroType"));
       String name = request.queryParams("heroName");
       Hero newHero = new Hero(name, beardChoice);
       newHero.save();
       int heroId = newHero.getId();
       response.redirect("/" + heroId + "/intro1");
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

    //Post for fight round with reg attack
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

      Monster monster1 = Monster.find(monsterId);
      Hero hero1 = Hero.find(heroId);
      model.put("maxStamina", maxStamina);
      model.put("hero", hero1);
      model.put("monster", monster1);
      model.put("heroDamage", heroDamage);
      model.put("monsterDamage", monsterDamage);
      model.put("template", "templates/in-fight.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //post for fight round with heavy attack
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
       Monster monster1 = Monster.find(monsterId);
       Hero hero1 = Hero.find(heroId);
       model.put("maxStamina", maxStamina);
       model.put("hero", hero1);
       model.put("monster", monster1);
       model.put("heroDamage", heroDamage);
       model.put("monsterDamage", monsterDamage);
       model.put("template", "templates/in-fight.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     //get route for in-fight page(displays during fight rounds)
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

    //post for defeating a monster, which updates hp, exp, and gold for the hero
    //is run when user clicks the battle is over you win button
    post("/monsterDefeat/:heroId/monster/:monsterId", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int heroId = Integer.parseInt(request.params(":heroId"));
      int monsterId = Integer.parseInt(request.params(":monsterId"));
      Hero hero = Hero.find(heroId);
      Monster monster = Monster.find(monsterId);
      int maxStamina = request.session().attribute("maxStamina");
      int gold = (monster.getMonsterGold() + hero.getCurrency());
      int experience = (monster.getMonsterExp() + hero.getExperience());
      hero.updateStamina(maxStamina);
      hero.updateGold(gold);
      hero.updateExp(experience);

      int nextLevel = hero.getLevel() + 1;
      int experienceToNextLevel = hero.getNextLevelExp(nextLevel) - hero.getExperience();

      hero.updateExpToNextLevel(experienceToNextLevel);

      if(experienceToNextLevel <=0) {
        hero.updateExp(0);
      }
      Hero hero1 = Hero.find(heroId);

      model.put("experienceToNextLevel", experienceToNextLevel);
      model.put("maxStamina", maxStamina);
      model.put("hero", hero1);
      model.put("monster", monster);
      model.put("template", "templates/battle-win.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //goes to battle loss page after user clicks battle is over you lost button
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

    get("/hero/:id/ending1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/ending1.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/login", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
      model.put("hero", hero);
      model.put("template", "templates/ending-last.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
