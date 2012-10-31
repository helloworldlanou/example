package example.designpattern.strategy.ducks1;

public class MuteQuack extends QuackBehavior{

	@Override
	public void quack() {
		System.out.println("<< Silence >>");
	}

}
