--查询当前所有存在的数据库
SHOW DATABASES;

--显示(给定数据库中的)表,需要结合USE使用
SHOW TABLES;

--查看数据库的定义
SHOW CREATE DATABASE test_db;

--删除表
DROP TABLE tb_user;

--创建表
CREATE TABLE tb_user (

    id     INT(11) PRIMARY KEY,
    name   VARCHAR(25),
    tel    INT(11),
    passwd INT(11)
);

--插入一条数据
INSERT INTO tb_user VALUES 
(1, 'YouXianMing', 7058965, 123456);

--查询数据
SELECT * FROM tb_user;


 