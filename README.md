# Java-Web-Study

> ### Servlet-Form (html提交表单到Servlet)

![demo.png](http://images2015.cnblogs.com/blog/607542/201705/607542-20170519144553619-1425515307.png)

* 客户端通过index.html中的form表单提交post-form.do的参数

* 服务器通过配置好的MyServlet映射 *.do 匹配到了客户端请求

* 在MyServlet中的request.getParameter获取post-form.do的参数

<br/>
<br/>

> ### Servlet-Filter (Filter简单示例)

![demo.png](http://images2015.cnblogs.com/blog/607542/201705/607542-20170522141756960-101262325.png)

* NormalDoFilter允许URI为*.do或者/notice.html(因为重定向的response也会走这个filter)的通过,不符合要求的重定向到notice.html

* HelloWorldDoFilter则进一步分析*.do是否符合/HelloWorld.do,如果符合则移到/HelloWorldDoServlet去执行,不符合则移到/OtherDoServlet去执行

<br/>
<br/>

> ### Servlet-Filter-UrlPattern (JavaWeb中过滤器Filter的url-pattern设置)

![demo.png](http://images2015.cnblogs.com/blog/607542/201705/607542-20170522154057070-2040453993.png)

* Filter按照配置在web.xml中的先后顺序,每一个Filter都会进行url-pattern的匹配,匹配成功,则会执行对应的Filter方法

* 1个Filter可以设置多个url-pattern

* Filter匹配有3种模式

1.精确匹配：
  `/directory/file1.jsp`
  `/directory/file2.jsp`
  `/directory/file3.jsp`
  
2.目录匹配：
  `/directory/*`
 
3.扩展匹配：
`*.jsp`
 
注意：下面的不支持：
`/direcotry/*.jsp`

/和/*之间的区别：
`<url-pattern>/</url-pattern>`： 会匹配到/login这样的路径型url，不会匹配到模式为*.jsp这样的后缀型url
`<url-pattern>/*</url-pattern>`：会匹配所有url：路径型的和后缀型的url(包括/login , *.jsp , *.js 和 *.html 等)
`<url-pattern>/</url-pattern>`： 甚至会造成The requested resource () is not available.

<br/>
<br/>
