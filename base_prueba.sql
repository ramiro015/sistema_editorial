-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 19-05-2024 a las 18:56:30
-- Versión del servidor: 10.11.7-MariaDB-cll-lve
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `u489541634_prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consignacion`
--

CREATE TABLE `consignacion` (
  `id_consignacion` int(5) NOT NULL,
  `id_tienda` int(5) DEFAULT NULL,
  `fecha` date NOT NULL,
  `remito` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `consignacion`
--

INSERT INTO `consignacion` (`id_consignacion`, `id_tienda`, `fecha`, `remito`) VALUES
(1, 1, '2024-05-10', '0001-00012345'),
(2, 1, '2024-05-14', '0001-00012346');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_consignacion`
--

CREATE TABLE `detalle_consignacion` (
  `id_detalle_consignacion` int(11) NOT NULL,
  `id_consignacion` int(11) DEFAULT NULL,
  `id_titulo` int(5) DEFAULT NULL,
  `cantidad` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `detalle_consignacion`
--

INSERT INTO `detalle_consignacion` (`id_detalle_consignacion`, `id_consignacion`, `id_titulo`, `cantidad`) VALUES
(1, 1, 1, 5),
(2, 1, 2, 10),
(3, 2, 1, 10),
(4, 2, 3, 5),
(5, 2, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `id_detalle` int(11) NOT NULL,
  `id_venta` int(11) DEFAULT NULL,
  `id_titulo` int(5) DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_detalle`, `id_venta`, `id_titulo`, `cantidad`, `precio`) VALUES
