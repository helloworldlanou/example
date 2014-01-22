package example.basic.switchenum;

public enum Color {
	RED(1,"红色"),
	GREEN(2,"绿色");
	
	private Integer index;
	private String desc;

	/**
	 * 构造函数必须是private
	 * @param index
	 * @param desc
	 */
	private Color(int index,String desc){
		this.index = index;
		this.desc = desc;
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static void main(String[] args){
		for (Color c : Color.values()) {
			System.out.println(c);
			System.out.println(c.ordinal());
		}
		Color c = Color.values()[1];
		System.out.println(c);
	}
}