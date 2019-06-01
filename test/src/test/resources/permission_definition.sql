--系统管理10000作为顶级
--信息归集20000作为顶级
--综合支撑30000作为顶级
--联合惩戒40000作为顶级
--部门协同监管50000作为顶级
--市场主体数据中心60000作为顶级
--系统管理！！！！！！！！！！！！！！！！！！！！！！！！
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '10000', NULL, '系统管理', '-1', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11000', NULL, '用户管理', '10000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11100', NULL, '用户账号管理', '11000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11101', '/api/account/manage/user/get', '查询', '11100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11102', '/api/account/manage/user/add', '新增', '11100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11103', '/api/account/manage/user/mod', '修改', '11100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11104', '/api/account/manage/user/status', '状态开关', '11100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11105', '/api/account/manage/user/reset/password', '重置密码', '11100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11200', NULL, '用户组管理', '11000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11201', '/api/user/group/get', '查询', '11200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11202', '/api/user/group/add', '新增', '11200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11203', '/api/user/group/mod', '修改', '11200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11204', '/api/user/group/status', '状态开关', '11200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '11205', '/api/user/group/del', '删除', '11200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '12000', NULL, '角色权限管理', '10000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '12001', '/api/role/manage/get', '查询', '12000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '12002', '/api/role/manage/add', '新增', '12000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '12003', '/api/role/manage/mod', '修改', '12000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '12004', '/api/role/manage/del', '删除', '12000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '12005', '/api/role/manage/perms/get', '权限树', '12000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13000', NULL, '日志管理', '10000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13100', NULL, '登录日志', '13000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13101', '/api/log/manage/login/get', '查询', '13100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13200', NULL, '操作日志', '13000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13201', '/api/log/manage/operate/get', '查询', '13200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13300', NULL, '系统日志', '13000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '13301', '/api/log/manage/system/get', '查询', '13300', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14000', NULL, '个人中心', '10000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14100', NULL, '密码重置', '14000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14101', '/api/personal/manage/passwd/mod', '提交', '14100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14200', NULL, '登录历史', '14000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14201', '/api/personal/manage/login/history/get', '查询', '14200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14300', NULL, '个人消息', '14000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14301', '/api/personal/manage/messages/get', '查询', '14300', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '14302', '/api/personal/manage/message/details/get', '查看详情', '14300', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15000', NULL, '系统参数管理', '10000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15100', NULL, '系统参数', '15000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15101', '/api/system/manage/parameter/system/get', '查询', '15100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15102', '/api/system/manage/parameter/system/mod', '修改', '15100', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15200', NULL, '日志参数', '15000', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15201', '/api/system/manage/parameter/log/get', '查询', '15200', NULL );
INSERT INTO TS_FUNCS ( "FUNC_ID", "CODE", "FUNC_NAME", "PARENT_ID", "REMARK" )
VALUES
	( '15202', '/api/system/manage/parameter/log/mod', '修改', '15200', NULL );
--信息归集！！！！！！！！！！！！！！！！！！！！！！！！
--TODO
--综合支撑！！！！！！！！！！！！！！！！！！！！！！！！
--TODO
--联合惩戒！！！！！！！！！！！！！！！！！！！！！！！！
--TODO
--部门协同监管！！！！！！！！！！！！！！！！！！！！！！！！
--TODO
--市场主体数据中心！！！！！！！！！！！！！！！！！！！！！！！！
--TODO