(1, 1, 4, 2, 15000.00),
(2, 1, 1, 2, 15000.00),
(3, 2, 2, 2, 14000.00),
(4, 3, 5, 3, 20000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edicion`
--

CREATE TABLE `edicion` (
  `id_edicion` int(11) NOT NULL,
  `id_titulo` int(11) DEFAULT NULL,
  `id_formato` int(1) DEFAULT NULL,
  `numero_edicion` int(2) NOT NULL,
  `ISBN` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `edicion`
--

INSERT INTO `edicion` (`id_edicion`, `id_titulo`, `id_formato`, `numero_edicion`, `ISBN`) VALUES
(1, 1, 1, 1, '9789874787408'),
(2, 1, 3, 1, '9789874787415'),
(3, 2, 1, 1, '9789874774521'),
(4, 2, 3, 1, '9789874774538'),
(5, 3, 1, 1, '9789874787422'),
(6, 3, 1, 2, '9789874787446');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edicion_formato`
--

CREATE TABLE `edicion_formato` (
  `id_formato` int(1) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `edicion_formato`
--

INSERT INTO `edicion_formato` (`id_formato`, `descripcion`) VALUES
(1, 'Tapa blanda'),
(2, 'Tapa dura'),
(3, 'E-book');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_precio`
--

CREATE TABLE `historial_precio` (
  `id_historial` int(11) NOT NULL,
  `id_titulo` int(11) DEFAULT NULL,
  `PVP` decimal(10,2) NOT NULL,
  `fecha_desde` date NOT NULL,
  `fecha_hasta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `historial_precio`
--

INSERT INTO `historial_precio` (`id_historial`, `id_titulo`, `PVP`, `fecha_desde`, `fecha_hasta`) VALUES
(1, 1, 11000.00, '2024-02-01', '2024-02-29'),
(2, 1, 15000.00, '2024-02-29', '2024-04-30'),
(3, 1, 18000.00, '2024-05-01', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imprenta`
--

CREATE TABLE `imprenta` (
  `id_imprenta` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `CUIT` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `imprenta`
--

INSERT INTO `imprenta` (`id_imprenta`, `nombre`, `CUIT`) VALUES
(1, 'BGK', '3011223344-'),
(2, 'Gráficas del Sur', '33556677889'),
(3, 'Talleres Gráficos Porter', '34998877660');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rendicion`
--

CREATE TABLE `rendicion` (
  `id_rendicion` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `fecha_pago` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE `tarea` (
  `id_tarea` int(11) NOT NULL,
  `id_estado` int(1) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id_tarea`, `id_estado`, `id_usuario`, `nombre`, `descripcion`) VALUES
(1, 3, 1, 'Reescribir escena', 'Reforzar la escena utilizando los cinco sentidos.'),
(2, 2, 1, 'Crear storyboard', 'Desarrollar un storyboard detallado para la escena.'),
(3, 1, 3, 'Revisar diálogo', 'Asegurarse de que el diálogo sea coherente con los personajes.'),
(4, 3, 2, 'Editar guion', 'Realizar una edición de estilo y formato en el guion completo.'),
(5, 3, 4, 'Investigar locaciones', 'Buscar y documentar posibles locaciones para las escenas exteriores.'),
(6, 2, 1, 'Diseñar vestuario', 'Crear bocetos para el vestuario de los personajes principales.'),
(7, 2, 1, 'Coordinar ensayo', 'Organizar un ensayo general con todos los actores.'),
(8, 3, 3, 'Grabar efectos de sonido', 'Capturar efectos de sonido necesarios para las escenas clave.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea_estado`
--

CREATE TABLE `tarea_estado` (
  `id_estado` int(11) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tarea_estado`
--

INSERT INTO `tarea_estado` (`id_estado`, `estado`) VALUES
(1, 'Por hacer'),
(2, 'En proceso'),
(3, 'Listo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE `tienda` (
  `id_tienda` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `CUIT` char(11) NOT NULL,
  `porcentaje` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`id_tienda`, `nombre`, `CUIT`, `porcentaje`) VALUES
(1, 'Mundo Lectura', '21474836478', 40.00),
(2, 'El mundo del libro', '33876543212', 45.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tirada`
--

CREATE TABLE `tirada` (
  `id_tirada` int(11) NOT NULL,
  `id_edicion` int(11) DEFAULT NULL,
  `id_imprenta` int(3) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `inversion` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tirada`
--

INSERT INTO `tirada` (`id_tirada`, `id_edicion`, `id_imprenta`, `fecha`, `cantidad`, `inversion`) VALUES
(1, 1, 1, '2024-03-01', 50, 400000.00),
(2, 3, 2, '2024-03-01', 200, 1000000.00),
(3, 6, 3, '2024-03-18', 100, 500000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titulo`
--

CREATE TABLE `titulo` (
  `id_titulo` int(5) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `subtitulo` varchar(50) NOT NULL,
  `portada` varchar(100) NOT NULL,
  `sinopsis` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `titulo`
--

INSERT INTO `titulo` (`id_titulo`, `titulo`, `subtitulo`, `portada`, `sinopsis`) VALUES
(1, 'Y el mundo gira', '', 'https://edicionesfey.com/wp-content/uploads/2022/06/9789874787415-768x1112.jpg', 'Si nuestro mundo se detiene, solo queda respirar profundo, mirar hacia el interior y reunir las fuerzas necesarias para retomar el ritmo.\r\n\r\nLean tiene 17 años y, como cualquier adolescente, disfruta de pasar el mayor tiempo posible con sus amigos, especialmente junto a Mateo. Pero cuando la tragedia detenga su mundo, tendrá que buscar la forma de atravesar la tristeza y el dolor, para redescubrir el valor de la amistad, el amor, y aceptarse a sí mismo.'),
(2, 'Tabú', 'el juego prohibido', 'https://edicionesfey.com/wp-content/uploads/2022/06/9789874774521-scaled-e1694610270740.jpg', 'Leandro ha gozado de la comodidad que ofrece el dinero de su familia. Ahora, en la universidad, su vida gira alrededor de eternas fiestas y noches libertinas. Ninguno de los muchachos que elige puede escapar de sus encantos ni sus estrategias. Sin embargo, la llegada de Gastón, su nuevo profesor, le presentará un desafío inesperado. Los juegos se convertirán en una obsesión y lo llevarán a poner en marcha un plan para conquistarlo y, aunque se resista, sacarlo del armario. Sus intrigas desenterrarán recuerdos olvidados, pondrán en jaque lo que cada uno ha construido a su alrededor y los llevaran al borde de perderlo todo.'),
(3, 'La llamada de Siete Lagos', '', 'https://edicionesfey.com/wp-content/uploads/2022/06/9789874787422.png', 'Seis extraños son llevados por misteriosas circunstancias hasta Siete Lagos, un pueblo perdido en los helados bosques de Rusia. Cada uno perseguirá su propia ambición, pero el antiguo asentamiento tiene sus propios planes y ellos deberán cooperar si esperan salir de allí con vida. Intérnate en el pozo de la mente y sigue la música del miedo hasta sus últimas consecuencias para descubrir el verdadero significado de las pesadillas.\r\n\r\n'),
(4, 'Eterna Clara', '', 'https://edicionesfey.com/wp-content/uploads/2022/06/9789874787484-768x1112.png', 'A Clara no le gusta su nombre, aunque la describe a la perfección: optimista, justa e inquebrantable.\r\n\r\nPero los tormentos del pasado y un amor, que solo existe en la complicidad del silencio, hacen que sus palabras se atoren y solo pueda contarlas a Rojizo, su diario y eterno confidente.\r\n\r\nCuando el incansable avance de la vida pone en jaque la rutina del secreto, Simón deberá abrir sus ojos y su corazón, para encontrar respuestas a su incertidumbre y darle vida a la única esperanza de salvar el amor. '),
(5, 'Príncipes de Arca', '', 'https://edicionesfey.com/wp-content/uploads/2022/06/9789874787477-768x1112.png', 'El príncipe Cam navegará hasta el misterioso reino de Enher, para hallar a su hermana perdida antes de la boda del heredero al trono.\r\nLa princesa Catara, prometida del futuro rey de Tides, intentará vivir una última aventura y huir de un matrimonio arreglado.\r\nLa cristalera Cariat se enfrentará a su fe, para desafiar al destino y proteger a sus hermanas.\r\n\r\nDescubre Arca, un mundo poblado por seres míticos, héroes legendarios y monstruos terribles. Donde los designios divinos se entrecruzan con los destinos de los mortales, bajo la luz de las tres lunas.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `CUIT` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `correo`, `contraseña`, `nombre`, `CUIT`) VALUES
(1, 'nathan.bouda@gmail.com', 'Nathan2024!', 'Nathan Bouda', '20304050607'),
(2, 'nicolas.manzur@gmail.com', 'Nicolas2024!', 'Nicolas Manzur', '20384950601'),
(3, 'julieta.carrizo@gmail.com', 'Julieta2024!', 'Julieta Carrizo', '27384950602'),
(4, 'karen.zarate@gmail.com', 'Karen2024!', 'Karen Zárate', '27384950603'),
(5, 'fernando.angeleri@gmail.com', 'Fernando2024!', 'Fernando Angeleri', '20384950604');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `id_tienda` int(11) DEFAULT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `id_tienda`, `fecha`) VALUES
(1, 1, '2024-04-16'),
(2, 1, '2024-04-19'),
(3, 2, '2024-04-19');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consignacion`
--
ALTER TABLE `consignacion`
  ADD PRIMARY KEY (`id_consignacion`),
  ADD KEY `consignacion_ibfk_1` (`id_tienda`);

--
-- Indices de la tabla `detalle_consignacion`
--
ALTER TABLE `detalle_consignacion`
  ADD PRIMARY KEY (`id_detalle_consignacion`),
  ADD KEY `id_consignacion` (`id_consignacion`),
  ADD KEY `id_titulo` (`id_titulo`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `id_titulo` (`id_titulo`);

--
-- Indices de la tabla `edicion`
--
ALTER TABLE `edicion`
  ADD PRIMARY KEY (`id_edicion`),
  ADD KEY `id_titulo` (`id_titulo`),
  ADD KEY `edicion_ibfk_2` (`id_formato`);

--
-- Indices de la tabla `edicion_formato`
--
ALTER TABLE `edicion_formato`
  ADD PRIMARY KEY (`id_formato`);

--
-- Indices de la tabla `historial_precio`
--
ALTER TABLE `historial_precio`
  ADD PRIMARY KEY (`id_historial`),
  ADD KEY `historial_precio_ibfk_1` (`id_titulo`);

--
-- Indices de la tabla `imprenta`
--
ALTER TABLE `imprenta`
  ADD PRIMARY KEY (`id_imprenta`);

--
-- Indices de la tabla `rendicion`
--
ALTER TABLE `rendicion`
  ADD PRIMARY KEY (`id_rendicion`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id_tarea`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_estado` (`id_estado`);

--
-- Indices de la tabla `tarea_estado`
--
ALTER TABLE `tarea_estado`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`id_tienda`);

--
-- Indices de la tabla `tirada`
--
ALTER TABLE `tirada`
  ADD PRIMARY KEY (`id_tirada`),
  ADD KEY `id_edicion` (`id_edicion`),
  ADD KEY `tirada_ibfk_2` (`id_imprenta`);

--
-- Indices de la tabla `titulo`
--
ALTER TABLE `titulo`
  ADD PRIMARY KEY (`id_titulo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `id_tienda` (`id_tienda`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consignacion`
--
ALTER TABLE `consignacion`
  MODIFY `id_consignacion` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_consignacion`
--
ALTER TABLE `detalle_consignacion`
  MODIFY `id_detalle_consignacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `edicion`
--
ALTER TABLE `edicion`
  MODIFY `id_edicion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `edicion_formato`
--
ALTER TABLE `edicion_formato`
  MODIFY `id_formato` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `historial_precio`
--
ALTER TABLE `historial_precio`
  MODIFY `id_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `imprenta`
--
ALTER TABLE `imprenta`
  MODIFY `id_imprenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rendicion`
--
ALTER TABLE `rendicion`
  MODIFY `id_rendicion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id_tarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `tarea_estado`
--
ALTER TABLE `tarea_estado`
  MODIFY `id_estado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tienda`
--
ALTER TABLE `tienda`
  MODIFY `id_tienda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tirada`
--
ALTER TABLE `tirada`
  MODIFY `id_tirada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `titulo`
--
ALTER TABLE `titulo`
  MODIFY `id_titulo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consignacion`
--
ALTER TABLE `consignacion`
  ADD CONSTRAINT `consignacion_ibfk_1` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id_tienda`);

--
-- Filtros para la tabla `detalle_consignacion`
--
ALTER TABLE `detalle_consignacion`
  ADD CONSTRAINT `detalle_consignacion_ibfk_1` FOREIGN KEY (`id_consignacion`) REFERENCES `consignacion` (`id_consignacion`),
  ADD CONSTRAINT `detalle_consignacion_ibfk_2` FOREIGN KEY (`id_titulo`) REFERENCES `titulo` (`id_titulo`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`),
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`id_titulo`) REFERENCES `titulo` (`id_titulo`);

--
-- Filtros para la tabla `edicion`
--
ALTER TABLE `edicion`
  ADD CONSTRAINT `edicion_ibfk_1` FOREIGN KEY (`id_titulo`) REFERENCES `titulo` (`id_titulo`),
  ADD CONSTRAINT `edicion_ibfk_2` FOREIGN KEY (`id_formato`) REFERENCES `edicion_formato` (`id_formato`);

--
-- Filtros para la tabla `historial_precio`
--
ALTER TABLE `historial_precio`
  ADD CONSTRAINT `historial_precio_ibfk_1` FOREIGN KEY (`id_titulo`) REFERENCES `titulo` (`id_titulo`);

--
-- Filtros para la tabla `rendicion`
--
ALTER TABLE `rendicion`
  ADD CONSTRAINT `rendicion_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `tarea_ibfk_2` FOREIGN KEY (`id_estado`) REFERENCES `tarea_estado` (`id_estado`);

--
-- Filtros para la tabla `tirada`
--
ALTER TABLE `tirada`
  ADD CONSTRAINT `tirada_ibfk_1` FOREIGN KEY (`id_edicion`) REFERENCES `edicion` (`id_edicion`),
  ADD CONSTRAINT `tirada_ibfk_2` FOREIGN KEY (`id_imprenta`) REFERENCES `imprenta` (`id_imprenta`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id_tienda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
