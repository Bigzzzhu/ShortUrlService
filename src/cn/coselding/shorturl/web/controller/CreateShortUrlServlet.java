package cn.coselding.shorturl.web.controller;

import cn.coselding.shorturl.domain.UrlMap;
import cn.coselding.shorturl.service.ShortURLService;
import cn.coselding.shorturl.service.impl.ShortURLServiceImpl;
import cn.coselding.shorturl.utils.ConfigureUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成短网址Servlet
 *
 */
public class CreateShortUrlServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(ConfigureUtils.getProperty("status").equals("false")){
			request.setAttribute("message", "短网址生成功能暂时关闭了哦！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		// 获取实际网址表单
		String url = request.getParameter("url");
		// 实际网址为空
		if (url == null || url.trim().equals("")) {
			request.setAttribute("message", "网址不能为空哦！！！");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}
		//网址格式不匹配
		String rex = "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
		if(!url.matches(rex)){
			request.setAttribute("message", "网址格式不合法！！！");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
			return;
		}

		// 生成短网址和实际网址映射关系，存储数据库
		ShortURLService service = new ShortURLServiceImpl();
		UrlMap urlMap = service.createShortUrl(url);
		List<UrlMap> mapList = new ArrayList<>();
		request.setAttribute("list", mapList);

		// 信息回显到网页
		String host = ConfigureUtils.getProperty("host") + "d/";
		host = host + urlMap.getShortUrl();
		request.setAttribute("host", host);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		doPost(req,resp);
	}
}
