-- 资产表
-- 资产信息表
drop table if exists t_ass_base_info;
CREATE TABLE t_ass_base_info(
id             int AUTO_INCREMENT NOT NULL COMMENT '资产信息表ID',
asset_no		 varchar(22)  		COMMENT '资产出厂编号(消耗品无,长度待定)',
asset_nature		 varchar(1)	NOT NULL	COMMENT '资产性质',
asset_sort		varchar(2)		COMMENT  '资产种类',
asset_amount		decimal(8,2)		COMMENT  '资产金额',
asset_quantity		smallint   	COMMENT '资产数量',
asset_status		 varchar(1)		COMMENT '资产状态',
asset_comcode	 varchar(10)		COMMENT '资产归属机构',
asset_upper_no		 varchar(22)		COMMENT '父级资产编号（长度待定）',
asset_buy_date		timestamp  	COMMENT '资产购买日期',

asset_current_status_date	timestamp  COMMENT '当前状态日期',
asset_attribute_level  varchar(1) COMMENT'使用类型',

asset_warranty_period smallint		COMMENT '资产保修期',
asset_use_num		  smallint		COMMENT '使用次数',
asset_back_info		 varchar(255)		COMMENT '信息备注',
insert_time_for_his	 timestamp(0)   default CURRENT_TIMESTAMP 		COMMENT '插入时间',
operate_time_for_his  timestamp(0)  default CURRENT_TIMESTAMP  COMMENT '更新时间',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT '资产维护表';

-- 资产人员关联表
drop table if exists t_ass_relation;
CREATE TABLE t_ass_relation(
    id           int AUTO_INCREMENT NOT NULL COMMENT '资产人员关联表ID',
    asset_id	 int 	NOT NULL	COMMENT'资产信息表ID',
    asset_staff_code	 varchar(10)	  	NOT NULL	COMMENT'资产使用员工工号（长度待定）',
    insert_time_for_his	  timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'插入时间',
    operate_time_for_his  timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'更新时间',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资产人员关联表';

-- 资产轨迹表
drop table if exists t_ass_track;
CREATE TABLE t_ass_track(
    id     int    AUTO_INCREMENT    NOT NULL	COMMENT'资产轨迹表id',
    asset_id	 int 	NOT NULL	COMMENT'资产信息表ID',
    asset_operate_code	 varchar(10)	NOT NULL	COMMENT'操作员工工号',
    asset_staff_code	 varchar(10)	NOT NULL	COMMENT'资产使用员工工号',
    asset_status	 varchar(1)		COMMENT'资产状态',
    operate_date	 timestamp		COMMENT'操作时间',
    insert_time_for_his	  timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'插入时间',
    operate_time_for_his   timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'更新时间',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资产轨迹表';


-- 资产申请表
drop table if exists t_ass_apply;
CREATE TABLE  t_ass_apply(
    id     int    AUTO_INCREMENT    NOT NULL	COMMENT'资产申请表id',
    asset_apply_type	 varchar(1) NOT NULL	COMMENT'申请类型',
    asset_apply_reason	 varchar(1)		COMMENT'申请原因',

    asset_apply_staff_code	 varchar(10)		COMMENT'申请人员工号',
    asset_apply_staff_name	 varchar(30)		COMMENT'申请人员姓名',
    asset_total_amount	decimal(8,2)		COMMENT'资产总金额',
    asset_underwrite_status	 varchar(1)		COMMENT'审核状态',
    asset_submit_date	timestamp		COMMENT '申请日期',
    asset_deal_date	timestamp		COMMENT '办结日期',
    asset_execute_id	 varchar(10)		COMMENT'审核流程id',
    asset_staff_code	 varchar(10)		COMMENT'操作人员工号',
    insert_time_for_his	 timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'插入时间',
    operate_time_for_his	timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'更新时间',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资产申请表';


-- 资产申请清单表
drop table if exists t_ass_apply_list;
CREATE TABLE  t_ass_apply_list(
    id     int    AUTO_INCREMENT    NOT NULL	COMMENT'资产申请清单表id',
    asset_apply_id	 int  	NOT NULL	COMMENT'资产申请表ID',
    asset_apply_staff_code	 varchar(10)	NOT NULL	COMMENT'资产使用员工工号',
    asset_nature	 varchar(1)	not null	COMMENT'资产性质',
    asset_sort	varchar(2)	not null	COMMENT'资产种类',

    asset_attribute_level  varchar(1) not null COMMENT'使用类型',

    asset_quantity	smallint		COMMENT'资产数量',
    asset_config	 varchar(255)		COMMENT'资产配置',
    asset_buy_way	 varchar(255)		COMMENT'资产采买途径',
    asset_price_reference	 decimal(8,2)		COMMENT'价格参考',
    asset_remark	 varchar(255)		COMMENT'资产备注',
    asset_order_info	 varchar(255)		COMMENT'订单信息',
    asset_order_cut_info	 varchar(255)		COMMENT'订单截图存储地址',
    asset_no	 varchar(22)		COMMENT'资产出厂编号',
    insert_time_for_his	 timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'插入时间',
    operate_time_for_his	timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'更新时间',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '资产申请清单表';

-- 审批规则配置表
drop table if exists t_ass_appr_rule_config;
CREATE TABLE  t_ass_appr_rule_config(
    id     int    AUTO_INCREMENT    NOT NULL	COMMENT'审批规则配置表id',
    asset_check_type	 varchar(2)  	NOT NULL	COMMENT'审核类型',
    asset_check_person_code	 varchar(10)	NOT NULL	COMMENT'审核人员代码',
    asset_check_person_name	 varchar(30)		COMMENT'审核人员名称',

    asset_apply_object	 varchar(1)	NOT NULL COMMENT'申请对象',
    asset_nature	 varchar(1)		COMMENT'资产性质：消耗品、固定资产',

    asset_min_amount	 decimal(8,2)		COMMENT'最小金额',
    asset_max_amount	 decimal(8,2)		COMMENT'最大金额',
    asset_check_rule	 varchar(1)  		COMMENT'审核规则',

    asset_defend_date	 timestamp  		COMMENT'维护日期',
    asset_defend_code	 varchar(10)  		COMMENT'维护人员',

    is_validate_flag	 varchar(1)  		COMMENT'审核是否有效标志',
    insert_time_for_his	 timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'插入时间',
    operate_time_for_his	timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'更新时间',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '审批规则配置表';

-- 标准字段表(暂时不用，在用户表中维护)
drop table if exists t_ass_stand_field;
CREATE TABLE  t_ass_stand_field(
    asset_sort	varchar(2)	NOT NULL	COMMENT'业务类型',
    asset_no	varchar(22)	NOT NULL	COMMENT'字段代码',
    asset_no_name	varchar(255)		COMMENT'字段名称',
    asset_introduce	varchar(255)		COMMENT'字段说明',
    is_validate_flag	varchar(1)		COMMENT'是否有效',

    asset_defend_code	varchar(10)		COMMENT'维护人员',
    asset_defend_date	timestamp		COMMENT'维护日期',

    expand_field_one	varchar(255)		COMMENT'扩展字段1',
    expand_field_two	varchar(255)		COMMENT'扩展字段2',
    insert_time_for_his	 timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'插入时间',
    operate_time_for_his	timestamp(0)   default CURRENT_TIMESTAMP	COMMENT'更新时间',
    PRIMARY KEY (asset_sort,asset_no)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '标准字段表';




