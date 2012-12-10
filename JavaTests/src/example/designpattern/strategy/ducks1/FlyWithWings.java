package example.designpattern.strategy.ducks1;

public class FlyWithWings extends Flybehavior{

	@Override
	public void fly() {
		System.out.println("I am flying!");
	}

}
