package cn.coselding.shorturl.domain;

import java.util.Date;

/**短网址和实际网址的映射实体类
 *
 */
public class UrlMap {

	/**
	 * 实际网址
	 */
	private String realUrl;
	/**
	 * 短网址
	 */
	private String shortUrl;
	/**
	 * 映射建立时间
	 */
	private Date createDate;

	public String getRealUrl() {
		return realUrl;
	}

	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UrlMap [realUrl=" + realUrl + ", shortUrl=" + shortUrl
				+ ", createDate=" + createDate + "]";
	}

}
