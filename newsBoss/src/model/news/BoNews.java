package model.news;

import java.util.Date;

import model.management.BoNavigation;
import model.management.BoSpecial;


/**
 * BoNews entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class BoNews implements java.io.Serializable {

	// Fields

	private String id;
	private String newsName;
	private String newsAuthor;
	private String newsSource;
	private String newsContent;
	private Date newsTime;
	private String newsEnclo;
	private String newsCheck;
	private String newsTop;
	private String newsPicture;
	private BoSpecial specialSmall;
	private Integer newsViewtimes;
	private String en;
	private BoNavigation boNavigationByNewsBig;
	private BoSpecial boSpecial;
	private BoNavigation boNavigationByNewsSmall;
	private String newsName2;
	private String newsNameSet;
	

	// Constructors

	public String getNewsName2() {
		return newsName2;
	}

	public void setNewsName2(String newsName2) {
		this.newsName2 = newsName2;
	}

	public String getNewsNameSet() {
		return newsNameSet;
	}

	public void setNewsNameSet(String newsNameSet) {
		this.newsNameSet = newsNameSet;
	}

	public BoNavigation getBoNavigationByNewsBig() {
		return boNavigationByNewsBig;
	}

	public void setBoNavigationByNewsBig(BoNavigation boNavigationByNewsBig) {
		this.boNavigationByNewsBig = boNavigationByNewsBig;
	}

	public BoSpecial getBoSpecial() {
		return boSpecial;
	}

	public void setBoSpecial(BoSpecial boSpecial) {
		this.boSpecial = boSpecial;
	}

	public BoNavigation getBoNavigationByNewsSmall() {
		return boNavigationByNewsSmall;
	}

	public void setBoNavigationByNewsSmall(BoNavigation boNavigationByNewsSmall) {
		this.boNavigationByNewsSmall = boNavigationByNewsSmall;
	}

	/** default constructor */
	public BoNews() {
	}

	/** full constructor */
	public BoNews(String newsBig, String newsName,
			String newsAuthor, String newsSource, String newsContent,
			Date newsTime, String newsEnclo, String newsCheck, String newsTop,
			String newsPicture, Integer newsViewtimes,String Special,String en) {

		this.newsName = newsName;
		this.newsAuthor = newsAuthor;
		this.newsSource = newsSource;
		this.newsContent = newsContent;
		this.newsTime = newsTime;
		this.newsEnclo = newsEnclo;
		this.newsCheck = newsCheck;
		this.newsTop = newsTop;
		this.newsPicture = newsPicture;
		this.newsViewtimes = newsViewtimes;
		this.en=en;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}




	public String getNewsName() {
		return this.newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getNewsAuthor() {
		return this.newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsSource() {
		return this.newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Date getNewsTime() {
		return this.newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

	public String getNewsEnclo() {
		return this.newsEnclo;
	}

	public void setNewsEnclo(String newsEnclo) {
		this.newsEnclo = newsEnclo;
	}

	public String getNewsCheck() {
		return this.newsCheck;
	}

	public void setNewsCheck(String newsCheck) {
		this.newsCheck = newsCheck;
	}

	public String getNewsTop() {
		return this.newsTop;
	}

	public void setNewsTop(String newsTop) {
		this.newsTop = newsTop;
	}

	public String getNewsPicture() {
		return this.newsPicture;
	}

	public void setNewsPicture(String newsPicture) {
		this.newsPicture = newsPicture;
	}

	public Integer getNewsViewtimes() {
		return this.newsViewtimes;
	}

	public void setNewsViewtimes(Integer newsViewtimes) {
		this.newsViewtimes = newsViewtimes;
	}



	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public BoSpecial getSpecialSmall() {
		return specialSmall;
	}

	public void setSpecialSmall(BoSpecial specialSmall) {
		this.specialSmall = specialSmall;
	}



}