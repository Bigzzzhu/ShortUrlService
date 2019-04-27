package cn.coselding.shorturl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 网站配置信息工具类
 *
 */
public class ConfigureUtils {

	/**
	 * 配置文件
	 */
	private static Properties properties = null;
	/**
	 * 配置文件输入流
	 */
	private static InputStream is = null;

	/**
	 * 加载配置问价 ，静态加载
	 */
	static {
		is = ConfigureUtils.class.getClassLoader().getResourceAsStream(
				"config.properties");
		properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取配置信息
	 *
	 * @param name
	 *            键
	 * @return 值
	 */
	public static String getProperty(String name) {
		return properties.getProperty(name);
	}
}
