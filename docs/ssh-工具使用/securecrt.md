## sftp 命令
1. lcd d:/tmp/
2. get (会把文件下载到d:/tmp/ 目录)
File -> Connect SFTP Session
sftp> lcd d:/tmp/
sftp> get /home/account/account_tomcat/webapps/account/WEB-INF/classes/com/lakala/mrss/service/impl/WoSai02Impl.class
Downloading WoSai02Impl.class from /home/account/account_tomcat/webapps/account/WEB-INF/classes/com/lakala/mrss/service/impl/WoSai02Impl.class
  100% 2KB      2KB/s 00:00:00     
/home/account/account_tomcat/webapps/account/WEB-INF/classes/com/lakala/mrss/service/impl/WoSai02Impl.class: 2140 bytes transferred in 0 seconds (2140 bytes/s