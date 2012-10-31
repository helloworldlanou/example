package example.designpattern.strategy.ducks1;

public abstract class Duck {
	Flybehavior flybehavior;
	QuackBehavior quackBehavior;
	
	public abstract void display();
	
	public void performFly(){
		flybehavior.fly();
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void swim(){
		System.out.println("All ducks float,even decoys!");
	}
}
