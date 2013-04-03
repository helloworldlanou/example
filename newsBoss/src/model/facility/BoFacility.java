package model.facility;

/**
 * BoFacility entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoFacility implements java.io.Serializable {

	// Fields

	private String id;
	private BoFacilityType boFacilityType;
	private String name;
	private String price;
	private String des;
	private String num;
	private String salePrice;
	private String size;
	private String simage;
	private String bimage;
	private String enname;

	// Constructors

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	/** default constructor */
	public BoFacility() {
	}

	/** full constructor */
	public BoFacility(BoFacilityType boFacilityType, String name, String price,
			String des, String num, String salePrice, String size,
			String simage, String bimage) {
		this.boFacilityType = boFacilityType;
		this.name = name;
		this.price = price;
		this.des = des;
		this.num = num;
		this.salePrice = salePrice;
		this.size = size;
		this.simage = simage;
		this.bimage = bimage;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BoFacilityType getBoFacilityType() {
		return this.boFacilityType;
	}

	public void setBoFacilityType(BoFacilityType boFacilityType) {
		this.boFacilityType = boFacilityType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSimage() {
		return this.simage;
	}

	public void setSimage(String simage) {
		this.simage = simage;
	}

	public String getBimage() {
		return this.bimage;
	}

	public void setBimage(String bimage) {
		this.bimage = bimage;
	}

}