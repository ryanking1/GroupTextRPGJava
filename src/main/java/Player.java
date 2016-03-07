import org.sql2o.*;
import java.util.List;

public class Player{

	private int id;
	private String userName;
	private String password;

	public Player(String userName, String password){
		this.userName = userName;
		this.password = password;
	}

	public String getUserName(){
		return userName;
	}

	public String getPassword(){
		return password;
	}

	public int getId(){
		return id;
	}

	public static List<Player> all(){
		try(Connection con = DB.sql2o.open()){
			String sql = "SELECT id, user_name AS userName, password FROM players";
			return con.createQuery(sql).executeAndFetch(Player.class);
		}
	}

	@Override
	public boolean equals(Object otherPlayer){
		if (!(otherPlayer instanceof Player)){
			return false;
		} else {
			Player player = (Player) otherPlayer;
			return (this.getId() == player.getId());
		}
	}

	public void save(){
		try(Connection con = DB.sql2o.open()){
			String sql = "INSERT INTO players (user_name, password) VALUES (:userName, :password)";
			this.id = (int) con.createQuery(sql, true)
			.addParameter("userName", this.userName)
			.addParameter("password", this.password)
			.executeUpdate()
			.getKey();
		}
	}

}