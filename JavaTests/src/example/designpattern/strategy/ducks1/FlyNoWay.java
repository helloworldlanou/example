package example.designpattern.strategy.ducks1;

public class FlyNoWay extends Flybehavior{

	@Override
	public void fly() {
		System.out.println("I cannot  fly!");
	}

}
