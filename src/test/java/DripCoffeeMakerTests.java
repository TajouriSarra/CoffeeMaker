import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import io.github.oliviercailloux.samples.coffee.*;

public class DripCoffeeMakerTests {
	
	DripCoffeeMaker coffeeMaker = DripCoffeeMaker.factory();
	
	@Test
	public void testMaxStrength() {
		assertEquals(10, coffeeMaker.getMaxStrength());
	}
	@Test
	public void testTimeForCoffee() {
		assertEquals(120, coffeeMaker.getTimeForCoffee(6));
		assertEquals(0, coffeeMaker.getTimeForCoffee(0));
		
	}
	@Test
	public void testSpentEnergy() {
		coffeeMaker.produceCoffee(7);
		assertEquals(83d, coffeeMaker.getEnergySpent());
		coffeeMaker.produceCoffee(0);
		assertEquals(0d, coffeeMaker.getEnergySpent());
	}
	@Test
	public void testNumberOfCoffee() {
		coffeeMaker.produceCoffee(7);
		coffeeMaker.produceCoffee(7);
		coffeeMaker.produceCoffee(7);
		assertEquals(3, coffeeMaker.getNumberOfCoffeesProduced());
	}
}
