
CREATE SCHEMA IF NOT EXISTS `magacin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `magacin`;


CREATE TABLE IF NOT EXISTS `magacin`.`radnik` (
  `id_radnik` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(64) NOT NULL,
  `prezime` VARCHAR(64) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(88) NOT NULL,
  `telefon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_radnik`),
  UNIQUE INDEX `uq_radnik_username` (`username` ASC),
  UNIQUE INDEX `uq_radnik_telefon` (`telefon` ASC)
);


CREATE TABLE IF NOT EXISTS `magacin`.`prostor` (
  `id_prostor` INT NOT NULL AUTO_INCREMENT,
  `ime_magacina` VARCHAR(45) NOT NULL,
  `fk_radnik` INT NOT NULL,
  PRIMARY KEY (`id_prostor`),
  INDEX `fk_prostor_radnik_idx` (`fk_radnik` ASC),
  CONSTRAINT `fk_prostor_radnik`
    FOREIGN KEY (`fk_radnik`)
    REFERENCES `magacin`.`radnik` (`id_radnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS `magacin`.`proizvod` (
  `id_proizvod` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `tip` VARCHAR(45) NOT NULL,
  `tezina` VARCHAR(45) NOT NULL,
  `kolicina` INT NOT NULL DEFAULT 0,
  `napomena` VARCHAR(80) NULL,
  `fk_prostor` INT NOT NULL,
  PRIMARY KEY (`id_proizvod`),
  INDEX `fk_proizvod_prostor_idx` (`fk_prostor` ASC),
  CONSTRAINT `fk_proizvod_prostor`
    FOREIGN KEY (`fk_prostor`)
    REFERENCES `magacin`.`prostor` (`id_prostor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS `magacin`.`transakcija` (
  `id_transakcija` INT NOT NULL AUTO_INCREMENT,
  `fk_proizvod` INT NOT NULL,
  `tip_transakcije` ENUM('Dodavanje', 'Izmena', 'Brisanje') NOT NULL,
  `datum` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `kolicina_promena` INT NOT NULL,
  PRIMARY KEY (`id_transakcija`),
  INDEX `fk_transakcija_proizvod_idx` (`fk_proizvod` ASC),
  CONSTRAINT `fk_transakcija_proizvod`
    FOREIGN KEY (`fk_proizvod`)
    REFERENCES `magacin`.`proizvod` (`id_proizvod`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
