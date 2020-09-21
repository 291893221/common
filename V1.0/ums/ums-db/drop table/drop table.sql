SELECT concat('DROP TABLE IF EXISTS ', table_name, ';')
FROM information_schema.tables
WHERE table_schema = 'ums';

DROP TABLE IF EXISTS logging_event;
DROP TABLE IF EXISTS logging_event_exception;
DROP TABLE IF EXISTS logging_event_property;
DROP TABLE IF EXISTS t_mtm_user_organization;
DROP TABLE IF EXISTS t_mtm_user_resource;
DROP TABLE IF EXISTS t_mtm_user_role;
DROP TABLE IF EXISTS t_oto_user_ext;
DROP TABLE IF EXISTS t_ums_base_entity;
DROP TABLE IF EXISTS t_ums_organization;
DROP TABLE IF EXISTS t_ums_resource;
DROP TABLE IF EXISTS t_ums_role;
DROP TABLE IF EXISTS t_ums_user;
