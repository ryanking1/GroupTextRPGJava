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
}