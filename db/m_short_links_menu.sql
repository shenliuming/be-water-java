
-- 初始化菜单
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES (1, '营销短链表', 'shortchain/m_short_links/index', NULL, 0, 0, 'icon-menu', 0, 0, 0, 10000, now(), 10000, now());

INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT max(id) from sys_menu where name = '营销短链表'), '查看', '', 'shortchain:m_short_links:page', 1, 0, '', 0, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT max(id) from sys_menu where name = '营销短链表'), '新增', '', 'shortchain:m_short_links:save', 1, 0, '', 1, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT max(id) from sys_menu where name = '营销短链表'), '修改', '', 'shortchain:m_short_links:update,shortchain:m_short_links:info', 1, 0, '', 2, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT max(id) from sys_menu where name = '营销短链表'), '删除', '', 'shortchain:m_short_links:delete', 1, 0, '', 3, 0, 0, 10000, now(), 10000, now());
