--添加自己的配置参数之前参考ParameterModel模型和resultMap映射，  PARAMETER_ID值不能一样
--调用String source_ip = ParameterUtil.get("source_ip");
--系统参数类别
--INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
--VALUES
--	( '审判办理时效', 'transact_timeout', '20', '0', '1-365', '审判办理时效,默认20个工作日', '0' );
--INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
--VALUES
--    ( '审判认领时效', 'claim_timeout', '20', '0', '1-365', '审判认领时效,默认20个工作日', '0' );
--接口参数类别
--INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
--VALUES
--	( '源IP', 'source_ip', '127.0.0.1', '2', '1-30', NULL, '1' );
--日志参数类别
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
	( '操作日志老化时间', 'operate_log_store_day', '180', '0', '1-180', '操作日志保存时间', '2' );
-- 待认领超时配置
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '待认领超时', 'await.claim.overtime', '5', '0', '1-365', '待认领超时 (配置单位默认 天)', '0' );
 -- 待处理超时配置
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '待处理超时', 'await.handle.overtime', '20', '0', '1-365', '待处理超时(配置单位默认 天)', '0' );
-- 督办频次
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '督办频次', 'supervise.frequency', '24', '0', '1-8760', '督办频次(配置单位默认 小时)', '0' );
    
 -- 督办开关
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '督办开关', 'supervise.switch', 'on', '1', 'on|off', '督办开关 （on/off）', '0' );
    
 -- 督办最小间隔时间
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '督办最小间隔时间', 'supervise.min.interval.time', '5', '0', '1-60', '督办最小间隔时间， 避免用户多次连续手动触发 （配置单位默认 分钟）', '0' );
    
 -- 督办模式 
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '督办模式', 'supervise.mode', 'system,shortMsg', '1', 'system,shortMsg', '督办模式 （值如：system,shortMsg）', '0' );
    
  -- 督办内容模版
INSERT INTO TS_PARAMETER_INFO ( "PARAMETER_NAME", "PARAMETER_ID", "PARAMETER_VALUE", "VALUE_TYPE", "RANGE", "REMARK", "PARAMETER_TYPE" )
VALUES
    ( '督办内容模版', 'supervise.context.template', '你好，${userName}, ${enterpriseName}企业的办件于${overdueTime}后过期，请你尽快处理', '1', 'socialSubjectName|orgName|enterpriseName|userName|taskOperDesc|overdueTime', '督办内容模版', '0' );