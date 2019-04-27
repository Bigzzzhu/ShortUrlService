package cn.coselding.shorturl.dao.impl;

import cn.coselding.shorturl.dao.UrlMapDao;
import cn.coselding.shorturl.dao.JdbcUtils;
import cn.coselding.shorturl.domain.UrlMap;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**持久层实现类
 *
 */
public class UrlMapDaoImpl implements UrlMapDao {

	@Override
	public void addUrlMap(UrlMap urlMap) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into urlmap(realUrl,shortUrl,createDate) values(?,?,?);";
		Object[] params = {urlMap.getRealUrl(),urlMap.getShortUrl(),urlMap.getCreateDate()};
		runner.update(JdbcUtils.getConnection(),sql,params);
	}

	@Override
	public UrlMap queryUrlMap(String shortUrl) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "select * from urlmap where shortUrl=?;";
		return  runner.query(JdbcUtils.getConnection(),sql,new BeanHandler<UrlMap>(UrlMap.class),shortUrl);
	}

	@Override
	public UrlMap checkExist(String realUrl) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "select * from urlmap where realUrl=?;";
		return  runner.query(JdbcUtils.getConnection(),sql,new BeanHandler<UrlMap>(UrlMap.class),realUrl);
	}

	@Override
	public List<UrlMap> queryUrlMaps()throws SQLException{
		QueryRunner runner = new QueryRunner();
		String sql = "select * from urlmap limit 0,3;";
		return  runner.query(JdbcUtils.getConnection(),sql,new BeanListHandler<UrlMap>(UrlMap.class));

	}
}
