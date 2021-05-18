--riskDcode表中增加岗位信息
delete from riskdcode where codeType in ('riskFactoryGrade');
INSERT INTO riskdcode (codetype, comcode, codecode, uppercode, codecname, codeename, introduce, validstatus)VALUES 
('riskFactoryGrade', '1', '01', 'grade_safe_riskexpert_user', '风险任务查询岗', 'grade_safe_task_query', '安全工厂风险专家用户岗', '1'),
('riskFactoryGrade', '1', '02', 'grade_safe_riskexpert_user', '现场查勘外部岗', 'grade_safe_report_inputw', '安全工厂风险专家用户岗', '1'),
('riskFactoryGrade', '1', '03', 'grade_safe_riskexpert_user', '风险报告查询岗', 'grade_safe_report_query', '安全工厂风险专家用户岗', '1'),
('riskFactoryGrade', '1', '04', 'grade_safe_riskexpert_user', '隐患清单查询岗', 'grade_safe_danger_query', '安全工厂风险专家用户岗', '1'),
('riskFactoryGrade', '1', '05', 'grade_safe_riskexpert_user', '首页统计岗', 'grade_home_count', '安全工厂风险专家用户岗', '1');






