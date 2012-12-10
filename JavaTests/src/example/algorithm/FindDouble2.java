package example.algorithm;

public class FindDouble2 {

	/**
	 * @param args
	 * 搜狗：有N个正实数(注意是实数，大小升序排列) x1 , x2 ... xN，另有一个实数M。 需要选出若干个x，使这几个x的和与 M 最接近。 请描述实现算法，并指出算法复杂度。
	 * 思路：对于每一个数字，都分两种情况，取它或者不取，有点类似于0/1背包问题，但是之前只会那种加起来正好等于某个值的这种选择问题。
	 */
	private double all[];//记录所有的实数数组
	private boolean result[];//记录最终结果
	private Double min;//用于记下最优结果时候的值
	
	public FindDouble2(double all[]){
		this.all=all;
	}
/**
 * 
 * @param i 当前处理的实数下标
 * @param m 当前剩余值，为（m-all[i]）
 * @param etemp 当前的结果序列
 * @param exist 当前个取false or true
 */
	public void process(int i,double m,boolean etemp[],boolean exist){
		if(min==null) min = m;
		if(result==null) result = new boolean[all.length];
		if(exist){
			m=m-all[i];
		}
		etemp[i] = exist;
		if(Math.abs(m)<min){
			min = Math.abs(m);
			System.arraycopy(etemp, 0, result, 0, etemp.length);
		}
		if(i<all.length-1){
			process(i+1,m,etemp,true);
			process(i+1,m,etemp,false);
		}
	}

	public static void main(String[] args) {
		double[] A = new double[] {1.5,2.5,3.0};
		boolean[] E = new boolean[A.length];
		FindDouble2 fd = new FindDouble2(A);
		fd.process(0,5.5,E,true);
		fd.process(0,5.5,E,false);
		for (int i = 0; i < fd.result.length; i++) {
			System.out.print(fd.result[i]);
		}
	}

}
