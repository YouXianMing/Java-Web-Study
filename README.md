# Java-Web-Study

> Servlet-Form (html提交表单到Servlet)

![demo.png](http://images2015.cnblogs.com/blog/607542/201705/607542-20170519144553619-1425515307.png)

* 客户端通过index.html中的form表单提交post-form.do的参数

* 服务器通过配置好的MyServlet映射 *.do 匹配到了客户端请求

* 在MyServlet中的request.getParameter获取post-form.do的参数

> Servlet-Filter (Filter简单示例)

![demo.png](http://images2015.cnblogs.com/blog/607542/201705/607542-20170522141756960-101262325.png)

* NormalDoFilter允许URI为*.do或者/notice.html(因为重定向的response也会走这个filter)的通过,不符合要求的重定向到notice.html

* HelloWorldDoFilter则进一步分析*.do是否符合/HelloWorld.do,如果符合则移到/HelloWorldDoServlet去执行,不符合则移到/OtherDoServlet去执行
