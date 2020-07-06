CREATE TABLE `c_role` (
    `name` varchar(50) PRIMARY KEY
);

INSERT INTO `c_role` (`name`) VALUES
('ADMIN'),
('AGENT'),
('USER'),
('ANONYMOUS');

CREATE TABLE `c_persistent_audit_event` (
  `event_id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `event_date` longblob,
  `event_type` varchar(255) DEFAULT NULL,
  `principal` varchar(255) NOT NULL
);

CREATE TABLE `c_persistent_audit_evt_data` (
  `event_id` bigint(20) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  FOREIGN KEY (`event_id`) REFERENCES `c_persistent_audit_event` (`event_id`) ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE `c_user` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `activated` tinyint(1) NOT NULL DEFAULT '0',
  `activation_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `id_number` varchar(255) UNIQUE NOT NULL,
  `lang_key` varchar(10) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password_hash` varchar(60) NOT NULL,
  `reset_date` datetime DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL
);

CREATE TABLE `c_user_role` (
  `user_id` INT NOT NULL,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`role_name`),
  FOREIGN KEY (`role_name`) REFERENCES `c_role` (`name`) ON UPDATE RESTRICT ON DELETE CASCADE,
  FOREIGN KEY (`user_id`) REFERENCES `c_user` (`id`) ON UPDATE RESTRICT ON DELETE CASCADE
);

