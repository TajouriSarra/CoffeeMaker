package io.github.oliviercailloux.samples.coffee;

/**
 * <p>
 * A <a href=
 * "https://www.startpage.com/sp/search?query=drip+coffee+maker&cat=pics">drip
 * coffee maker</a>. It uses a specific brand of coffee, which makes it able to
 * produce coffee of any strength from 0 to 10. It takes a constant time of 2
 * minutes to produce coffee (of strength higher than zero). Unrealistically, we
 * suppose here that it produces only one coffee at a time.
 * </p>
 * <p>
 * The energy required for producing a coffee (of strength higher than zero) is
 * an estimated 83 <a href="https://en.wikipedia.org/wiki/Watt_hour">watt
 * hours</a>.
 * </p>
 */
public class DripCoffeeMaker implements CoffeeMachine {
	private double maxStrength;
	private int numberOfCoffeesProduced;
	private int timeForCoffee; 
	private double energySpent; 
	
	private DripCoffeeMaker() {
		maxStrength = 10;
		numberOfCoffeesProduced = 0;
		timeForCoffee = 120; // 2 minutes donc 120 secondes
	}
	/**
	 * A static factory method that play the role of the constructer 
	 * @return a DripCoffeeMaker object 
	 */
	public static DripCoffeeMaker factory() {
		return new DripCoffeeMaker();
	}
	
	@Override
	public double getMaxStrength(){
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
		else {
			return timeForCoffee;
		}
	}

	@Override
	public void produceCoffee(double strength) {
		if (strength < 0 || strength > maxStrength) {
			throw new IllegalArgumentException("You didn't respect the contract: strenght must be a a non-negative value, at most the maxStrength value");
		}
		numberOfCoffeesProduced++;	
		if (strength == 0) {
			energySpent = 0d;
		}
		else{
			energySpent = 83d;
		}
	}

	@Override
	public int getNumberOfCoffeesProduced() {
		return numberOfCoffeesProduced;
	}

	@Override
	public double getEnergySpent() throws IllegalStateException {
		if (numberOfCoffeesProduced==0) {
			throw new IllegalStateException();	
		}
		else {
			return energySpent; 
		}
		
	}
	/*public static void main (String args[]) {
		DripCoffeeMaker espresso = given();
		System.out.println(espresso.getMaxStrength());
		System.out.println("Time: "+ espresso.getTimeForCoffee(6));
		espresso.produceCoffee(3);
		//espresso.produceCoffee(14);
		espresso.produceCoffee(4);
		espresso.produceCoffee(9);
		System.out.println("Number of coffee produced "+ espresso.getNumberOfCoffeesProduced());
		System.out.println("Energy spent "+ espresso.getEnergySpent());	
	}
	*/
}
