-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sistemaexpediente
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistemaexpediente
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemaexpediente` DEFAULT CHARACTER SET utf8 ;
USE `sistemaexpediente` ;

-- -----------------------------------------------------
-- Table `sistemaexpediente`.`Consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaexpediente`.`Consulta` (
  `idConsulta` INT NOT NULL,
  `sintomas` VARCHAR(200) NOT NULL,
  `diagnostico` VARCHAR(200) NOT NULL,
  `receta` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idConsulta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaexpediente`.`Expediente_Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sistemaexpediente`.`Expediente_Paciente` (
  `idExpediente` INT NOT NULL,
  `id_paciente` INT NOT NULL,
  `id_consulta` INT NOT NULL,
  PRIMARY KEY (`idExpediente`),
  INDEX `id_consultaE_idx` (`id_consulta` ASC) VISIBLE,
  CONSTRAINT `id_consultaE`
    FOREIGN KEY (`id_consulta`)
    REFERENCES `sistemaexpediente`.`Consulta` (`idConsulta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
