-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SistemaCita
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SistemaCita
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SistemaCita` DEFAULT CHARACTER SET utf8 ;
USE `SistemaCita` ;

-- -----------------------------------------------------
-- Table `SistemaCita`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaCita`.`Paciente` (
  `idPaciente` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  `idExpediente` INT NOT NULL,
  PRIMARY KEY (`idPaciente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaCita`.`Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaCita`.`Medico` (
  `idMedico` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `cedulaProfesional` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMedico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaCita`.`Cita_paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaCita`.`Cita_paciente` (
  `idCita` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  `id_paciente` INT NOT NULL,
  `idMedico` INT NOT NULL,
  PRIMARY KEY (`idCita`),
  INDEX `id_paciente_idx` (`id_paciente` ASC) VISIBLE,
  INDEX `id_medico_idx` (`idMedico` ASC) VISIBLE,
  CONSTRAINT `id_paciente_CP`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `SistemaCita`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_medico_CP`
    FOREIGN KEY (`idMedico`)
    REFERENCES `SistemaCita`.`Medico` (`idMedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaCita`.`Usuario_Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaCita`.`Usuario_Paciente` (
  `idUsuario_Paciente` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `idPaciente` INT NOT NULL,
  PRIMARY KEY (`idUsuario_Paciente`),
  INDEX `id_paciente_idx` (`idPaciente` ASC) VISIBLE,
  CONSTRAINT `idPaciente_UP`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `SistemaCita`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaCita`.`Tutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaCita`.`Tutor` (
  `idTutor` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `parentesco` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaCita`.`Paciente_Tutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaCita`.`Paciente_Tutor` (
  `idPaciente_Tutor` INT NOT NULL,
  `id_paciente` INT NOT NULL,
  `id_tutor` INT NOT NULL,
  PRIMARY KEY (`idPaciente_Tutor`),
  INDEX `idPaciente_idx` (`id_paciente` ASC) VISIBLE,
  INDEX `idTutor_idx` (`id_tutor` ASC) VISIBLE,
  CONSTRAINT `idPaciente_PT`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `SistemaCita`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTutor_PT`
    FOREIGN KEY (`id_tutor`)
    REFERENCES `SistemaCita`.`Tutor` (`idTutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
