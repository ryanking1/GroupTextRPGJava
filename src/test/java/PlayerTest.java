import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PlayerTest{

	@Rule
  	public DatabaseRule database = new DatabaseRule();

	private Player player;

	@Before
	public void createPlayer(){
		player = new Player("mklgallegos", "narwhals");
	}

	@Test
	public void playerObjectInstantiatesCorrectly(){
		assertTrue(player instanceof Player);
	}

	@Test
	public void getUserName(){
		assertThat(player.getUserName(), equalTo("mklgallegos"));
	}

	@Test
	public void getPassword(){
		assertThat(player.getPassword(), equalTo("narwhals"));
	}

	@Test
	public void all(){
		assertThat(Player.all().size(), equalTo(0));
	}

	@Test
	public void equals(){
		player.save();
		assertThat(Player.all().get(0), equalTo(player));
	}

	@Test
	public void save(){
		player.save();
		assertThat(Player.all().get(0), equalTo(player));
	}

	@Test
	public void findWithUserNameAndPassword_returnsPlayerObject_true(){
		player.save();
		assertThat(Player.find("mklgallegos","narwhals"), equalTo(player));
		assertThat(Player.find("admin","narwhals"), equalTo(null));
	}

	@Test
	public void findWithId_returnsPlayerObject_true(){
		player.save();
		assertThat(Player.find(player.getId()), equalTo(player));
	}

}