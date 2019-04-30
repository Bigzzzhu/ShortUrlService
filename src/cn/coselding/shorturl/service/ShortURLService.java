package cn.coselding.shorturl.service;

import cn.coselding.shorturl.domain.UrlMap;

/**业务逻辑层
 *
 */
public interface ShortURLService {

	/**创建短网址和实际网址映射
	 * @param url 实际网址
	 * @return 短网址和实际网址映射关系
	 */
	public abstract UrlMap createShortUrl(String url);

	/**通过短网址查找映射关系
	 * @param shortUrl 要查询的短网址
	 * @return 返回映射关系
	 */
	public abstract UrlMap queryUrl(String shortUrl);

	public abstract void addCount(String shortUrl);

}