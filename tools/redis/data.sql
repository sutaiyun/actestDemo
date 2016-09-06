/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.6.24 : Database - reportdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`reportdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `reportdb`;

/*Data for the table `permission` */

insert  into `permission`(`id`,`name`,`role_id`,`path`) values (1000,'权限管理',2,'/permission'),(1001,'添加用户',2,'/permission/adminAdd'),(1002,'修改用户',2,'/permission/adminModify'),(1003,'管理员列表',2,'/permission/adminList'),(2000,'数据预置',2,'/deviceOperation'),(2001,'数据批量插入',2,'/deviceOperation/upload'),(2002,'数据查询',2,'/deviceOperation/searchDevice');

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (2,'管理员');

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`) values (1,'demon','123456');

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values (1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
