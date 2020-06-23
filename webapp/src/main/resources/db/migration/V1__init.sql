CREATE TABLE `c_role` (
  `NAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `c_role` (`name`) VALUES
('APP_ADMIN'),
('APP_AGENT'),
('APP_USER');

--
-- Indexes for table `c_role`
--
ALTER TABLE `c_role`
  ADD PRIMARY KEY (`name`);
COMMIT;

--
-- Table structure for table `c_persistent_audit_event`
--
CREATE TABLE `c_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL,
  `event_date` longblob,
  `event_type` varchar(255) DEFAULT NULL,
  `principal` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `c_persistent_audit_event`
--
ALTER TABLE `c_persistent_audit_event`
  ADD PRIMARY KEY (`event_id`);

--
-- AUTO_INCREMENT for table `c_persistent_audit_event`
--
ALTER TABLE `c_persistent_audit_event`
  MODIFY `event_id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

--
-- Table structure for table `c_persistent_audit_evt_data`
--
CREATE TABLE `c_persistent_audit_evt_data` (
  `event_id` bigint(20) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `c_persistent_audit_evt_data`
--
ALTER TABLE `c_persistent_audit_evt_data`
  ADD KEY `FK_c_persistent_audit_evt_data_event_id` (`event_id`);

--
-- Constraints for table `c_persistent_audit_evt_data`
--
ALTER TABLE `c_persistent_audit_evt_data`
  ADD CONSTRAINT `FK_c_persistent_audit_evt_data_event_id` FOREIGN KEY (`event_id`) REFERENCES `c_persistent_audit_event` (`event_id`);
COMMIT;

--
-- Table structure for table `c_user`
--
CREATE TABLE `c_user` (
  `ID` bigint(20) NOT NULL,
  `activated` tinyint(1) NOT NULL DEFAULT '0',
  `activation_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `id_number` varchar(255) NOT NULL,
  `lang_key` varchar(10) DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password_hash` varchar(60) NOT NULL,
  `reset_date` datetime DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `c_user`
--
ALTER TABLE `c_user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `id_number` (`id_number`);

--
-- AUTO_INCREMENT for table `c_user`
--
ALTER TABLE `c_user`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

--
-- Table structure for table `c_user_role`
--

CREATE TABLE `c_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `c_user_role`
--
ALTER TABLE `c_user_role`
  ADD PRIMARY KEY (`user_id`,`role_name`),
  ADD KEY `FK_c_user_role_role_name` (`role_name`);

--
-- Constraints for table `c_user_role`
--
ALTER TABLE `c_user_role`
  ADD CONSTRAINT `FK_c_user_role_role_name` FOREIGN KEY (`role_name`) REFERENCES `c_role` (`NAME`),
  ADD CONSTRAINT `FK_c_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `c_user` (`ID`);
COMMIT;
