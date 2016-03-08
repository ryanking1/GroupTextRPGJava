import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.sql2o.*;
import static org.hamcrest.CoreMatchers.*;

public class HeroTest {

	private Hero heroOne;
	private Hero heroTwo;
	private Hero heroThree;
	private Hero heroFour;

	@Rule
	public DatabaseRule database = new DatabaseRule();

	@Before
	public void create(){
		heroOne = new Hero("Charles", 1);
		heroTwo = new Hero("Nate", 2);
		heroThree = new Hero("Ben", 3);
		heroFour = new Hero("Ben", 4);
	}

	@Test
	public void heroOneObjectInstantiatesCorrectly(){
		assertTrue(heroOne instanceof Hero);
	}

	@Test
	public void heroTwoObject2InstantiatesCorrectly(){
		assertTrue(heroTwo instanceof Hero);
	}

	@Test
	public void heroThreeObject3InstantiatesCorrectly(){
		assertTrue(heroThree instanceof Hero);
	}

	@Test
	public void setExperienceInitializesToZeroUponHeroObjectInstantiation(){
		int startingExperience = heroOne.getExperience();
		assertThat(startingExperience, equalTo(0));
	}

	@Test
	public void setStatsBasedOnBeardChoiceOne(){
		assertThat(heroOne.getSpeed(), equalTo(5));
		assertThat(heroOne.getDefense(), equalTo(3));
		assertThat(heroOne.getAttack(), equalTo(3));
		assertThat(heroOne.getStamina(), equalTo(10));
	}

	@Test
	public void setStatsBasedOnBeardChoiceTwo(){
		assertThat(heroTwo.getSpeed(), equalTo(3));
		assertThat(heroTwo.getDefense(), equalTo(5));
		assertThat(heroTwo.getAttack(), equalTo(3));
		assertThat(heroTwo.getStamina(), equalTo(10));
	}

	@Test
	public void setStatsBasedOnBeardChoiceThree(){
		assertThat(heroThree.getSpeed(), equalTo(3));
		assertThat(heroThree.getDefense(), equalTo(3));
		assertThat(heroThree.getAttack(), equalTo(5));
		assertThat(heroThree.getStamina(), equalTo(10));
	}

	@Test
	public void setStatsBasedOnBeardChoiceFour(){
		assertThat(heroThree.getSpeed(), equalTo(3));
		assertThat(heroThree.getDefense(), equalTo(3));
		assertThat(heroThree.getAttack(), equalTo(5));
		assertThat(heroThree.getStamina(), equalTo(10));
	}

	@Test
	public void heroIsAliveUponInstantiation(){
		boolean isAliveHeroOne = heroOne.isAlive();
		boolean isAliveHeroTwo = heroTwo.isAlive();
		boolean isAliveHeroThree = heroThree.isAlive();

		assertThat(isAliveHeroOne, equalTo(true));
		assertThat(isAliveHeroTwo, equalTo(true));
		assertThat(isAliveHeroThree, equalTo(true));
	}

	@Test
	public void heroIsNotAliveAtZeroStamina(){
		heroOne.setStamina(0);
		heroTwo.setStamina(0);
		heroThree.setStamina(0);
		assertThat(heroOne.isAlive(), equalTo(false));
		assertThat(heroTwo.isAlive(), equalTo(false));
		assertThat(heroThree.isAlive(), equalTo(false));
	}

	@Test
	public void getMonsterLevelReturnsCorrectly(){
		assertThat(heroOne.getMonsterLevel(), equalTo(3));
	}

	@Test
	public void getMonsterLevelReturnsCorrectly2(){
		heroOne.setAttack(20);
		assertThat(heroOne.getMonsterLevel(), equalTo(9));
	}

	@Test
	public void heroObjectsWithSameIdTreatedAsEqual(){
		heroOne.save();
		assertThat(Hero.all().get(0), equalTo(heroOne));
	}

	@Test
	public void levelUpAttackIncrementsAttackCorrectly(){
		//arrange
		heroOne.save();

		//act
		heroOne.levelUpAttack();

		//assert
		assertThat(Hero.all().get(0).getAttack(), equalTo(4));
	}

	@Test
	public void levelUpDefenseIncrementsDefenseCorrectly(){
		//arrange
		heroOne.save();

		//act
		heroOne.levelUpDefense();

		//assert
		assertThat(Hero.all().get(0).getDefense(), equalTo(4));
	}

	@Test
	public void levelUpSpeedIncrementsSpeedCorrectly(){
		//arrange
		heroOne.save();

		//act
		heroOne.levelUpSpeed();

		//assert
		assertThat(Hero.all().get(0).getSpeed(), equalTo(6));
	}

	@Test
	public void levelUpStaminaIncrementsStaminaCorrectly(){
		//arrange
		heroOne.save();

		//act
		heroOne.levelUpStamina();

		//assert
		assertThat(Hero.all().get(0).getStamina(), equalTo(12));
	}

	@Test
	public void saveAddsHeroRecordToDB(){
		heroOne.save();
		assertThat(Hero.all().size(), equalTo(1));
	}

	@Test
	public void deleteRemovesHeroRecordFromDB(){
		heroOne.save();
		heroOne.delete();
		assertThat(Hero.all().size(), equalTo(0));
	}

	@Test
	public void all_emptyAtFirst() {
	assertThat(Hero.all().size(), equalTo(0));
	}

	//TO-DO
	//08-MAR-2016
	//Michael still needs to test delete method for interaction with inventory, weapon, and armor tables

}