package exam.sjcp.q183.packageB;

public class XMLMessage extends exam.sjcp.q183.packageA.Message{
	String getText(){
		return "<msg>test</msg>";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new XMLMessage().getText());
	}

}
