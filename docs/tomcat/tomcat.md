## tomcat 使用原则
1.webapps 不能有 同一应用的  多个war包（war包名字不一样也不行），tomcat 会默认把webapps下所有的war包解压比如account.war acccount_20161129.war  解压成  /account /account_20161129,当客户端调用的时候会出现404
（附问题场景：记账 测试把war包备份 后缀是account_20161129.war解压了，正确备份方式为 accont_20161129.war.bak）


## 设置java_opts
1.catalina.sh中设置:JAVA_OPTS="-Xms256m -Xmx512m -Xss1024K -XX:PermSize=128m -XX:MaxPermSize=256m -Djava.rmi.server.hostname=10.7.111.153"