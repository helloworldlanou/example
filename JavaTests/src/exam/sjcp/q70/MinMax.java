package exam.sjcp.q70;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.jsoup.helper.StringUtil;

//public class MinMax <N extends Number>{
public class MinMax <N extends Integer>{
//public class MinMax <? extends Number>{//不合法 通配符只能用于方法中？？
	private N min,max;
	public N getMin(){ return min; }
	public N getMax(){ return max; }
	public void add(N added){
		if(min == null || added.doubleValue() < min.doubleValue()){
			min = added;
		}
		if(max == null || added.doubleValue() > max.doubleValue()){
			max = added;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<int> a = new ArrayList();
	}

}
