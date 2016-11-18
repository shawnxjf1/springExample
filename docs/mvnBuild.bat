REM 方法1：命令 %cd% 或者 !cd!，取得是运行的环境目录
REM 方法2：命令 %~dp0  ，取得了bat的文件所在目录

@echo off
rem Start IDLE using the appropriate Python interpreter
set CURRDIR=%~dp0
echo currDir=%CURRDIR%

set parentDirectory=D:\eclipse_workspace_group\lkl-mrss-parent\

set project=%1

cd %parentDirectory%
cd %project%

echo currDir=%cd%
REM 去掉start mvn install 中的start 才会把日志输出到mvnBuild.log
REM 中文乱码通过以UTF-8 BOM编码显示解决
REM %date:~0,4%--%date:~5,2%--%date:~8,2%  -> 输出结果：2008--09--09 

REM C:\Users\lakala-shawn>echo %date%
REM 2016/11/18 周五  -> mvnBuild%date:~8,2%.log  mvnBuild18.log
REM 2>&1 把 stderr 2 和 stderr 2一起重定向到 file 文件中 ,stdin 0 

REM 生成的文件为mvnBuild1118.log
mvn clean install -Dmaven.test.skip=true  >>  "mvnBuild%date:~5,2%%date:~8,2%.log" 2>&1

exit