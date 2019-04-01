-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.59-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para serviciosmusicales
CREATE DATABASE IF NOT EXISTS `serviciosmusicales` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `serviciosmusicales`;

-- Volcando estructura para tabla serviciosmusicales.generoinstrumentos
CREATE TABLE IF NOT EXISTS `generoinstrumentos` (
  `codigoInstrumento` int(11) NOT NULL,
  `codigoGenero` int(11) NOT NULL,
  PRIMARY KEY (`codigoInstrumento`,`codigoGenero`),
  KEY `FK_generoinstrumentos_generomusical` (`codigoGenero`),
  CONSTRAINT `FK_generoinstrumentos_instrumento2` FOREIGN KEY (`codigoInstrumento`) REFERENCES `instrumento` (`codigoInstrumento`),
  CONSTRAINT `FK_generoinstrumentos_generomusical` FOREIGN KEY (`codigoGenero`) REFERENCES `generomusical` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.generoinstrumentos: ~19 rows (aproximadamente)
/*!40000 ALTER TABLE `generoinstrumentos` DISABLE KEYS */;
INSERT INTO `generoinstrumentos` (`codigoInstrumento`, `codigoGenero`) VALUES
	(2, 1),
	(3, 1),
	(4, 1),
	(11, 1),
	(16, 1),
	(3, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(3, 3),
	(9, 3),
	(10, 3),
	(11, 3),
	(12, 3),
	(3, 4),
	(12, 4),
	(13, 4),
	(14, 4),
	(15, 4),
	(3, 5);
/*!40000 ALTER TABLE `generoinstrumentos` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.generomusical
CREATE TABLE IF NOT EXISTS `generomusical` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.generomusical: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `generomusical` DISABLE KEYS */;
INSERT INTO `generomusical` (`codigo`, `nombre`) VALUES
	(1, 'Mariachi'),
	(2, 'Vallenato'),
	(3, 'Salsa'),
	(4, 'Rock'),
	(5, 'Cuerda');
/*!40000 ALTER TABLE `generomusical` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.instrumento
CREATE TABLE IF NOT EXISTS `instrumento` (
  `codigoInstrumento` int(11) NOT NULL AUTO_INCREMENT,
  `instrumento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoInstrumento`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.instrumento: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `instrumento` DISABLE KEYS */;
INSERT INTO `instrumento` (`codigoInstrumento`, `instrumento`) VALUES
	(2, 'Violin'),
	(3, 'Guitarra'),
	(4, 'Vihuela'),
	(5, 'Trompeta'),
	(6, 'Acordeon'),
	(7, 'Guacharaca'),
	(8, 'Caja'),
	(9, 'Saxofon'),
	(10, 'Clarinete'),
	(11, 'Trompeta'),
	(12, 'Contrabajo'),
	(13, 'Bateria'),
	(14, 'Piano'),
	(15, 'Bajo'),
	(16, 'Cantante');
/*!40000 ALTER TABLE `instrumento` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.instrumentomusico
CREATE TABLE IF NOT EXISTS `instrumentomusico` (
  `codigoInstrumento` int(11) NOT NULL,
  `Identificacion` varchar(50) NOT NULL,
  PRIMARY KEY (`codigoInstrumento`,`Identificacion`),
  KEY `FK_instrumentomusico_musico` (`Identificacion`),
  CONSTRAINT `FK_instrumentomusico_musico` FOREIGN KEY (`Identificacion`) REFERENCES `musico` (`identificacion`),
  CONSTRAINT `FK_instrumentomusico_instrumento` FOREIGN KEY (`codigoInstrumento`) REFERENCES `instrumento` (`codigoInstrumento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.instrumentomusico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `instrumentomusico` DISABLE KEYS */;
INSERT INTO `instrumentomusico` (`codigoInstrumento`, `Identificacion`) VALUES
	(2, '1439512'),
	(3, '14555234'),
	(4, '22666543'),
	(11, '31345098'),
	(16, '777777');
/*!40000 ALTER TABLE `instrumentomusico` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.musico
CREATE TABLE IF NOT EXISTS `musico` (
  `identificacion` varchar(50) NOT NULL,
  `estado` int(11) unsigned DEFAULT NULL,
  `precioHora` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`identificacion`),
  UNIQUE KEY `identificacion` (`identificacion`),
  CONSTRAINT `FK_musico_persona2` FOREIGN KEY (`identificacion`) REFERENCES `persona` (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.musico: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `musico` DISABLE KEYS */;
INSERT INTO `musico` (`identificacion`, `estado`, `precioHora`) VALUES
	('1439512', 1, 15000),
	('14555234', 1, 15000),
	('22666543', 1, 15000),
	('31345098', 1, 15000),
	('67876123', 1, 15000),
	('777777', 1, 35000);
/*!40000 ALTER TABLE `musico` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `identificacion` varchar(50) NOT NULL,
  `nombreCompleto` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.persona: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`identificacion`, `nombreCompleto`, `direccion`, `telefono`) VALUES
	('123', 'pepito perez', 'manzana a casa 8', '55555'),
	('1439512', 'Luis Rodriguez', 'manzana a casa 8', '55555'),
	('14555234', 'Andres Arciniegas', 'manzana a casa 8', '5555'),
	('22666543', 'Pedro Rodriguez', 'manzana a casa 8', '5555'),
	('31345098', 'Johana Velazquez', 'manzana a casa 8', '5555'),
	('67876123', 'Calos Perez', 'manzana a casa 8', '5555'),
	('777777', 'Vicente Fernandez', 'manzana a casa 8', '55555');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.serviciocomplementario
CREATE TABLE IF NOT EXISTS `serviciocomplementario` (
  `idComple` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT '0',
  `valor` bigint(20) DEFAULT '0',
  `solicitud` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`idComple`),
  KEY `FK_serviciocomplementario_solicitud` (`solicitud`),
  CONSTRAINT `FK_serviciocomplementario_solicitud` FOREIGN KEY (`solicitud`) REFERENCES `solicitud` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.serviciocomplementario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `serviciocomplementario` DISABLE KEYS */;
INSERT INTO `serviciocomplementario` (`idComple`, `descripcion`, `valor`, `solicitud`) VALUES
	(1, '12 Rosas', 10000, NULL),
	(2, 'caja por 6 Turrones de chocolate', 8000, NULL);
/*!40000 ALTER TABLE `serviciocomplementario` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.solicitud
CREATE TABLE IF NOT EXISTS `solicitud` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaSolicitud` date DEFAULT NULL,
  `fechaEvento` date DEFAULT NULL,
  `horaInicio` int(11) DEFAULT '0',
  `cantHoras` int(11) DEFAULT '0',
  `direccionEvento` varchar(100) DEFAULT '0',
  `valorTrasporte` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.solicitud: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.solicitudservicioscomp
CREATE TABLE IF NOT EXISTS `solicitudservicioscomp` (
  `idsolicitud` bigint(20) NOT NULL,
  `idServicioCompl` int(11) NOT NULL,
  PRIMARY KEY (`idsolicitud`,`idServicioCompl`),
  KEY `FK_SolicitudServiciosComp_serviciocomplementario` (`idServicioCompl`),
  CONSTRAINT `FK_SolicitudServiciosComp_serviciocomplementario` FOREIGN KEY (`idServicioCompl`) REFERENCES `serviciocomplementario` (`idComple`),
  CONSTRAINT `FK_SolicitudServiciosComp_solicitud` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.solicitudservicioscomp: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `solicitudservicioscomp` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudservicioscomp` ENABLE KEYS */;

-- Volcando estructura para tabla serviciosmusicales.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idpersona` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  PRIMARY KEY (`usuario`,`clave`),
  KEY `FK_usuario_persona2` (`idpersona`),
  CONSTRAINT `FK_usuario_persona2` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla serviciosmusicales.usuario: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idpersona`, `usuario`, `clave`) VALUES
	('123', 'pepito', 'pepito');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
