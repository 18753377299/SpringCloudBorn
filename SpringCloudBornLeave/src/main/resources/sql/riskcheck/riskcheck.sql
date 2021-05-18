CREATE TABLE
    riskcheck_main
    (
        riskcheckno CHAR(22) NOT NULL,
        comcode CHAR(8) NOT NULL,
        checkmodel VARCHAR(3),
        insuredtype VARCHAR(1),
        insuredcode VARCHAR(30),
        insuredname VARCHAR(120),
        addressdetail VARCHAR(255),
        addresscode VARCHAR(6),
        businesssource VARCHAR(6),
        businessclass VARCHAR(2),
        unitnature VARCHAR(1),
        operatorcode VARCHAR(10),
        operatorcode_uni VARCHAR(10),
        undwrtsubmitdate DATE,
        underwriteflag VARCHAR(1),
        underwritedate DATE,
        underwritecode VARCHAR(10),
        underwritename VARCHAR(120),
        checkcomcode VARCHAR(8),
        checker VARCHAR(10),
        checkdate DATE,
        madedate datetime NULL DEFAULT NOW(),
        mobileflag CHAR(1) NOT NULL,
        highlightrisk TEXT,
        score DECIMAL(5,2),
        executionid VARCHAR(255),
        repulsesugggest VARCHAR(1000),
        pointx_2000 DECIMAL(20,15),
        pointy_2000 DECIMAL(20,15),
        pointx_02 DECIMAL(20,15),
        pointy_02 DECIMAL(20,15),
        inserttimeforhis  datetime NULL DEFAULT NOW(),
        operatetimeforhis  datetime NULL DEFAULT NOW(),
        addressprovince VARCHAR(30),
        addresscity VARCHAR(40),
        addresscounty VARCHAR(225),
        PRIMARY KEY (riskcheckno) 
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
INSERT INTO riskcheck_main (riskcheckno, comcode, checkmodel, insuredtype, insuredcode, insuredname, addressdetail, addresscode, businesssource, businessclass, unitnature, operatorcode, operatorcode_uni, undwrtsubmitdate, underwriteflag, underwritedate, underwritecode, underwritename, checkcomcode, checker, checkdate, madedate, mobileflag, highlightrisk, score, executionid, repulsesugggest, pointx_2000, pointy_2000, pointx_02, pointy_02, inserttimeforhis, operatetimeforhis, addressprovince, addresscity, addresscounty) VALUES ('RX00200000000201900059', '00000000', '002', '2', '3800200000001318', '111', '222', '', '', '', '', '', null, null, 'T', null, '', '', '', '', str_to_date('2019-03-22', '%Y-%m-%d'), str_to_date('2019-03-22 14:17:23', '%Y-%m-%d %T'), ' ', '', 0.00, '', null, 115.035195312500000, 39.776845062500000, null, null, null, str_to_date('2019-03-22 15:08:07', '%Y-%m-%d %T'), 'hebei', 'zhangjiankou', 'zhuluxian');

CREATE TABLE
    riskcheck_assess
    (
        riskcheckno CHAR(22) NOT NULL,
        envdanger DECIMAL(5,2),
        impdanger DECIMAL(5,2),
        builddanger DECIMAL(5,2),
        cargodanger DECIMAL(5,2),
        typdanger DECIMAL(5,2),
        flooddanger DECIMAL(5,2),
        inserttimeforhis  datetime NULL DEFAULT NOW(),
        operatetimeforhis  datetime NULL DEFAULT NOW(),
        PRIMARY KEY (riskcheckno)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
INSERT INTO riskcheck_assess (riskcheckno, envdanger, impdanger, builddanger, cargodanger, typdanger, flooddanger, inserttimeforhis, operatetimeforhis) VALUES ('RX00200000000201900059', null, null, null, null, null, null, null, null);


CREATE TABLE RiskCheck_image
(
	id	SERIAL NOT NULL,	--**顺序号
	riskCheckNo	VARCHAR(50) NOT NULL,	--**业务号
	imagtype	VARCHAR(10) NOT NULL,	--**照片类别代码
	imagtypecname	VARCHAR(50) NOT NULL,	--**照片类别名称
	imageid	VARCHAR(100),	--**图片ID(影像系统)
	imagename	VARCHAR(100) NOT NULL,	--**图片名称
	imageurl	VARCHAR(1000) NOT NULL,	--**图片地址
	remark	VARCHAR(255),	--**备注信息
	insertTimeForHis	datetime NULL DEFAULT NOW(),	--**插入时间
	operateTimeForHis	datetime NULL DEFAULT NOW(),	--**更新时间
	primary key (id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO riskcheck_image (id, riskCheckNo, imagtype, imagtypecname, imageid, imagename, imageurl, remark, insertTimeForHis, operateTimeForHis) VALUES (244, 'RX00200000000201900059', '2.4', '2.4.1.jpg', '', '2.4.1.jpg', '/riskcontrol_file/RX00100000000201900086/2.4/2.4.1.jpg?uuid=2fe64913-67bb-4da8-91e7-64a96eaefc9d', '', null, null);


CREATE TABLE RiskCheck_venture
(
	riskCheckNo	CHAR(22) NOT NULL,	--**编号
	Rainrecord	VARCHAR(1),	--**区域历史积水记录
	itemDistance	VARCHAR(1),	--**与周边水体距离
	comparedDegree	VARCHAR(1),	--**厂区地面相比周边地势高差
	comparedTerrain	VARCHAR(1),	--**所处地形
	itemEnvironment	VARCHAR(1),	--**是否临近山边、山坡
	LargeProjects	VARCHAR(1),	--**周围有无大型施工工程
	LargeProImpact	VARCHAR(1),	--**大型施工工程影响
	waterSensitivity	VARCHAR(1),	--**设备水敏感性
	underAssetsFlag	VARCHAR(1),	--**有无地下资产
	HistoricWater	VARCHAR(1),	--**历史水渍线高度
	ManSituation	VARCHAR(1),	--**企业经营情况
	lowEquipment	VARCHAR(1),	--**厂区内有无投保资产位于低洼区域
	ownership	VARCHAR(1),	--**厂房所有权性质
	constructBuild	VARCHAR(1),	--**建筑结构
	airStorageFlag	VARCHAR(1),	--**厂区内是否有露天堆放资产
	BuildYears	VARCHAR(1),	--**钢结构建筑年限
	DoorFlag	VARCHAR(1),	--**门窗是够完好
	staggeredFlag	VARCHAR(1),	--**仓库是否有顶峰错层结构
	drainageMethod	VARCHAR(1),	--**屋顶排水方式
	drainageBlock	VARCHAR(1),	--**室内排水管道维护状况
	connectedFlag	VARCHAR(1),	--**排水沟（管）与河道是否相连
	UnobstructedFlag	VARCHAR(1),	--**屋顶排水是否通畅
	HaveCanal	VARCHAR(1),	--**建筑物内部地面是否有水井盖或管渠
	cargoWaterSen	VARCHAR(1),	--**存货水敏性
	StoForm	VARCHAR(1),	--**存放形式
	StoLocation	VARCHAR(1),	--**存放位置
	EmiForm	VARCHAR(1),	--**厂区雨水排放形式
	ConMaterials	VARCHAR(1),	--**厂区防汛挡水物资
	DraEquipment	VARCHAR(1),	--**是否设置紧急排水装备
	ConPlan	VARCHAR(1),	--**企业有无汛期抢险救灾应急预案
	dutyFlag	VARCHAR(1),	--**汛期是否实行24小时值班制度
	MonitorFlag	VARCHAR(1),	--**汛期是否对重点区域进行监控
	transferFlag	VARCHAR(1),	--**汛期是否有可行的紧急转移制度
	insertTimeForHis	datetime NULL DEFAULT NOW(),	--**插入时间
	operateTimeForHis	datetime NULL DEFAULT NOW(),	--**更新时间
	primary key (riskCheckNo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO RiskCheck_venture (riskCheckNo, Rainrecord, itemDistance, comparedDegree, comparedTerrain, itemEnvironment, LargeProjects, LargeProImpact, waterSensitivity, underAssetsFlag, HistoricWater, ManSituation, lowEquipment, ownership, constructBuild, airStorageFlag, BuildYears, DoorFlag, staggeredFlag, drainageMethod, drainageBlock, connectedFlag, UnobstructedFlag, HaveCanal, cargoWaterSen, StoForm, StoLocation, EmiForm, ConMaterials, DraEquipment, ConPlan, dutyFlag, MonitorFlag, transferFlag, insertTimeForHis, operateTimeForHis) VALUES ('RX00200000000201900059', 'A', 'B', 'A', 'C', 'A', 'A', 'B', 'B', 'A', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'A', 'B', 'B', 'A', 'B', '', 'B', 'A', 'B', '2019-03-25 09:48:09', null);
