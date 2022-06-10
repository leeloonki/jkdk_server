
drop database db_health;
create database if not exists db_health;
show databases;
use db_health;
# 用户信息
create table tb_user(
                        uid int unsigned not null auto_increment primary key,
                        uname varchar(50) not null,             -- 用户名
                        passwd varchar(10) not null,            -- 密码
                        gender int not null,                    -- 1-男 0-女
                        birthday date not null,                 -- 出生日期   示例：如20010101
                        height int not null,                    -- 身高(cm)  示例：175
                        weight int not null                     -- 体重(斤)  示例：120
);

# 食物项
create table tb_food(
                        fid int unsigned not null auto_increment primary key,
                        foodName varchar(50),   -- 食物名称
                        foodHeat int not null   -- xx千卡/100g
);

# 运动项
create table tb_activity(
                            mid int unsigned not null auto_increment primary key,
                            activityName varchar(50),   -- 活动名称
                            heatConsume int not null    -- xx千卡/30min
);

#运动项目
create table tb_activity(
                            mid int unsigned not null auto_increment primary key,
                            activityName varchar(50),   -- 运动名称
                            heatConsume int not null    -- xx千卡/30min
);

# 某人 某天 某餐 选择的 某种 食物
-- 如用户在早餐吃了鸡蛋和番茄，tb_diet分别插入鸡蛋和番茄的两个表项，每个表项中含<用户选择的食物,早||中||晚餐,该食物的重量,日期,已选择的该食物总千卡含量>
create table tb_diet(
                        did int unsigned not null auto_increment primary key,
                        uid int unsigned,         -- 用户id
                        fid int unsigned,         -- 食物id
                        bld int unsigned,         -- 标识早中晚餐 1-早餐,2-午餐,3-晚餐
                        ttime date,               -- 日期
                        heatConsume int not null  -- xx千焦/30min
);

insert into tb_user(uname,passwd,gender,birthday,height,weight) values ('杨过','123456',1,CURDATE(),180,140);
insert into tb_user(uname,passwd,gender,birthday,height,weight) values ('木婉清','111111',0,200010501,170,110);

insert into tb_food(foodName, foodHeat) values('豆浆',31);	-- 31千焦
insert into tb_food(foodName, foodHeat) values('酸奶',70);
insert into tb_food(foodName, foodHeat) values('番茄',15);
insert into tb_food(foodName, foodHeat) values('西瓜',32);
insert into tb_food(foodName, foodHeat) values('火龙果',55);
insert into tb_food(foodName, foodHeat) values('米饭',116);
insert into tb_food(foodName, foodHeat) values('鸡蛋',140);

insert into tb_activity(activityName, heatConsume) values('慢走',70);   -- 70千卡
insert into tb_activity(activityName, heatConsume) values('快走',120);
insert into tb_activity(activityName, heatConsume) values('慢跑',210);
insert into tb_activity(activityName, heatConsume) values('快跑',240);
insert into tb_activity(activityName, heatConsume) values('骑行',120); #12-16km/h
insert into tb_activity(activityName, heatConsume) values('跳绳(慢速)',240);
insert into tb_activity(activityName, heatConsume) values('跳绳(中速)',300);
insert into tb_activity(activityName, heatConsume) values('俯卧撑',130);
insert into tb_activity(activityName, heatConsume) values('瑜伽',120);
insert into tb_activity(activityName, heatConsume) values('羽毛球',130);

insert into tb_diet (uid,fid,bld,ttime,heatConsume)values (1,3,1,CURDATE(),30);
insert into tb_diet (uid,fid,bld,ttime,heatConsume)values (1,3,1,20220606,30);

# select * from tb_user;
# delete from tb_diet where uid ='0';
# drop table if exists tb_diet;
# insert into tb_diet (uid,fid,bld,ttime,heatConsume)values (1,3,1,CURDATE(),30);
# select * from tb_diet where uid=2 and ttime =curdate()