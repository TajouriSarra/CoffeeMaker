import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import io.github.oliviercailloux.samples.coffee.MyEspressoMachine;

public class MyEspressoMachineTests {
	
	MyEspressoMachine machine = MyEspressoMachine.factory();
	
	@Test
	public void testMaxStrengthPower() {
		assertEquals(20, machine.getMaxStrength());
		assertEquals(2000, machine.getPower());
	}
	@Test
	public void testTimeForCoffee() {
		assertEquals(152, machine.getTimeForCoffee(6));
		assertEquals(153, machine.getTimeForCoffee(6.25));
		assertEquals(0, machine.getTimeForCoffee(0));
		
	}
	@Test
	public void testSpentEnergy() {
		machine.produceCoffee(7);
		// The third parameter is an epsilon which describe how close the expected and the actual must be.
		assertEquals(100.555556, machine.getEnergySpent(), 0.001);
		machine.produceCoffee(0);
		assertEquals(0d, machine.getEnergySpent());
	}
	@Test
	public void testNumberOfCoffee() {
		machine.produceCoffee(7);
		machine.produceCoffee(7);
		machine.produceCoffee(7);
		assertEquals(3, machine.getNumberOfCoffeesProduced());
	}
}
