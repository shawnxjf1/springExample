## sftp 命令 - 常用的几个命令
1. help 命令查看帮助
2. lcd d:/tmp/
3. get (会把文件下载到d:/tmp/ 目录)
File -> Connect SFTP Session
sftp> lcd d:/tmp/
sftp> get /home/account/account_tomcat/webapps/account/WEB-INF/classes/com/lakala/mrss/service/impl/WoSai02Impl.class
Downloading WoSai02Impl.class from /home/account/account_tomcat/webapps/account/WEB-INF/classes/com/lakala/mrss/service/impl/WoSai02Impl.class
  100% 2KB      2KB/s 00:00:00     
/home/account/account_tomcat/webapps/account/WEB-INF/classes/com/lakala/mrss/service/impl/WoSai02Impl.class: 2140 bytes transferred in 0 seconds (2140 bytes
4. put 上传本地文件
5. lls 查看本地文件目录

## 防止session失效
1.session options ->  Send protocol NO-OP  every 60 seconds(60 位自己设置的值)