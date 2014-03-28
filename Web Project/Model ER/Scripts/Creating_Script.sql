SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `JuridicApp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `JuridicApp` ;

-- -----------------------------------------------------
-- Table `JuridicApp`.`PEOPLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`PEOPLE` (
  `document_type` VARCHAR(45) NOT NULL COMMENT ' - Cédula De Ciudadanía.\n - Cédula De Extranjería.\n - Número Único De Identificación Personal.\n - Registro Civil.\n - Tarjeta De Identidad.' ,
  `id_number` VARCHAR(20) NOT NULL COMMENT 'Número De Identificación asociado al Tipo De Documento.' ,
  `first_names` VARCHAR(35) NOT NULL ,
  `last_names` VARCHAR(35) NOT NULL ,
  `email` VARCHAR(35) NOT NULL ,
  PRIMARY KEY (`document_type`, `id_number`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`AUTHOR` (
  `document_type` VARCHAR(45) NOT NULL ,
  `id_number` VARCHAR(20) NOT NULL ,
  `phone_number` VARCHAR(10) NULL ,
  `mobile_number` VARCHAR(12) NULL ,
  PRIMARY KEY (`document_type`, `id_number`) ,
  INDEX `fk_AUTHOR_PEOPLE1_idx` (`document_type` ASC, `id_number` ASC) ,
  CONSTRAINT `fk_AUTHOR_PEOPLE1`
    FOREIGN KEY (`document_type` , `id_number` )
    REFERENCES `JuridicApp`.`PEOPLE` (`document_type` , `id_number` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`DNDA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`DNDA` (
  `number` VARCHAR(30) NOT NULL COMMENT 'Número del Registro del Contrato ante la Dirección Nacional de Derecho de Autor.' ,
  PRIMARY KEY (`number`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`DEPENDENCY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`DEPENDENCY` (
  `name` VARCHAR(35) NOT NULL COMMENT 'Nombre de la Dependencia Académica encargada de la Obra.' ,
  `description` VARCHAR(150) NULL COMMENT 'Descripción breve sobre la Dependencia Académica.' ,
  `dnda` VARCHAR(30) NULL ,
  PRIMARY KEY (`name`) ,
  INDEX `fk_DEPENDENCY_DNDA1_idx` (`dnda` ASC) ,
  CONSTRAINT `fk_DEPENDENCY_DNDA1`
    FOREIGN KEY (`dnda` )
    REFERENCES `JuridicApp`.`DNDA` (`number` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`OEUVRE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`OEUVRE` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Número autoincrementable de identificación inequívoca.' ,
  `title` VARCHAR(55) NOT NULL COMMENT 'Nombre propio.' ,
  `description` VARCHAR(250) NULL COMMENT 'Descripción breve.' ,
  `dependency` VARCHAR(35) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_OEUVRE_DEPENDENCY1_idx` (`dependency` ASC) ,
  CONSTRAINT `fk_OEUVRE_DEPENDENCY1`
    FOREIGN KEY (`dependency` )
    REFERENCES `JuridicApp`.`DEPENDENCY` (`name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`TITLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`TITLE` (
  `profile` VARCHAR(35) NOT NULL COMMENT 'Vínculo o relación con la Universidad al momento de la entrega de la Obra.\n\n - Profesor Vinculado.\n - Profesor Ocasional.\n - Profesor Visitante.\n - Profesor Ad Honórem.\n - Profesor De Cátedra.\n - Estudiante De Pregrado.\n - Estudiante De Postgrado.\n - Empl /* comment truncated */ /*eado De Carrera.
 - Empleado De Libre Nombramiento.
 - Empleado Provisional.
 - Empleado Ocasional.
 - Contratista.
 - Externo.
 - No Aplica.*/' ,
  `description` VARCHAR(150) NULL ,
  PRIMARY KEY (`profile`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`ACQUISITION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`ACQUISITION` (
  `type` VARCHAR(35) NOT NULL COMMENT 'Forma o vía en la cual se hizo la adquisión de la Obra.\n\n - Contrato De Cesión De Derechos.\n - Contrato De Obra Por Encargo.\n - Presunción Legal Plan De Trabajo.\n - Autorización.\n - Licencia De Software.\n - Licencia Creative Commons.' ,
  `description` VARCHAR(150) NULL ,
  PRIMARY KEY (`type`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`CONTRACT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`CONTRACT` (
  `id` VARCHAR(30) NOT NULL COMMENT 'Número de contrato suscrito.' ,
  `route` VARCHAR(200) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`SUPPORT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`SUPPORT` (
  `type` VARCHAR(25) NOT NULL COMMENT 'Soporte en el cual se entrega la Obra.\n\n - Físico.\n - Digital.' ,
  `description` VARCHAR(150) NULL ,
  PRIMARY KEY (`type`) ,
  UNIQUE INDEX `type_UNIQUE` (`type` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`COMMENT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`COMMENT` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Número sequencial autoincrementable asociado a cada comentario.' ,
  `oeuvre_id` BIGINT UNSIGNED NOT NULL ,
  `text` VARCHAR(250) NOT NULL COMMENT 'Texto correspondiente a la observación' ,
  `date_time` DATETIME NOT NULL COMMENT 'Fecha en la que se realizó la observación.' ,
  PRIMARY KEY (`id`, `oeuvre_id`) ,
  INDEX `fk_COMMENT_OEUVRE1_idx` (`oeuvre_id` ASC) ,
  CONSTRAINT `fk_COMMENT_OEUVRE1`
    FOREIGN KEY (`oeuvre_id` )
    REFERENCES `JuridicApp`.`OEUVRE` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`TYPE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`TYPE` (
  `name` VARCHAR(45) NOT NULL COMMENT 'Tipo de obra.\n\n - Escrito.\n - Programa De Ordenador (Software).\n - Audiovisual, Multimedia.\n - Exposición (Conferencia).\n - Composición Musical.\n - Obra De Bellas Artes.\n - Obra Fotográfica.\n - Ilustración (Mapa).\n - Obra Derivada.\n - Otro.' ,
  `description` VARCHAR(150) NULL ,
  PRIMARY KEY (`name`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`OEUVRE_TYPE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`OEUVRE_TYPE` (
  `oeuvre_id` BIGINT UNSIGNED NOT NULL ,
  `type_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`oeuvre_id`, `type_name`) ,
  INDEX `fk_OEUVRE_TYPE_TYPE1_idx` (`type_name` ASC) ,
  CONSTRAINT `fk_OEUVRE_TYPE_OEUVRE`
    FOREIGN KEY (`oeuvre_id` )
    REFERENCES `JuridicApp`.`OEUVRE` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OEUVRE_TYPE_TYPE1`
    FOREIGN KEY (`type_name` )
    REFERENCES `JuridicApp`.`TYPE` (`name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR_OEUVRE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`AUTHOR_OEUVRE` (
  `oeuvre_type_id` BIGINT UNSIGNED NOT NULL ,
  `oeuvre_type_name` VARCHAR(45) NOT NULL ,
  `document_type` VARCHAR(45) NOT NULL ,
  `id_number` VARCHAR(20) NOT NULL ,
  `contract` VARCHAR(30) NOT NULL ,
  `support_type` VARCHAR(25) NOT NULL ,
  `dnda` VARCHAR(30) NULL ,
  `isbn` VARCHAR(35) NULL ,
  `beginning` DATE NOT NULL ,
  `delivering` DATE NOT NULL ,
  `title` VARCHAR(35) NOT NULL ,
  PRIMARY KEY (`oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`) ,
  INDEX `fk_AUTHOR_OEUVRE_OEUVRE_TYPE1_idx` (`oeuvre_type_id` ASC, `oeuvre_type_name` ASC) ,
  INDEX `fk_AUTHOR_OEUVRE_SUPPORT1_idx` (`support_type` ASC) ,
  INDEX `fk_AUTHOR_OEUVRE_DNDA1_idx` (`dnda` ASC) ,
  INDEX `fk_AUTHOR_OEUVRE_AUTHOR1_idx` (`document_type` ASC, `id_number` ASC) ,
  INDEX `fk_AUTHOR_OEUVRE_TITLE1_idx` (`title` ASC) ,
  INDEX `fk_AUTHOR_OEUVRE_CONTRACT1_idx` (`contract` ASC) ,
  CONSTRAINT `fk_AUTHOR_OEUVRE_OEUVRE_TYPE1`
    FOREIGN KEY (`oeuvre_type_id` , `oeuvre_type_name` )
    REFERENCES `JuridicApp`.`OEUVRE_TYPE` (`oeuvre_id` , `type_name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTHOR_OEUVRE_SUPPORT1`
    FOREIGN KEY (`support_type` )
    REFERENCES `JuridicApp`.`SUPPORT` (`type` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTHOR_OEUVRE_DNDA1`
    FOREIGN KEY (`dnda` )
    REFERENCES `JuridicApp`.`DNDA` (`number` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTHOR_OEUVRE_AUTHOR1`
    FOREIGN KEY (`document_type` , `id_number` )
    REFERENCES `JuridicApp`.`AUTHOR` (`document_type` , `id_number` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTHOR_OEUVRE_TITLE1`
    FOREIGN KEY (`title` )
    REFERENCES `JuridicApp`.`TITLE` (`profile` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTHOR_OEUVRE_CONTRACT1`
    FOREIGN KEY (`contract` )
    REFERENCES `JuridicApp`.`CONTRACT` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`PROFILE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`PROFILE` (
  `title` VARCHAR(25) NOT NULL ,
  `description` VARCHAR(150) NULL ,
  PRIMARY KEY (`title`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`CLIENT`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`CLIENT` (
  `document_type` VARCHAR(45) NOT NULL ,
  `id_number` VARCHAR(20) NOT NULL ,
  `user_name` VARCHAR(25) NOT NULL ,
  `password` VARCHAR(25) NOT NULL ,
  `title` VARCHAR(25) NOT NULL ,
  `dependency` VARCHAR(35) NOT NULL ,
  PRIMARY KEY (`document_type`, `id_number`) ,
  INDEX `fk_CLIENT_PROFILE1_idx` (`title` ASC) ,
  INDEX `fk_CLIENT_DEPENDENCY1_idx` (`dependency` ASC) ,
  CONSTRAINT `fk_CLIENT_PEOPLE1`
    FOREIGN KEY (`document_type` , `id_number` )
    REFERENCES `JuridicApp`.`PEOPLE` (`document_type` , `id_number` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CLIENT_PROFILE1`
    FOREIGN KEY (`title` )
    REFERENCES `JuridicApp`.`PROFILE` (`title` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CLIENT_DEPENDENCY1`
    FOREIGN KEY (`dependency` )
    REFERENCES `JuridicApp`.`DEPENDENCY` (`name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `JuridicApp`.`AUTHOR_OEUVRE_ACQUISITION_FILE` (
  `acquisition` VARCHAR(35) NOT NULL ,
  `oeuvre_type_id` BIGINT UNSIGNED NOT NULL ,
  `oeuvre_type_name` VARCHAR(45) NOT NULL ,
  `document_type` VARCHAR(45) NOT NULL ,
  `id_number` VARCHAR(20) NOT NULL ,
  `contract` VARCHAR(30) NOT NULL ,
  `route` VARCHAR(300) NOT NULL ,
  PRIMARY KEY (`acquisition`, `oeuvre_type_id`, `oeuvre_type_name`, `document_type`, `id_number`, `contract`) ,
  INDEX `fk_AUTHOR_OEUVRE_ACQUISITION_ACQUISITION1_idx` (`acquisition` ASC) ,
  INDEX `fk_AUTHOR_OEUVRE_ACQUISITION_AUTHOR_OEUVRE1_idx` (`oeuvre_type_id` ASC, `oeuvre_type_name` ASC, `document_type` ASC, `id_number` ASC, `contract` ASC) ,
  CONSTRAINT `fk_AUTHOR_OEUVRE_ACQUISITION_ACQUISITION1`
    FOREIGN KEY (`acquisition` )
    REFERENCES `JuridicApp`.`ACQUISITION` (`type` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTHOR_OEUVRE_ACQUISITION_AUTHOR_OEUVRE1`
    FOREIGN KEY (`oeuvre_type_id` , `oeuvre_type_name` , `document_type` , `id_number` , `contract` )
    REFERENCES `JuridicApp`.`AUTHOR_OEUVRE` (`oeuvre_type_id` , `oeuvre_type_name` , `document_type` , `id_number` , `contract` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `JuridicApp` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
