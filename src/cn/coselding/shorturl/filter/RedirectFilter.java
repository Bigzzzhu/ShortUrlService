package cn.coselding.shorturl.filter;

import cn.coselding.shorturl.service.ShortURLService;
import cn.coselding.shorturl.service.impl.ShortURLServiceImpl;
import cn.coselding.shorturl.domain.UrlMap;
import cn.coselding.shorturl.utils.ConfigureUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 */
public class RedirectFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取请求网址
        String url = request.getRequestURL().toString();
        //主机和contextPath前缀
        String pre = ConfigureUtils.getProperty("host");
        //短网址特定前缀
        if (url != null && url.startsWith(pre+"d/")) {
            pre = pre + "d/";
            //剪切出短网址的唯一识别码
            url = url.substring(pre.length());
            ShortURLService service = new ShortURLServiceImpl();
            //查找数据库中的短网址映射
            UrlMap urlMap = service.queryUrl(url);
            if (urlMap != null) {
                //正确，直接跳转
                service.addCount(urlMap.getShortUrl());
                response.sendRedirect(urlMap.getRealUrl());
//                response.sendRedirect("/ShortURL/");
                return;
            } else {
                //短网址不存在
                request.setAttribute("message", "您输入的网址不存在！！！");
                request.setAttribute("url", pre);
                request.getRequestDispatcher("/message.jsp").forward(request,
                        response);
                return;
            }
        } else {
            //短网址前缀以外的，放行
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
