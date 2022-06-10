
drop database db_health;
create database if not exists db_health;
show databases;
use db_health;
# 用户信息
create table tb_user(
                     uid int unsigned not null auto_increment primary key,
                     uname varchar(50) not null,
                     passwd varchar(10) not null,
                     gender int not null,    -- 1-man 0-female
                     birthday date not null,
                     height int not null,
                     weight int not null
);

# 食物项
create table tb_food(
                     fid int unsigned not null auto_increment primary key,
                     foodName varchar(50),   --
                     foodHeat int not null   -- xx千卡/100g
);

# 运动项
create table tb_activity(
                         mid int unsigned not null auto_increment primary key,
                         activityName varchar(50),
                         heatConsume int not null  -- xx千卡/30min
);

create table tb_activity(
                         mid int unsigned not null auto_increment primary key,
                         activityName varchar(50),
                         heatConsume int not null  -- xx千卡/30min
);

create table tb_diet(
                        did int unsigned not null auto_increment primary key,
                        uid int unsigned,
                        fid int unsigned,
                        bld int unsigned,         -- 早中晚餐 1,2,3
                        ttime date,               -- 日期
                        heatConsume int not null  -- xx千卡/30min
);

insert into tb_user(uname,passwd,gender,birthday,height,weight) values ('杨过','123456',1,CURDATE(),180,140);
insert into tb_user(uname,passwd,gender,birthday,height,weight) values ('木婉清','111111',0,200010501,170,110);

insert into tb_food(foodName, foodHeat) values('豆浆',31);
insert into tb_food(foodName, foodHeat) values('酸奶',70);
insert into tb_food(foodName, foodHeat) values('番茄',15);
insert into tb_food(foodName, foodHeat) values('西瓜',32);
insert into tb_food(foodName, foodHeat) values('火龙果',55);
insert into tb_food(foodName, foodHeat) values('米饭',116);
insert into tb_food(foodName, foodHeat) values('鸡蛋',140);

insert into tb_activity(activityName, heatConsume) values('慢走',70);
insert into tb_activity(activityName, heatConsume) values('快走',120);
insert into tb_activity(activityName, heatConsume) values('慢跑',210);
insert into tb_activity(activityName, heatConsume) values('快跑',240);
insert into tb_activity(activityName, heatConsume) values('骑行',120); #12-16km/h
insert into tb_activity(activityName, heatConsume) values('跳绳(慢速)',240);
insert into tb_activity(activityName, heatConsume) values('跳绳(中速)',300);
insert into tb_activity(activityName, heatConsume) values('俯卧撑',130);
insert into tb_activity(activityName, heatConsume) values('瑜伽',120);
insert into tb_activity(activityName, heatConsume) values('羽毛球',130);




select * from tb_user;
delete from tb_diet where uid ='0';
drop table if exists tb_diet;


insert into tb_diet (uid,fid,bld,ttime,heatConsume)values (1,3,1,CURDATE(),30);

select * from tb_diet where uid=2 and ttime =curdate()