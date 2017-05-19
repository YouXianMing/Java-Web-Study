# Java-Web-Study

> Servlet-Form (html提交表单到Servlet)

![demo.png](http://images2015.cnblogs.com/blog/607542/201705/607542-20170519144553619-1425515307.png)

* 客户端通过index.html中的form表单提交post-form.do的参数

* 服务器通过配置好的MyServlet映射 *.do 匹配到了客户端请求

* 在MyServlet中的request.getParameter获取post-form.do的参数

