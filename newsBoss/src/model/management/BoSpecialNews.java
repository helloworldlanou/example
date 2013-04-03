package model.management;

/**
 * BoSpecialNews entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoSpecialNews implements java.io.Serializable {

	// Fields

	private String id;
	private String newsId;
	private String specialSmall;
	private String specialBig;
	private String specialSmallName;
	private String specialBigName;

	// Constructors

	/** default constructor */
	public BoSpecialNews() {
	}

	/** full constructor */
	public BoSpecialNews(String newsId, String specialSmall, String specialBig,
			String specialSmallName, String specialBigName) {
		this.newsId = newsId;
		this.specialSmall = specialSmall;
		this.specialBig = specialBig;
		this.specialSmallName = specialSmallName;
		this.specialBigName = specialBigName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getSpecialSmall() {
		return this.specialSmall;
	}

	public void setSpecialSmall(String specialSmall) {
		this.specialSmall = specialSmall;
	}

	public String getSpecialBig() {
		return this.specialBig;
	}

	public void setSpecialBig(String specialBig) {
		this.specialBig = specialBig;
	}

	public String getSpecialSmallName() {
		return this.specialSmallName;
	}

	public void setSpecialSmallName(String specialSmallName) {
		this.specialSmallName = specialSmallName;
	}

	public String getSpecialBigName() {
		return this.specialBigName;
	}

	public void setSpecialBigName(String specialBigName) {
		this.specialBigName = specialBigName;
	}

}