package example.designpattern.strategy.ducks1;

public class Quack extends QuackBehavior{

	@Override
	public void quack() {
		System.out.println("QUACK!");
	}

}
