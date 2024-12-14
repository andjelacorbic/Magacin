CREATE SCHEMA IF NOT EXISTS `magacin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `magacin`;

-- -----------------------------------------------------
-- Table `magacin`.`radnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magacin`.`radnik` (
  `radnik_id` INT NOT NULL AUTO_INCREMENT,
  `ime_i_prezime` VARCHAR(64) NOT NULL,
  `username` VARCHAR(45) NOT NULL UNIQUE,
  `password` VARCHAR(88) NOT NULL,
  `telefon` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`radnik_id`),
  UNIQUE INDEX `uq_radnik_username` (`username` ASC),
  UNIQUE INDEX `uq_radnik_telefon` (`telefon` ASC)
);

-- -----------------------------------------------------
-- Table `magacin`.`prostor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magacin`.`prostor` (
  `prostor_id` INT NOT NULL AUTO_INCREMENT,
  `radnik_id` INT NOT NULL,
  `ime_magacina` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`prostor_id`),
  INDEX `fk_prostor_radnik_id_idx` (`radnik_id` ASC),
  CONSTRAINT `fk_prostor_radnik`
    FOREIGN KEY (`radnik_id`)
    REFERENCES `magacin`.`radnik` (`radnik_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- Table `magacin`.`proizvod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magacin`.`proizvod` (
  `proizvod_id` INT NOT NULL AUTO_INCREMENT,
  `prostor_id` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `tip` VARCHAR(45) NOT NULL,
  `tezina` VARCHAR(45) NULL,
  `kolicina` INT NULL,
  `napomena` VARCHAR(80) NULL,
  PRIMARY KEY (`proizvod_id`),
  INDEX `fk_proizvod_prostor_id_idx` (`prostor_id` ASC),
  CONSTRAINT `fk_proizvod_prostor`
    FOREIGN KEY (`prostor_id`)
    REFERENCES `magacin`.`prostor` (`prostor_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
