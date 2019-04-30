# ShortURL  
短网址生成webapp，采用IntelliJ IDEA 14开发，使用唯一随机码生成算法生成和原网址映射的短网址，附带数据库建表语句。  
1、输入长链，生成短链
2、访问短链，跳转到长链
3、支持计数访问
用Servlet+JSP+JavaBean+MySQL+c3p0连接池实现，生成网址的请求采用Servlet生成，filter进行请求过滤
