package cn.coselding.shorturl.dao.impl;

import cn.coselding.shorturl.domain.UrlMap;
import cn.coselding.shorturl.dao.UrlMapDao;
import cn.coselding.shorturl.dao.JdbcUtils;
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
		String sql = "select * from urlmap ;";//limit 0,3 取出第1条到第3条
		return  runner.query(JdbcUtils.getConnection(),sql,new BeanListHandler<UrlMap>(UrlMap.class));
	}

	public void addCount(String shortUrl)throws SQLException{
		QueryRunner runner = new QueryRunner();
		String sql="update urlmap set count=count+1 where shortUrl=?";
		int i=runner.update(JdbcUtils.getConnection(),sql,shortUrl);
//		System.out.println("url="+shortUrl+"  i="+i);
	}
}
