/*
MySQL Backup
Database: examination_system
Backup Time: 2020-10-25 13:35:43
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `examination_system`.`college`;
DROP TABLE IF EXISTS `examination_system`.`student`;
CREATE TABLE `college` (
  `collegeID` int NOT NULL,
  `collegeName` varchar(200) NOT NULL COMMENT '课程名',
  PRIMARY KEY (`collegeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `student` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birthYear` date DEFAULT NULL COMMENT '出生日期',
  `grade` date DEFAULT NULL COMMENT '入学时间',
  `collegeID` int NOT NULL COMMENT '院系id',
  PRIMARY KEY (`userID`),
  KEY `collegeID` (`collegeID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`collegeID`) REFERENCES `college` (`collegeID`)
) ENGINE=InnoDB AUTO_INCREMENT=10015 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `examination_system`.`college` WRITE;
DELETE FROM `examination_system`.`college`;
INSERT INTO `examination_system`.`college` (`collegeID`,`collegeName`) VALUES (1, '计算机系'),(2, '设计系'),(3, '财经系');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `examination_system`.`student` WRITE;
DELETE FROM `examination_system`.`student`;
INSERT INTO `examination_system`.`student` (`userID`,`userName`,`sex`,`birthYear`,`grade`,`collegeID`) VALUES (10001, '小黄', '男', '1996-09-02', '2015-09-02', 1),(10002, '小米', '女', '1995-09-14', '2015-09-02', 3),(10003, '小陈', '女', '1996-09-02', '2015-09-02', 2),(10004, '小华', '男', '1996-09-02', '2015-09-02', 2),(10005, '小左', '女', '1996-09-02', '2015-09-02', 2),(10006, '小拉', '女', '1996-09-02', '2015-09-02', 1);
UNLOCK TABLES;
COMMIT;
