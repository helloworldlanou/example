package exam;

public class CommonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] x = new int[3][][];
		x[0] = new int[4][];
		x[1] = new int[2][];
		x[2] = new int[5][];
		for(int i=0;i<x.length;i++)
		for(int j=0;j<x.length;j++ ){
		x[j]=new int[i+j+1][];
		System.out.println();
		System.out.println("size="+x[j].length);
		}
	}

}
