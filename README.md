# Proyecto de Base de Datos para Sistema de Gestión Editorial

Este repositorio contiene el script SQL para crear y poblar la base de datos del sistema de Gestión de Editoriales. La base de datos está diseñada para manejar consignaciones, ventas, ediciones de libros, y más. A continuación, se detallan las tablas y sus relaciones, así como las instrucciones para importar el script en tu servidor MySQL.

## Estructura de la Base de Datos

La base de datos incluye las siguientes tablas:

1. **consignacion**: Maneja las consignaciones de libros.
2. **detalle_consignacion**: Detalles de cada consignación.
3. **detalle_venta**: Detalles de cada venta.
4. **edicion**: Ediciones de libros.
5. **edicion_formato**: Formatos de ediciones (e.g., Tapa blanda, Tapa dura, E-book).
6. **historial_precio**: Historial de precios de los títulos.
7. **imprenta**: Información sobre las imprentas.
8. **rendicion**: Registro de rendiciones de pago.
9. **tarea**: Tareas relacionadas con la gestión de la librería.
10. **tarea_estado**: Estados de las tareas (e.g., Por hacer, En proceso, Listo).
11. **tienda**: Información sobre las tiendas.
12. **tirada**: Registros de tiradas de impresión.
13. **titulo**: Información sobre los títulos de libros.
14. **usuario**: Información de los usuarios.
15. **venta**: Registro de ventas.

## Requisitos

- MySQL o MariaDB
- phpMyAdmin (opcional, pero recomendado para una gestión más sencilla)
