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
		public static String q2String(LinkedHashMap<Integer,String> map){
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
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public LinkedHashMap getQuestions() {
			return questions;
		}
		public void setQuestions(LinkedHashMap questions) {
			this.questions = questions;
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
					put(17,"");
					put(91,"");
					put(260,"");


				}}),
				new Topic("类之间的关系",new LinkedHashMap<Integer,String>(){{
					put(19,"");
					put(133,"");
					put(136,"");
					put(225,"");
					put(285,"");
				}}),
				new Topic("访问权限",new LinkedHashMap<Integer,String>(){{
					put(20,"");
					put(24,"");
					put(99,"");
					put(108,"");
					put(116,"类修饰符");

				}}),
				new Topic("重写以及调用规则",new LinkedHashMap<Integer,String>(){{
					put(10,"");
					put(21,"");
					put(63,"");
					put(67,"");
					put(87,"");
					put(88,"");
					put(116,"");
					put(130,"interface可多继承");
					put(132,"");
					put(135,"");
					put(143,"");
					put(147,"");
					put(165,"重写异常问题");
					put(171,"重写runtime异常，居然可抛");
					put(201,"");
					put(222,"");
					put(228,"");
					put(247,"");
					put(262,"");
					put(270,"");

				}}),
				new Topic("子类父类转换",new LinkedHashMap<Integer,String>(){{
					put(22,"");
					put(35,"");
					put(66,"");
					put(206,"");
					put(221,"");

				}}),
				new Topic("序列化与反序列化",new LinkedHashMap<Integer,String>(){{
					put(25,"");
					put(125,"");
					put(189,"");
					put(218,"");

				}}),
				new Topic("I/O相关",new LinkedHashMap<Integer,String>(){{
					put(29,"");
					put(30,"");
					put(125,"");
					put(126,"FileWriter");
					put(127,"Console");
					put(187,"File");
					put(284,"Scanner");
					put(190,"Scanner");
					put(272,"");
					put(283,"");

				}}),
				new Topic("String StringBuilder和StringBuffer",new LinkedHashMap<Integer,String>(){{
					put(31,"");
					put(121,"");
					put(215,"");

				}}),
				new Topic("格式化输出",new LinkedHashMap<Integer,String>(){{
					put(33,"");
					put(128,"");
					put(264,"");
					put(122,"");
					put(123,"");
					put(188,"NumberFormat");
					put(193,"");
					put(219,"");

				}}),
				new Topic("条件判定(for,if,switch,break...)",new LinkedHashMap<Integer,String>(){{
					put(36,"");
					put(120,"");
					put(170,"");
					put(167,"循环的标记");
					put(106,"");
					put(110,"");
					put(119,"");
					put(175,"");
					put(242,"case");
					put(245,"");

				}}),
				new Topic("断言",new LinkedHashMap<Integer,String>(){{
					put(41,"答案有疑问");
					put(111,"这个是对的");
					put(168,"");
					put(239,"1.4版本引入断言");

				}}),
				new Topic("hashcode == 和equals",new LinkedHashMap<Integer,String>(){{
					put(45,"");
					put(46,"");
					put(69,"");
					put(74,"hash,key");
					put(75,"");
					put(158,"");
					put(194,"==");
					put(230,"");
					put(231,"");
				}}),
				new Topic("Comparable和Comparator",new LinkedHashMap<Integer,String>(){{
					put(47,"");
					put(163,"");
					put(268,"");
				}}),
				new Topic("泛型",new LinkedHashMap<Integer,String>(){{
					put(47,"");
					put(70,"");
					put(71,"");
					put(73,"");
					put(163,"");
					put(232,"");
					put(265,"");
					put(266,"");
					put(267,"");
					put(275,"? extends 传参问题");
					put(276,"");
					put(287,"");
					put(286,"");
				}}),
				new Topic("Arrays和Collections",new LinkedHashMap<Integer,String>(){{
					put(49,"sort");
					put(77,"");
					put(78,"");
					put(115,"");
					put(120,"");
					put(141,"数组");
					put(159,"");
					put(236,"");
				}}),
				new Topic("class的执行",new LinkedHashMap<Integer,String>(){{
					put(51,"");
					put(52,"");
					put(53,"");
					put(101,"包结构");
					put(107,"jar");
					put(178,"properties");
					put(180,"");
					put(249,"");
					put(253,"jar");
					put(254,"");
					put(56,"命令行参数");
					put(181,"命令行参数");
				}}),
				new Topic("参数传递",new LinkedHashMap<Integer,String>(){{
					put(55,"");
					put(57,"++");
					put(100,"");
					put(105,"");
					put(182,"");
					put(286,"");
				}}),
				new Topic("垃圾回收以及finalize",new LinkedHashMap<Integer,String>(){{
					put(54,"");
					put(102,"");
					put(58,"复杂");
					put(103,"");
					put(104,"");
					put(176,"");
					put(248,"");
				}}),
				new Topic("static",new LinkedHashMap<Integer,String>(){{
					put(62,"");
					put(90,"");
					put(50,"");
					put(98,"");
					put(139,"");
					put(196,"");
					put(198,"");
					put(271,"");
				}}),
				new Topic("耦合问题",new LinkedHashMap<Integer,String>(){{
					put(64,"");
					put(224,"");
					put(273,"");
				}}),
				new Topic("Queue",new LinkedHashMap<Integer,String>(){{
					put(72,"");
					put(115,"");
				}}),
				new Topic("Set",new LinkedHashMap<Integer,String>(){{
					put(76,"");
					put(161,"");
					put(162,"");
					put(164,"");
					put(229,"");
					put(235,"subset");
				}}),
				new Topic("变量规则与linster规则",new LinkedHashMap<Integer,String>(){{
					put(92,"特殊字符");
					put(95,"");
					put(149,"");
				}}),
				new Topic("内部类",new LinkedHashMap<Integer,String>(){{
					put(96,"");
					put(138,"");
					put(146,"");
					put(205,"");
				}}),
				new Topic("原始类型",new LinkedHashMap<Integer,String>(){{
					put(127,"");
					put(131,"默认值");
					put(194,"immutable");
					put(213,"装箱");
				}}),
				new Topic("正则",new LinkedHashMap<Integer,String>(){{
					put(129,"");
					put(192,"");
					put(217,"\\的问题");
				}}),
				new Topic("valueOf和parse",new LinkedHashMap<Integer,String>(){{
					put(172,"");
				}}),
				new Topic("instanceOf",new LinkedHashMap<Integer,String>(){{
					put(184,"");
				}}),
				new Topic("运算符（包括++）",new LinkedHashMap<Integer,String>(){{
					put(244,"string+int");
					put(220,"++");
					put(256,"位运算符");
				}}),
				new Topic("final",new LinkedHashMap<Integer,String>(){{
					put(179,"");
					put(226,"");
					put(227,"");
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
			System.out.printf("%2d %s (%d),%s\n",++i , t.getDesc(), t.getCount(),"题目 "+Topic.q2String(t.getQuestions()));
		}
	}

}
