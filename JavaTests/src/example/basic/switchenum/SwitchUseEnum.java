package example.basic.switchenum;

public class SwitchUseEnum {

	/**
	 * @param args
	 */
	public void work(Number number){
		switch(number){
		case ONE:
			System.out.print("1");
			break;
		case TWO:
			System.out.print("2");
			break;
		case THREE:
			System.out.print("3");
			break;
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwitchUseEnum switchUseEnum = new SwitchUseEnum();
		switchUseEnum.work(Number.ONE);
	}

}

