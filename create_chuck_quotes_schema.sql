-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema chuck_quotes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chuck_quotes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chuck_quotes` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `chuck_quotes` ;

-- -----------------------------------------------------
-- Table `chuck_quotes`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chuck_quotes`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chuck_quotes`.`quotes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chuck_quotes`.`quotes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
