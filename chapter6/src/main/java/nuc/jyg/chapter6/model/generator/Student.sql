-- auto Generated on 2017-08-25 15:23:47 
-- DROP TABLE IF EXISTS `student`; 
CREATE TABLE `student`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `passeword` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'passeword',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`student`';
