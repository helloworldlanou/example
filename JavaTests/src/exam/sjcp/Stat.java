package exam.sjcp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Stat {

	public static class Topic{
		private int count;
		private String desc;
		private LinkedHashMap  questions;
		public Topic(String desc, LinkedHashMap questions){
			this.count =questions.size();
			this.desc = desc;
			this.questions = questions;

		}
		private String q2String(LinkedHashMap<Integer,String> map){
			StringBuilder sb = new StringBuilder();
			for(int en: map.keySet()){
				sb.append(en+"");
				if(!map.get(en).equals("")){
					sb.append("("+map.get(en)+")");
				}
				sb.append(",");
			}
			sb.delete(sb.length()-1, sb.length());
			return sb.toString();
		}
		public String toString(){
			return desc + "(" + count + ")，题目编号:" + q2String(questions);

		}
	}
	/**
	 * @param args
	 */
	//1,6,80,84,85,86,151,153,154,156,57,207,211,259
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<Integer, String>(){  
			{  
				put(1, "");  
				put(2, "");  
			}  ;            
		}; 
		Topic[] topics  = {new Topic("多线程执行",
				new LinkedHashMap<Integer,String>(){{
					put(1,"");
					put(6,"");
					put(80,"");
					put(81,"");
					put(84,"");
					put(85,"");
					put(86,"");
					put(151,"");
					put(153,"");
					put(154,"");
					put(156,"");
					put(157,"");
					put(207,"两次start");
					put(211,"sleep and yield");
					put(259,"");
				}}),
				new Topic("多线程锁",new LinkedHashMap<Integer,String>(){{
					put(2,"");
					put(3,"");
					put(5,"");
					put(79,"");
					put(82,"");
					put(83,"volatile");
					put(152,"");
					put(155,"");
					put(212,"");
					put(258,"");
					put(280,"");
				}}),
				new Topic("抽象类与接口",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"匿名内部类");
					put(134,"");
					put(15,"");
					put(97,"");
					put(140,"");
					put(144,"");
					put(202,"");
					put(204,"");
					put(261,"");
				}}),
				new Topic("可变参数",new LinkedHashMap<Integer,String>(){{
					put(8,"");
					put(197,"");
					put(241,"int[] ...");
				}}),
				new Topic("enum",new LinkedHashMap<Integer,String>(){{
					put(9,"");
					put(12,"");
					put(74,"");
					put(94,"");
					put(110,"");
					put(279,"高级使用");
				}}),
				new Topic("继承相关的构造方法",new LinkedHashMap<Integer,String>(){{
					put(11,"");
					put(14,"");
					put(18,"this");
					put(89,"this");
					put(137,"");
					put(142,"");
					put(199,"");
					put(200,"");
					put(223,"");
				}}),
				new Topic("异常",new LinkedHashMap<Integer,String>(){{
					put(16,"");
					put(26,"");
					put(37,"");
					put(38,"");
					put(39,"");
					put(42,"");
					put(43,"finally");
					put(44,"空指针");
					put(112,"");
					put(113,"");
					put(114,"");
					put(117,"");
					put(118,"");
					put(165,"重写异常");
					put(237,"重写异常");
					put(166,"");
					put(169,"");
					put(173,"用户抛错");
					put(174,"栈溢出");
					put(195,"类型转换");
					put(208,"main throw");
					put(238,"");
					put(240,"");
					put(243,"");
					put(246,"");
				}}),
				new Topic("重载",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("类之间的关系",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("访问权限",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("重写以及调用规则",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("子类父类转换",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("序列化与反序列化",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("I/O相关",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("String StringBuilder和StringBuffer",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("格式化输出",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("条件判定",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("断言",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
				new Topic("hashcode == 和equals",new LinkedHashMap<Integer,String>(){{
					put(7,"");
					put(93,"");
					put(134,"");

				}}),
		}; 
		Arrays.sort(topics, new Comparator<Topic>(){
			@Override
			public int compare(Topic o1, Topic o2) {
				return o2.count - o1.count;
			}
		});
		int i =0;
		for(Topic t:topics){
			System.out.println(++i +  " " + t.toString());
		}
	}

}
