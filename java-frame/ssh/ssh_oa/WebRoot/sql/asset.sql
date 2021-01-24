prompt PL/SQL Developer import file
prompt Created on 2015年12月14日 by Administrator
set feedback off
set define off
prompt Creating T_ASSETTYPE...
create table T_ASSETTYPE
(
  id   VARCHAR2(30) not null,
  name VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column T_ASSETTYPE.name
  is '类型名称';
alter table T_ASSETTYPE
  add constraint TYPE_ID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating T_FACTORY...
create table T_FACTORY
(
  id   VARCHAR2(30) not null,
  name VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column T_FACTORY.name
  is '厂家名称';
alter table T_FACTORY
  add constraint FACTORY_ID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating T_ASSET...
create table T_ASSET
(
  id      VARCHAR2(30) not null,
  num     VARCHAR2(30),
  name    VARCHAR2(30),
  typeid  VARCHAR2(30),
  buydate DATE,
  userid  VARCHAR2(30),
  price   NUMBER(10),
  factory VARCHAR2(30),
  status  VARCHAR2(30),
  content VARCHAR2(300)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column T_ASSET.num
  is '资产编号';
comment on column T_ASSET.name
  is '资产名称';
comment on column T_ASSET.typeid
  is '资产类型';
comment on column T_ASSET.buydate
  is '购买日期';
comment on column T_ASSET.userid
  is '责任人';
comment on column T_ASSET.price
  is '价格';
comment on column T_ASSET.factory
  is '厂家';
comment on column T_ASSET.status
  is '状态';
comment on column T_ASSET.content
  is '备注';
alter table T_ASSET
  add constraint ASSETID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_ASSET
  add constraint FID foreign key (FACTORY)
  references T_FACTORY (ID);
alter table T_ASSET
  add constraint TID foreign key (TYPEID)
  references T_ASSETTYPE (ID);
alter table T_ASSET
  add constraint USERID foreign key (USERID)
  references T_USER (ID);

prompt Creating T_ASSETDETAIL...
create table T_ASSETDETAIL
(
  id      VARCHAR2(30) not null,
  name    VARCHAR2(30),
  model   VARCHAR2(30),
  num     NUMBER(10),
  content VARCHAR2(100),
  assetid VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column T_ASSETDETAIL.name
  is '配置名称';
comment on column T_ASSETDETAIL.model
  is '型号';
comment on column T_ASSETDETAIL.num
  is '数量';
comment on column T_ASSETDETAIL.content
  is '备注';
comment on column T_ASSETDETAIL.assetid
  is '所属资产';
alter table T_ASSETDETAIL
  add constraint TAIL_ID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_ASSETDETAIL
  add constraint BELONGID foreign key (ASSETID)
  references T_ASSET (ID);

prompt Creating T_IMG...
create table T_IMG
(
  id   VARCHAR2(30) not null,
  name VARCHAR2(100),
  path VARCHAR2(100),
  aid  VARCHAR2(30)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column T_IMG.name
  is '图片原始名称';
comment on column T_IMG.path
  is '图片保存路径';
alter table T_IMG
  add constraint IMG_ID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table T_IMG
  add constraint ASSETIMG foreign key (AID)
  references T_ASSET (ID);

prompt Disabling triggers for T_ASSETTYPE...
alter table T_ASSETTYPE disable all triggers;
prompt Disabling triggers for T_FACTORY...
alter table T_FACTORY disable all triggers;
prompt Disabling triggers for T_ASSET...
alter table T_ASSET disable all triggers;
prompt Disabling triggers for T_ASSETDETAIL...
alter table T_ASSETDETAIL disable all triggers;
prompt Disabling triggers for T_IMG...
alter table T_IMG disable all triggers;
prompt Disabling foreign key constraints for T_ASSET...
alter table T_ASSET disable constraint FID;
alter table T_ASSET disable constraint TID;
alter table T_ASSET disable constraint USERID;
prompt Disabling foreign key constraints for T_ASSETDETAIL...
alter table T_ASSETDETAIL disable constraint BELONGID;
prompt Disabling foreign key constraints for T_IMG...
alter table T_IMG disable constraint ASSETIMG;
prompt Deleting T_IMG...
delete from T_IMG;
commit;
prompt Deleting T_ASSETDETAIL...
delete from T_ASSETDETAIL;
commit;
prompt Deleting T_ASSET...
delete from T_ASSET;
commit;
prompt Deleting T_FACTORY...
delete from T_FACTORY;
commit;
prompt Deleting T_ASSETTYPE...
delete from T_ASSETTYPE;
commit;
prompt Loading T_ASSETTYPE...
insert into T_ASSETTYPE (id, name)
values ('1', '办公桌');
insert into T_ASSETTYPE (id, name)
values ('2', '电脑');
insert into T_ASSETTYPE (id, name)
values ('3', '椅子');
insert into T_ASSETTYPE (id, name)
values ('4', '键盘');
commit;
prompt 4 records loaded
prompt Loading T_FACTORY...
insert into T_FACTORY (id, name)
values ('1', '韵达公司');
insert into T_FACTORY (id, name)
values ('2', '联想公司');
insert into T_FACTORY (id, name)
values ('3', '青田公司');
insert into T_FACTORY (id, name)
values ('4', '华为公司');
commit;
prompt 4 records loaded
prompt Loading T_ASSET...
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('184', '20151119145159', '名片夹', '2', to_date('06-11-2015', 'dd-mm-yyyy'), '1', 580, '3', '3', '哈哈哈');
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('185', '20151117093733', '青花瓷艺办公椅', '3', to_date('12-11-2015', 'dd-mm-yyyy'), '1', 5000, '3', '3', '画江湖');
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('155', '20151125111601', '小黄人卡贴', '4', to_date('13-11-2015', 'dd-mm-yyyy'), '45', 7899, '4', '1', '法规和地方');
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('20151125111448635', 'bgz20151115201045', '花木办公桌', '1', to_date('10-11-2015', 'dd-mm-yyyy'), '1', 2000, '1', '1', '花木办工桌，携带花香的光滑版面');
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('20151121110306207', '20151119145159', '名片夹', '2', to_date('06-11-2015', 'dd-mm-yyyy'), '1', 580, '3', '3', '哈哈哈');
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('20151125111448463', '20151117093733', '青花瓷艺办公椅', '3', to_date('12-11-2015', 'dd-mm-yyyy'), '1', 5000, '3', '3', '画江湖');
insert into T_ASSET (id, num, name, typeid, buydate, userid, price, factory, status, content)
values ('183', 'bgz20151115201045', '花木办公桌', '1', to_date('10-11-2015', 'dd-mm-yyyy'), '1', 2000, '1', '1', '花木办工桌，携带花香的光滑版面');
commit;
prompt 7 records loaded
prompt Loading T_ASSETDETAIL...
insert into T_ASSETDETAIL (id, name, model, num, content, assetid)
values ('156', '是大法官', '600', 8, '法国红酒', '20151125111448635');
commit;
prompt 1 records loaded
prompt Loading T_IMG...
prompt Table is empty
prompt Enabling foreign key constraints for T_ASSET...
alter table T_ASSET enable constraint FID;
alter table T_ASSET enable constraint TID;
alter table T_ASSET enable constraint USERID;
prompt Enabling foreign key constraints for T_ASSETDETAIL...
alter table T_ASSETDETAIL enable constraint BELONGID;
prompt Enabling foreign key constraints for T_IMG...
alter table T_IMG enable constraint ASSETIMG;
prompt Enabling triggers for T_ASSETTYPE...
alter table T_ASSETTYPE enable all triggers;
prompt Enabling triggers for T_FACTORY...
alter table T_FACTORY enable all triggers;
prompt Enabling triggers for T_ASSET...
alter table T_ASSET enable all triggers;
prompt Enabling triggers for T_ASSETDETAIL...
alter table T_ASSETDETAIL enable all triggers;
prompt Enabling triggers for T_IMG...
alter table T_IMG enable all triggers;
set feedback on
set define on
prompt Done.
