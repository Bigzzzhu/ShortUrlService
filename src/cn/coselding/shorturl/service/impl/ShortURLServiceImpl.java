package cn.coselding.shorturl.service.impl;

import cn.coselding.shorturl.dao.JdbcUtils;
import cn.coselding.shorturl.dao.UrlMapDao;
import cn.coselding.shorturl.dao.impl.UrlMapDaoImpl;
import cn.coselding.shorturl.domain.UrlMap;
import cn.coselding.shorturl.service.ShortURLService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 业务逻辑层实现
 *
 */
public class ShortURLServiceImpl implements ShortURLService {

    /**
     * 持久层
     */
    private UrlMapDao urlMapDao = new UrlMapDaoImpl();

    public UrlMap createShortUrl(String url) {
        try {
            JdbcUtils.setTransactionIsolation(JdbcUtils.TRANSACTION_READ_COMMITTED);
            JdbcUtils.startTransaction();

            UrlMap urlMap = urlMapDao.checkExist(url);
            if (urlMap != null) {
                //长网址已有，不需要重新生成，直接返回
                return urlMap;
            }

            //长网址没有，新生成
            urlMap = new UrlMap();
            urlMap.setRealUrl(url);
            urlMap.setCreateDate(new Date());

            int length = 6;
            while (true) {
                //根据网址生成相对应的短网址数组
                String[] shorts = ShortUrlGenerator.shortUrl(url,
                        new Random().nextInt(100) + "", length);

                for (int i = 0; i < shorts.length; i++) {
                    urlMap.setShortUrl(shorts[i]);

                    if (urlMapDao.queryUrlMap(shorts[i]) == null) {
                        //短网址随机码没被用，创建映射
                        urlMapDao.addUrlMap(urlMap);
                        return urlMap;
                    } else
                    //被用了，使用数组下一个元素
                        continue;
                }
                //如果都被用了，短网址长度加一，继续找可用的短网址
                length++;
            }
        } catch (SQLException e) {
            JdbcUtils.rollback();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.commit();
            JdbcUtils.release();
        }
    }

    @Override
    public UrlMap queryUrl(String shortUrl) {
        try {
            JdbcUtils.setTransactionIsolation(JdbcUtils.TRANSACTION_READ_COMMITTED);
            JdbcUtils.startTransaction();
            JdbcUtils.setReadOnly();

            UrlMap urlMap = urlMapDao.queryUrlMap(shortUrl);

            JdbcUtils.commit();
            return urlMap;
        } catch (SQLException e) {
            JdbcUtils.rollback();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release();
        }
    }

    public List<UrlMap> queryUrlMaps(){
        try {
            JdbcUtils.setTransactionIsolation(JdbcUtils.TRANSACTION_READ_COMMITTED);
            JdbcUtils.startTransaction();
            JdbcUtils.setReadOnly();

            return  urlMapDao.queryUrlMaps();
        } catch (SQLException e) {
            JdbcUtils.rollback();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release();
        }
    }
}
