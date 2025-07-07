# 📚 Sistema de Gestión de Biblioteca en Java

Este proyecto implementa un sistema orientado a objetos para la gestión de libros en una biblioteca, utilizando principios SOLID, diseño limpio y buenas prácticas de arquitectura de software. Está diseñado con fines académicos y de aprendizaje, permitiendo probar filtros, excepciones personalizadas, repositorios, y validación de datos.

---

## Estructura del Proyecto

El sistema está compuesto por las siguientes partes principales:

### Modelo de Libros (`Book`)
- Clase abstracta `Book` que representa un libro genérico.
- Subclases:
    - `PrintedBook`: incluye tipo de tapa e indicador si es a color.
    - `EBook`: incluye tamaño de archivo y formato.

### Validación (`Validator`)
- Interfaz `Validator` implementada por `Book` para validar campos de texto y números.
- Método por defecto `validateString` y método `validateNumber`.

### Repositorio de Libros (`BookRepository`)
- Interfaz para gestionar almacenamiento y búsqueda de libros.
- Implementaciones:
    - `ArrayListBookRepository`: usa una lista dinámica.
    - `ArrayBookRepository`: usa un arreglo de tamaño fijo.

### Filtros (`BookFilter`)
- Interfaz con dos métodos para aplicar filtros tanto en listas como en arreglos.
- Implementaciones:
    - `AvailableBookFilter`: filtra libros disponibles.
    - `AuthorBookFilter`: filtra por autor específico.
    - `ColoredBookFilter`: filtra libros impresos a color.

### Generador de Reportes (`LibraryReportGenerator`)
- Clase que genera un reporte general o filtrado de libros.
- Utiliza un `BookFilter` para reportes personalizados.

### Gestor de Préstamos (`LoanManager`)
- Permite prestar y devolver libros por ISBN.
- Depende de la interfaz `BookRepository`.

### Excepciones Personalizadas
- `LibraryException`: excepción verificada lanzada cuando hay errores en operaciones de repositorio, préstamos o generación de reportes.

---

## Principios Aplicados (SOLID)

- **S**: Cada clase tiene una única responsabilidad.
- **O**: El sistema es extensible sin modificar código existente.
- **L**: Las subclases pueden usarse en lugar de sus clases base.
- **I**: Las interfaces son específicas y no imponen métodos innecesarios.
- **D**: Las dependencias están desacopladas gracias al uso de interfaces.

---

## Tecnologías

- Lenguaje: **Java**
- UML: **PlantUML** para modelado de clases
- Diseño orientado a objetos

---

## Autor

Proyecto desarrollado como ejercicio académico para reforzar conceptos de POO, colecciones, excepciones, y principios SOLID en Java.
