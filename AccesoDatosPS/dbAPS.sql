-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sistemaautenticacionps
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistemaautenticacionps
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemaautenticacionps` DEFAULT CHARACTER SET utf8 ;
USE `sistemaautenticacionps` ;

-- -----------------------------------------------------
-- Table `sistemaautenticacionps`.`Cita_paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaautenticacionps`.`Cita_paciente` (
  `idPaciente_cita` INT NOT NULL,
  `id_cita` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `id_paciente` INT NOT NULL,
  `id_medico` INT NOT NULL,
  PRIMARY KEY (`idPaciente_cita`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
