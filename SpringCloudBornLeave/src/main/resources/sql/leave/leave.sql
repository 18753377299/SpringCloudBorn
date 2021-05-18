-- 请假基础信息表(首先每个人都有一个基础数据)
drop table  if exists leave_basic;
CREATE TABLE  leave_basic(
        id INT NOT NULL AUTO_INCREMENT COMMENT 'id',
        jobNum VARCHAR(6) COMMENT '工号',
        employeeName VARCHAR(60) COMMENT '员工姓名',
        teamCode VARCHAR(6) COMMENT '所属团队代码',
        teamName VARCHAR(120) COMMENT '所属团队名称',
        projectCode VARCHAR(6) COMMENT '所属项目代码',
        projectName VARCHAR(120) COMMENT '所属项目名称',
        annualDay TINYINT COMMENT '年假总天数',
        usedAnnualDay TINYINT COMMENT '已用年假天数',
        retreatDay TINYINT COMMENT '倒休总天数',
        usedRetreatDay TINYINT COMMENT '已用倒休天数',
        sickDay TINYINT COMMENT '病假总天数',
        usedSickDay TINYINT COMMENT '已用病假天数',
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
        PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 请假主表
drop table  if exists leave_main;
CREATE TABLE leave_main(
        id INT NOT NULL AUTO_INCREMENT COMMENT 'id',
        jobNum VARCHAR(6) NOT NULL COMMENT '工号',
        employeeName VARCHAR(60) NOT NULL COMMENT '员工姓名',
        teamCode VARCHAR(6) COMMENT '所属团队代码',
        teamName VARCHAR(120) COMMENT '所属团队名称',
        projectCode VARCHAR(6) COMMENT '所属项目代码',
        projectName VARCHAR(120) COMMENT '所属项目名称',
        leaveType VARCHAR(1) NOT NULL COMMENT '请假类型
                    A倒休
                    B倒休（本月）
                    C年假
                    D病假
                    E事假
                    F婚假
                    G丧假
                    H产假
                    I陪产假
                    J旷工
                    ',
        detailDesc text COMMENT '详细说明',
        startTime DATE COMMENT '请假开始时间',
        endTime DATE COMMENT '请假结束时间',
        sumDay float(4,1) DEFAULT NULL COMMENT '请假天数',
        leaveFlag char(1) NOT NULL DEFAULT '0' COMMENT '请假标志,0: 半天，1： 整天',
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
        PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE
    leave_person
    (
        id INT NOT NULL AUTO_INCREMENT,
        usercode VARCHAR(10),
        username VARCHAR(255) NOT NULL,
        annual_leave INT,
        flag VARCHAR(255) NOT NULL,
        department_id INT,
        department_name VARCHAR(255) NOT NULL,
        team_id INT,
        team_name VARCHAR(255) NOT NULL,
        leavedate DATE,
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    CREATE TABLE
    leave_travel
    (
        id INT NOT NULL AUTO_INCREMENT,
        jobNum VARCHAR(6) COLLATE utf8_unicode_ci NOT NULL,
        employeeName VARCHAR(60) COLLATE utf8_unicode_ci NOT NULL,
        teamCode VARCHAR(6) COLLATE utf8_unicode_ci,
        teamName VARCHAR(120) COLLATE utf8_unicode_ci,
        projectCode VARCHAR(6) COLLATE utf8_unicode_ci,
        projectName VARCHAR(120) COLLATE utf8_unicode_ci,
        travelType VARCHAR(1) COLLATE utf8_unicode_ci NOT NULL,
        travelSite VARCHAR(120) COLLATE utf8_unicode_ci,
        travelDesc VARCHAR(250) COLLATE utf8_unicode_ci,
        startTime DATE,
        endTime DATE,
        travelDay FLOAT,
        insertTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        operateTimeForHis DATETIME DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;

---特殊节假日表
drop table if exists Leave_specDate;
CREATE TABLE Leave_specDate(
    id	int AUTO_INCREMENT Primary key COMMENT 'id',	
    dateType	VARCHAR(1) NOT NULL  COMMENT '日期类型
    0 节假日（指休息日，且不是三倍工资的日子）
    1 工作日
    2 特殊节假日（指三倍工资的日子）',
    date	DATE NOT NULL COMMENT '日期',
    insertTimeForHis	datetime NULL DEFAULT NOW() COMMENT '插入时间',
    operateTimeForHis	datetime NULL DEFAULT NOW() COMMENT '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



comment on column leave_basic.id   is 'id';
comment on column leave_basic.jobNum   is '工号';
comment on column leave_basic.employeeName   is '员工姓名';
comment on column leave_basic.teamCode   is '所属团队代码';
comment on column leave_basic.teamName   is '所属团队名称';
comment on column leave_basic.projectCode   is '所属项目代码';
comment on column leave_basic.projectName   is '所属项目名称';
comment on column leave_basic.annualDay   is '年假总天数';
comment on column leave_basic.usedAnnualDay   is '已用年假天数';
comment on column leave_basic.retreatDay   is '倒休总天数';
comment on column leave_basic.usedRetreatDay   is '已用倒休天数';
comment on column leave_basic.sickDay   is '病假总天数';
comment on column leave_basic.usedSickDay   is '已用病假天数';
comment on column leave_basic.insertTimeForHis   is '插入时间';
comment on column leave_basic.operateTimeForHis   is '更新时间';
    