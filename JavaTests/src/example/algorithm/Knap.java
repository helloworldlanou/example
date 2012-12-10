package example.algorithm;
public class Knap {
	/**
	 * 0/1背包问题。all 为所有物件。max为包的容量。要求拿出的物件加起来正好是包的重量。
	 * 这个算法只能算出一种结果。不能列出所有可能的组合。
	 * 此算法不能包含到所有情况，而且总是会包含第一个！（这算法还需要改进）
	 * @param args
	 */
	private int[] all;
	private int max;
	public boolean knapprocess(int m,int n) {//m是剩余量，n是当前第几个
		System.out.println(m+" "+n);
		boolean result;
		int x = m-all[n];//x为包含了第n个时候的剩余容量
		if(x==0){
			result = true;
			System.out.println("包含"+all[n]);
			return result;
		}else if (x>0){
			if(n<=0) return false;//说明全加起来也不够
			if(knapprocess(x,n-1)){
				System.out.println("包含"+all[n]);
				return true;
			}else if (knapprocess(m,n-1)){
				return true;
			}else
				result = false;
		}else{//x 小于0说明都加上已经超过了，则不可包含第n个
			if(n>0){
				if(knapprocess(m,n-1)){
					return true;
				}else{
					result = false;
				}
			}else{
				result = false;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knap knap = new Knap();
		knap.all = new int[]{10,9,8,7,6,5,4,3,2,1};
		knap.max = 21;
		System.out.println(knap.knapprocess(knap.max,knap.all.length-1));
	}
}
