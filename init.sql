-- 创建用户，授予权限
grant dba to vip identified by vip;


-- 创建序列，用于商品表的主键
create sequence vip.seq_items start with 1000;

-- 按照题目要求，创建商品信息表
create table vip.items_info
(
	item_id number primary key,
	item_name varchar2(50) not null,
	item_price number(9,2) not null,
	create_time timestamp not null,
	status number(1) not null
);

-- 插入几行测试数据
insert into vip.items_info (item_id, item_name, item_price, create_time, status) values (seq_items.nextval, 'IPhone7', 7280, to_date('20160908', 'yyyymmdd'), 0);
insert into vip.items_info (item_id, item_name, item_price, create_time, status) values (seq_items.nextval, 'IPhone6', 5380, to_date('20140409', 'yyyymmdd'), 0);
insert into vip.items_info (item_id, item_name, item_price, create_time, status) values (seq_items.nextval, 'IPhone4', 2500, to_date('20120408', 'yyyymmdd'), 0);
commit;
