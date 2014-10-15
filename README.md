/*!40101 SET NAMES utf8 */;

/!40101 SET SQL_MODE=''/;

/!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */; /!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 /; /!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' /; /!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 /; CREATE DATABASE /!32312 IF NOT EXISTS*/agenda /*!40100 DEFAULT CHARACTER SET latin1 */;

USE agenda;

/*Table structure for table medico */

DROP TABLE IF EXISTS medico;

CREATE TABLE medico ( id bigint(20) NOT NULL AUTO_INCREMENT, crm varchar(255) COLLATE utf8_bin DEFAULT NULL, nome varchar(255) COLLATE utf8_bin DEFAULT NULL, endereco varchar(255) COLLATE utf8_bin DEFAULT NULL, cidade varchar(255) COLLATE utf8_bin DEFAULT NULL, uf char(2) COLLATE utf8_bin DEFAULT NULL, telefone varchar(255) COLLATE utf8_bin DEFAULT NULL, celular varchar(255) COLLATE utf8_bin DEFAULT NULL, email varchar(255) COLLATE utf8_bin DEFAULT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table medico */

insert into medico(id,crm,nome,endereco,cidade,uf,telefone,celular,email) values (1,'9845/MG','Astrogildo','rua dos deuses 285','belo horizonte','MG','(31) 5555-3334','(31) 5555-3334','astrogildo@asgard.com'),(2,'2425/MG','ICAROloucoS','ICARO DOIDAO','LINGUIÇA','MG','(99) 9999-9999','(99) 9999-9999','ICARODOIDAO@GMAIL.COM');

/!40101 SET SQL_MODE=@OLD_SQL_MODE */; /!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS /; /!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS /; /!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

/* SQLyog Ultimate v10.00 Beta1 MySQL - 5.6.16 : Database - agenda

*/

/*!40101 SET NAMES utf8 */;

/!40101 SET SQL_MODE=''/;

/!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */; /!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 /; /!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' /; /!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 /; CREATE DATABASE /!32312 IF NOT EXISTS*/agenda /*!40100 DEFAULT CHARACTER SET latin1 */;

USE agenda;

/*Table structure for table paciente */

DROP TABLE IF EXISTS paciente;

CREATE TABLE paciente ( id bigint(20) NOT NULL AUTO_INCREMENT, nome varchar(255) DEFAULT NULL, endereco varchar(255) DEFAULT NULL, cidade varchar(255) DEFAULT NULL, uf varchar(255) DEFAULT NULL, telefone varchar(255) DEFAULT NULL, celular varchar(255) DEFAULT NULL, email varchar(255) DEFAULT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table paciente */

insert into paciente(id,nome,endereco,cidade,uf,telefone,celular,email) values (1,'wenderson','rua caxambu 290','contagem','MG','(33) 3333-3333','(33) 3333-3333','w@gmail.com'),(2,'astro','astro','lua','MG','(44) 4444-4444','(55) 5555-5555','astro@hotmail.com');

/!40101 SET SQL_MODE=@OLD_SQL_MODE */; /!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS /; /!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS /; /!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
