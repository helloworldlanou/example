package model.management;

/**
 * BoParameter entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoParameter implements java.io.Serializable {

	// Fields

	private String id;
	private String title;
	private String website;
	private String logosite;
	private String floatsite;
	private String copyright;
	private String email;
	private String newscheck;
	private Integer guestnumber;

	// Constructors

	/** default constructor */
	public BoParameter() {
	}

	/** minimal constructor */
	public BoParameter(String newscheck) {
		this.newscheck = newscheck;
	}

	/** full constructor */
	public BoParameter(String title, String website, String logosite,
			String floatsite, String copyright, String email, String newscheck,
			Integer guestnumber) {
		this.title = title;
		this.website = website;
		this.logosite = logosite;
		this.floatsite = floatsite;
		this.copyright = copyright;
		this.email = email;
		this.newscheck = newscheck;
		this.guestnumber = guestnumber;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogosite() {
		return this.logosite;
	}

	public void setLogosite(String logosite) {
		this.logosite = logosite;
	}

	public String getFloatsite() {
		return this.floatsite;
	}

	public void setFloatsite(String floatsite) {
		this.floatsite = floatsite;
	}

	public String getCopyright() {
		return this.copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewscheck() {
		return this.newscheck;
	}

	public void setNewscheck(String newscheck) {
		this.newscheck = newscheck;
	}

	public Integer getGuestnumber() {
		return this.guestnumber;
	}

	public void setGuestnumber(Integer guestnumber) {
		this.guestnumber = guestnumber;
	}

}