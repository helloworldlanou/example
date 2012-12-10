package example.designpattern.strategy.ducks1;

public class MallardDuck_main extends Duck{

	public MallardDuck_main(){
		quackBehavior = new Quack();
		flybehavior = new FlyWithWings();
	}


	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I am a real Mallard duck");
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck mallard =new MallardDuck_main();
		mallard.display();
		mallard.performFly();
		mallard.performQuack();
	}
}
