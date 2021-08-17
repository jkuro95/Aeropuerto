-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-08-2021 a las 16:14:20
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aeropuerto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `matricula_avion` varchar(10) NOT NULL,
  `cedula_propietario` varchar(15) NOT NULL,
  `tipo_contrato` int(11) NOT NULL,
  `modelo_avion` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`matricula_avion`, `cedula_propietario`, `tipo_contrato`, `modelo_avion`) VALUES
('236BD', '1036', 1, 'Void336');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratos`
--

CREATE TABLE `contratos` (
  `tipo_contrato` int(11) NOT NULL,
  `valor_contrato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contratos`
--

INSERT INTO `contratos` (`tipo_contrato`, `valor_contrato`) VALUES
(1, 60),
(2, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hangares`
--

CREATE TABLE `hangares` (
  `codigo_hangar` int(11) NOT NULL,
  `cupos_totales` int(11) NOT NULL,
  `cupos_disponibles` int(11) NOT NULL,
  `cupos_reservados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hangares`
--

INSERT INTO `hangares` (`codigo_hangar`, `cupos_totales`, `cupos_disponibles`, `cupos_reservados`) VALUES
(1, 15, 14, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hangares_aviones`
--

CREATE TABLE `hangares_aviones` (
  `codigo_hangar` int(11) NOT NULL,
  `matricula_avion` varchar(10) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `numero_celda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hangares_aviones`
--

INSERT INTO `hangares_aviones` (`codigo_hangar`, `matricula_avion`, `fecha_ingreso`, `numero_celda`) VALUES
(1, '236PA', '2021-08-12 02:05:52', 1),
(1, '235PA', '2021-08-12 02:11:13', 2),
(1, '236BD', '2021-08-12 16:55:53', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodos_pago`
--

CREATE TABLE `metodos_pago` (
  `metodo_pago` int(11) NOT NULL,
  `nombre_metodo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `metodos_pago`
--

INSERT INTO `metodos_pago` (`metodo_pago`, `nombre_metodo`) VALUES
(1, 'contado'),
(2, 'credito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `cedula_propietario` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `metodo_pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`cedula_propietario`, `nombre`, `metodo_pago`) VALUES
('1036', 'Pablo', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`matricula_avion`),
  ADD KEY `fk_tipo_contrato` (`tipo_contrato`),
  ADD KEY `fk_cedulaa_propietario` (`cedula_propietario`);

--
-- Indices de la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD PRIMARY KEY (`tipo_contrato`);

--
-- Indices de la tabla `hangares`
--
ALTER TABLE `hangares`
  ADD PRIMARY KEY (`codigo_hangar`);

--
-- Indices de la tabla `hangares_aviones`
--
ALTER TABLE `hangares_aviones`
  ADD KEY `fk_codigo_hangar` (`codigo_hangar`);

--
-- Indices de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  ADD PRIMARY KEY (`metodo_pago`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`cedula_propietario`),
  ADD KEY `fk_metodo_pago` (`metodo_pago`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `contratos`
--
ALTER TABLE `contratos`
  MODIFY `tipo_contrato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `hangares`
--
ALTER TABLE `hangares`
  MODIFY `codigo_hangar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  MODIFY `metodo_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD CONSTRAINT `fk_cedula_propietario` FOREIGN KEY (`cedula_propietario`) REFERENCES `propietarios` (`cedula_propietario`),
  ADD CONSTRAINT `fk_cedulaa_propietario` FOREIGN KEY (`cedula_propietario`) REFERENCES `propietarios` (`cedula_propietario`),
  ADD CONSTRAINT `fk_tipo_contrato` FOREIGN KEY (`tipo_contrato`) REFERENCES `contratos` (`tipo_contrato`);

--
-- Filtros para la tabla `hangares_aviones`
--
ALTER TABLE `hangares_aviones`
  ADD CONSTRAINT `fk_codigo_hangar` FOREIGN KEY (`codigo_hangar`) REFERENCES `hangares` (`codigo_hangar`);

--
-- Filtros para la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD CONSTRAINT `fk_metodo_pago` FOREIGN KEY (`metodo_pago`) REFERENCES `metodos_pago` (`metodo_pago`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
