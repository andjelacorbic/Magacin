CREATE SCHEMA IF NOT EXISTS `magacin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `magacin`;

-- -----------------------------------------------------
-- Table `magacin`.`radnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magacin`.`radnik` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(50) NOT NULL,
  `prezime` VARCHAR(50) NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `telefon` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- Table `magacin`.`prostor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magacin`.`prostor` (
  `prostorId` INT NOT NULL AUTO_INCREMENT,
  `imeMagacina` VARCHAR(100) NOT NULL,
  `fk_radnik` INT NULL,
  PRIMARY KEY (`prostorId`),
  INDEX `fk_prostor_radnik_idx` (`fk_radnik` ASC),
  CONSTRAINT `fk_prostor_radnik`
    FOREIGN KEY (`fk_radnik`)
    REFERENCES `magacin`.`radnik` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `magacin`.`proizvod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `magacin`.`proizvod` (
  `proizvodId` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(100) NOT NULL,
  `tip` VARCHAR(50) NOT NULL,
  `tezina` VARCHAR(20) NOT NULL,
  `kolicina` INT NOT NULL,
  `napomena` TEXT NULL,
  `fk_prostor` INT NOT NULL,
  PRIMARY KEY (`proizvodId`),
  INDEX `fk_proizvod_prostor_idx` (`fk_prostor` ASC),
  CONSTRAINT `fk_proizvod_prostor`
    FOREIGN KEY (`fk_prostor`)
    REFERENCES `magacin`.`prostor` (`prostorId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
