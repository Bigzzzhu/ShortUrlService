package cn.coselding.shorturl.filter;

import cn.coselding.shorturl.service.impl.ShortURLServiceImpl;
import cn.coselding.shorturl.domain.UrlMap;
import cn.coselding.shorturl.utils.ConfigureUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

/**
 */
@WebFilter(filterName = "IndexFilter")  //声明该类为过滤器，部署时被处理
public class IndexFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        List<UrlMap> list = new ShortURLServiceImpl().queryUrlMaps();
        req.setAttribute("list",list);
        String host = ConfigureUtils.getProperty("host")+"d/";
        req.setAttribute("host", host);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        return;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
