
-------------------the file is copied from mysql console.-------------------

mysql> create database dssp
    -> ;
Query OK, 1 row affected (0.00 sec)

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| azkaban            |
| dssp               |
| metastore          |
| mysql              |
| test               |
+--------------------+
6 rows in set (0.00 sec)

mysql> use dssp;
Database changed
mysql> create TABLE  routeToIndexTable (startTime DATETIME,endTime DATETIME,indexName VARCHAR(25),typeName VARCHAR(25),busiType VARCHAR(25));
Query OK, 0 rows affected (0.00 sec)

mysql> show tables
    -> ;
+-------------------+
| Tables_in_dssp    |
+-------------------+
| routeToIndexTable |
+-------------------+
1 row in set (0.00 sec)


mysql> ALTER TABLE indexRoute ADD PRIMARY KEY(rid);
Query OK, 1 row affected, 1 warning (0.00 sec)
Records: 1  Duplicates: 0  Warnings: 1

mysql> alter table indexRoute add rId int ;
Query OK, 1 row affected (0.02 sec)
Records: 1  Duplicates: 0  Warnings: 0

-----------给表增加自增属性----------
mysql> alter table indexRoute modify rId int AUTO_INCREMENT;
Query OK, 1 row affected (0.00 sec)
Records: 1  Duplicates: 0  Warnings: 0

-------------------//////////创建indexMeta表//////////------------------------------
create TABLE  indexMeta (mId int primary key AUTO_INCREMENT ,indexName VARCHAR(25),typeName VARCHAR(25),updateTime DATETIME,createTime DATETIME);
Query OK, 0 rows affected (0.00 sec)

