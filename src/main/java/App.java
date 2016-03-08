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
  }
}