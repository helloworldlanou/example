package example.algorithm;

//搜狗：有N个正实数(注意是实数，大小升序排列) x1 , x2 ... xN，另有一个实数M。 
//需要选出若干个x，使这几个x的和与 M 最接近。 请描述实现算法，并指出算法复杂度。
//这个是从网上某人处改为JAVA的，可以运行，感觉参数太多了洛里啰嗦的
public class FindDouble {
	private double minDelta = 9999999;
	private Boolean exist[] = new Boolean[6];//结果向量，用于存最终结果
	private double[] All; 
	Boolean[] E = new Boolean[] { false, false, false, false, false, false };
	public FindDouble(double[] A ){
		this.All = A;
	}
	/**
	 * 
	 * @param A 原有数组
	 * @param Exsits 原结果向量
	 * @param N 总个数
	 * @param M 所求的值
	 * @param i 当前是第几个
	 * @param PreCurrSum  上次结果值
	 * @param Exists 是否包含当前这个
	 */
	public void process(Boolean[] Exsits, int N,double M,int i,double PreCurrSum,Boolean Exists)
	{
		double theCurrSum = PreCurrSum + (Exists ? All[i - 1] : 0);
		Exsits[i - 1] = Exists;
		
		//this.show();
		
		double theNewDelta = Math.abs(theCurrSum - M);
		if (theNewDelta < minDelta)
		{
			minDelta = theNewDelta;
			for (int j = i + 1; j <= N; j++)
			{
				Exsits[j - 1] = false;//这句似乎是没有必要
			}
			CopyResult(Exsits, N);//什么意思？  //暂定当前Exsits为最优解，存到exsit中去
		}
		if (i < N)
		{
			process(Exsits, N, M, i + 1, theCurrSum,false);
			process(Exsits, N, M, i + 1, theCurrSum,true);
		}
	}
	private void CopyResult(Boolean[] exsits, int N)
	{
		for (int i = 0; i < N; i++)
		{
			exist[i] = exsits[i];
		}
	}
	
	private void show(){
		for (int tt = 0; tt < exist.length; tt++) {
			System.out.print(exist[tt]);
		}
		System.out.println("\n");
	}
	
	public static void main(String args[])
	{
		double[] A = new double[] {1.5,2.5,3.0,5.0,8.0,9.0};
		Boolean[] E = new Boolean[] { false, false, false, false, false, false };
		FindDouble fd = new FindDouble(A);
		fd.process(E, 6, 12, 1, 0.0, false);
		fd.process(E, 6, 12, 1,0.0, true);
		for (int i = 0; i < fd.exist.length; i++) {
			System.out.print(fd.exist[i]);
		}
	}
}
