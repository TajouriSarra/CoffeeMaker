package io.github.oliviercailloux.samples.coffee;

/**
 * A specific espresso machine, that produces coffee of strength up to 20, whose
 * power is 2000 watts, and that produces a coffee of strength <em>s</em> in
 * <em>140 + 2 * s</em> seconds.
 *
 */
public class MyEspressoMachine implements EspressoMachine {
	private double maxStrength;
	private int numberOfCoffeesProduced;
	private double energySpent;
	private double power; 
	private int timeForCoffee;
	
	private MyEspressoMachine() {
		this.maxStrength = 20;
		numberOfCoffeesProduced = 0;
		power = 2000;
		timeForCoffee = 0;
	}
	public static MyEspressoMachine factory() {
		return new MyEspressoMachine();
	} 
	
	@Override
	public double getMaxStrength() {
		return maxStrength;
	}

	@Override
	public int getTimeForCoffee(double strength) {
		if (strength < 0 || strength > maxStrength) {
			throw new IllegalArgumentException("You didn't respect the contract: strenght must be a a non-negative value, at most the maxStrength value");
		}
		if (strength == 0d) {
			return 0;
		}
		timeForCoffee = (int)(Math.round(140 + 2 * strength));
		return timeForCoffee;
	}

	@Override
	public void produceCoffee(double strength) {
		if (strength < 0 || strength > maxStrength) {
			throw new IllegalArgumentException("You didn't respect the contract: strenght must be a a non-negative value, at most the maxStrength value");
		}
		numberOfCoffeesProduced ++;
		if (strength == 0) {
			energySpent = 0d;
		}
		else{
			energySpent = 15 + power * (getTimeForCoffee(strength) / 3600d);
		}
	}

	@Override
	public int getNumberOfCoffeesProduced() {
		return numberOfCoffeesProduced;
	}

	@Override
	public double getPower() {
		return power;
	}

	@Override
	public double getEnergySpent() throws IllegalStateException {
		if (numberOfCoffeesProduced == 0) {
			throw new IllegalStateException();	
		}
		else {
			return energySpent;
		}
	}
	/*public static void main (String args []) {
		MyEspressoMachine espresso = given();
		System.out.println(espresso.getMaxStrength());
		System.out.println("Time: "+ espresso.getTimeForCoffee(20));
		espresso.produceCoffee(3);
		espresso.produceCoffee(14);
		espresso.produceCoffee(4);
		espresso.produceCoffee(40);
		System.out.println("Number of coffee produced "+ espresso.getNumberOfCoffeesProduced());
		System.out.println("Power: "+ espresso.getPower());
		System.out.println("Energy spent "+ espresso.getEnergySpent());		
	}
	*/
}
