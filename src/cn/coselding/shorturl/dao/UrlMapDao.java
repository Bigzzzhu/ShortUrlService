package cn.coselding.shorturl.dao;


import cn.coselding.shorturl.domain.UrlMap;

import java.sql.SQLException;
import java.util.List;

/**持久层
 *
 */
public interface UrlMapDao {

	/**添加映射关系
	 * @param urlMap 要添加的映射关系
	 * @return 返回添加成功与否
	 */
	public abstract void addUrlMap(UrlMap urlMap) throws SQLException;

	/**通过短网址查询映射关系
	 * @param shortUrl 短网址
	 * @return 映射关系
	 */
	public abstract UrlMap queryUrlMap(String shortUrl) throws SQLException;

	/**确认要建立的实际网址是否已经创建过短网址了
	 * @param realUrl 要查询的实际网址
	 * @return 返回该实际网址的映射关系，没有返回空
	 */
	public abstract UrlMap checkExist(String realUrl) throws SQLException;

	List<UrlMap> queryUrlMaps()throws SQLException;

	public void addCount(String shortUrl)throws SQLException;
}