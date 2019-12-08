CREATE SCHEMA `storage` ;

use storage;

CREATE TABLE `storage`.`subsystem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `storage`.`command` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subsystem_id` INT NOT NULL,
  `command` VARCHAR(45) NULL,
  `resault` VARCHAR(45) NULL,
  `timestamp` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `subsystem_id_idx` (`subsystem_id` ASC) VISIBLE,
  CONSTRAINT `subsystem_id`
    FOREIGN KEY (`subsystem_id`)
    REFERENCES `storage`.`subsystem` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
