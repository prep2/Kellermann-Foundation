/* Need to create scipts to find the totals at the end of the HMIS data form*/

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`babyCondition`(
	`code` VARCHAR(5) NOT NULL,
	`description` VARCHAR(100) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the baby condition.'
ENGINE=InnoDB
;

DELETE FROM `babyCondition`;

INSERT INTO `babyCondition` (`code`,`description`)
VALUES
('MSB', 'Macerated still birth'),
('FSB', 'Fresh still birth'),
('NND', 'Immediate Neonatal Death (death within 24 hours)'),
('AL', 'Live Baby'),
('BDF', 'Baby born with defect')
;

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`motherCondition`(
	`code` VARCHAR(5) NOT NULL,
	`description` VARCHAR(100) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the mother condition.'
ENGINE=InnoDB
;

DELETE FROM `motherCondition`;

INSERT INTO `motherCondition` (`code`,`description`)
VALUES
('D', 'Woman discharged is alive'),
('DD', 'Woman died'),
('R', 'If the woman ran away or left before being discharged'),
('T', 'Woman transferred to another facility'),
('DF', 'Woman discharged alive with Fistula'),
('DDF', 'Woman died with Fistula'),
('RF', 'Woman ran away with Fistula'),
('TF', 'Woman transferred with Fistula')
;

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`familyplanning`(
	`code` int(2) NOT NULL,
	`description` VARCHAR(100) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the family planning codes'
ENGINE=InnoDB
;

INSERT INTO `familyplanning` (`code`,`description`)
VALUES
('1', 'Post Partum Female Sterilization (Bilateral Tubal Litigation)(PP - BTL)'),
('2', 'Post Partum IUD(PP - IUD)'),
('3', 'IUD as part of Post-Abortion Care (PAC - IUD)'),
('4', 'Implant as part of Post-Abortion Care'),
('5', 'Oral pills as part of Post-Abortion Care'),
('6', 'Depo as part of Post-Abortion Care'),
('7', 'Other Family Planning Methods - needs work'),
('8', 'No Family Planning Method Given')
;

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`iycffeeding`(
	`code` VARCHAR(3) NOT NULL,
	`description` VARCHAR(50) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the iycf feeding codes'
ENGINE=InnoDB
;

INSERT INTO `iycffeeding` (`code`,`description`)
VALUES
('EBF', 'For Exclusive breast feeding'),
('RF', 'Replacement Feeding'),
('MF', 'Mixed Feeding')
;

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`counseled`(
	`code` VARCHAR(2) NOT NULL,
	`description` VARCHAR(20) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the counseling codes'
ENGINE=InnoDB
;

INSERT INTO `counseled` (`code`,`description`)
VALUES
('C', 'Counseled'),
('NC', 'Not counseled')
;

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`breathing`(
	`code` VARCHAR(3) NOT NULL,
	`description` VARCHAR(100) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the breathing codes'
ENGINE=InnoDB
;

INSERT INTO `breathing` (`code`,`description`)
VALUES
('SS', 'If baby breathers after Stimulation and or Suction procedure'),
('BM', 'If baby breathes after Bag and Mask procedure'),
('BMD', 'if baby dies Bag and Mask procedure')
;

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`muacColor`(
	`code` VARCHAR(1) NOT NULL,
	`description` VARCHAR(10) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the muac colour codes'
ENGINE=InnoDB
;

INSERT INTO `muacColor` (`code`,`description`)
VALUES
('R', 'Red'),
('Y', 'Yellow'),
('G', 'Green')
;

/*Check what arvs are */

/*Find out about Check/Tick symbol */

CREATE TABLE IF NOT EXISTS `bwindihospital_reduced`.`emtct_code`(
	`code` VARCHAR(5) NOT NULL,
	`description` VARCHAR(100) NULL DEFAULT NULL,
PRIMARY KEY (`code`)
)
COMMENT='This table holds the data for the eMTCT codes'
ENGINE=InnoDB
;

INSERT INTO `emtct_code` (`code`, `description`)
VALUES
('C', 'Counseled but declined HIV testing'),
('T', 'Counseled and tested but didnt receive results'),
('TR', 'Counseled tested and results given - Client tested HIV Negative in maternity'),
('TRR', 'Counseled tested and results given - Client tested HIV Positive in maternity'),
('TRR+', 'Client was originally negative but sero-converted at this test')
;

CREATE TABLE IF NOT EXISTS `final_diagnosis` (
	`finalDiagNum` INT(1) NOT NULL,
	`finalDiagDesc` VARCHAR(100) NULL DEFAULT NULL,
	PRIMARY KEY (`finalDiagNum`),
	INDEX `finalDiagNum` (`finalDiagNum`)
)
COMMENT='This table holds the final diagnosis codes and descriptions.'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

INSERT INTO `final_diagnosis` (`finalDiagNum`, `finalDiagDesc`) 
VALUES 
('1', 'Abortions'),
('2', 'APH'),
('3', 'PPH'),
('4', 'Malaria in pregnancy'),
('5', 'High blood pressure in pregnancy'),
('6', 'Obstructed labour'),
('7', 'Puerperal sepsis'),
('8', 'Sepsis related to pregnancy'),
('9', 'Anaemia in pregnancy'),
('10', 'Ruptured uterus'),
('11', 'Ectopic pregnancy'),
('12', 'Other Complications of pregnancy')
;

CREATE TABLE IF NOT EXISTS `hmis` (
	`recordDate` DATE NULL DEFAULT NULL,
	`dateOfAdmission` DATE NULL DEFAULT NULL,
	`IPD` INT(20) NOT NULL,
	`ancNum` INT(20) NULL DEFAULT NULL,
	`ancRef` VARCHAR(50) NULL DEFAULT NULL,
	`matName` VARCHAR(50) NULL DEFAULT NULL,
	`villageID` VARCHAR(10) NULL DEFAULT NULL,
	`matVillage` VARCHAR(20) NULL DEFAULT NULL,
	`matPhoneNumber` VARCHAR(50) NULL DEFAULT NULL,
	`age` INT(3) NULL DEFAULT NULL,
	`gravida` INT(5) NULL DEFAULT NULL,
	`parity` INT(5) NULL DEFAULT NULL,
	`weeksGestation` INT(2) NULL DEFAULT NULL,
	`term` VARCHAR(10) NULL DEFAULT NULL,
	`finalDiagnosis` INT(2) NULL DEFAULT NULL,
	`hivTestDate` DATE NULL DEFAULT NULL,
	`whoClinicalStage` VARCHAR(10) NULL DEFAULT NULL,
	`cd4Count` VARCHAR(5) NULL DEFAULT NULL,
	`viralLoad` INT(5) NULL DEFAULT NULL,
	`revisit` BIT(1) NULL DEFAULT NULL,
	`deliveryMode` VARCHAR(100) NULL DEFAULT NULL,
	`deliveryDate` DATE NULL DEFAULT NULL,
	`deliveryTime` TIME NULL DEFAULT NULL,
	`ergometrine` BIT(1) NULL DEFAULT NULL,
	`pitocin` BIT(1) NULL DEFAULT NULL,
	`misoprostol` BIT(1) NULL DEFAULT NULL,
	`otherMeds` VARCHAR(100) NULL DEFAULT NULL,
	`emtctCode` VARCHAR(5) NULL DEFAULT NULL,
	`arvs` VARCHAR(3) NULL DEFAULT NULL,
	`vitaminA` BIT(1) NULL DEFAULT NULL,
	`muacColor` CHAR(1) NULL DEFAULT NULL,
	`muacCM` INT(2) NULL DEFAULT NULL,
	`muacINR` INT(20) NULL DEFAULT NULL,
	`apgarScore` VARCHAR(10) NULL DEFAULT NULL,
	`sexOfBaby` BIT(1) NULL DEFAULT NULL,
	`breathing` VARCHAR(3) NULL DEFAULT NULL,
	`skinToSkin` BIT(1) NULL DEFAULT NULL,
	`breastFed` BIT(1) NULL DEFAULT NULL,
	`teo` BIT(1) NULL DEFAULT NULL,
	`vitK` BIT(1) NULL DEFAULT NULL,
	`chlorhexidine` BIT(1) NULL DEFAULT NULL,
	`counseled` VARCHAR(2) NULL DEFAULT NULL,
	`matNutrCouns` BIT(1) NULL DEFAULT NULL,
	`iycf` BIT(1) NULL DEFAULT NULL,
	`iycfFeeding` VARCHAR(3) NULL DEFAULT NULL,
	`weight` DECIMAL(5,3) NULL DEFAULT NULL,
	`arvsBaby` VARCHAR(100) NULL DEFAULT NULL,
	`immunized` BIT(1) NULL DEFAULT NULL,
	`familyPlanning` INT(2) NULL DEFAULT NULL,
	`motherCondition` VARCHAR(5) NULL DEFAULT NULL,
	`babyCondition` VARCHAR(5) NULL DEFAULT NULL,
	`deliveredBy` VARCHAR(100) NULL DEFAULT NULL,
	`postNatalCare` DATE NULL DEFAULT NULL,
	`dateOfDischarge` DATE NULL DEFAULT NULL,
	`nameDischarge` VARCHAR(100) NULL DEFAULT NULL,
	`userID` INT(10) NOT NULL,
	PRIMARY KEY (`IPD`),
	INDEX `matVillage` (`matVillage`, `userID`)
)
COMMENT='This table holds the data for each patient in the maternity ward.'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

