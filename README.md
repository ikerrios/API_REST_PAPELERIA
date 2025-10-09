# API_REST_PAPELERIA
Este proyecto tiene como objetivo desarrollar una API REST para gestionar artículos de un almacén de papelería, enfocada en la venta B2B. La solución se basa en una única tabla de PostgreSQL para el modelo de datos, y se utilizarán las herramientas de Atlassian para la gestión integral del proyecto.

1) ¿Qué es y qué hace?
API REST hecha con Spring Boot + Spring Data JPA sobre PostgreSQL (Neon u otra).
Expone artículos de papelería con 2 funcionalidades principales:

Listado completo de artículos (id, name, price, stock, category).

Consulta básica por id (id, name, stock) con control de stock: si stock = 0, devuelve mensaje: "Agotado".

Formato de datos: JSON. Puerto por defecto: 8080.

2) Endpoints
2.1 GET /api/articulos
Devuelve todos los artículos.

Ejemplo de respuesta (200):



[
  { "id": 1, "name": "Cuaderno A4 80 hojas", "price": 3.5, "stock": 120, "category": "Papelería" },
  { "id": 2, "name": "Bolígrafo azul BIC", "price": 0.8, "stock": 300, "category": "Escritura" }
]
cURL:



curl -s http://localhost:8080/api/articulos
2.2 GET /api/articulos/{id}/basico
Devuelve solo id, name, stock del artículo. Si el stock es 0, añade mensaje: "Agotado".

Ejemplo de respuesta OK (200):



{ "id": 1, "name": "Cuaderno A4 80 hojas", "stock": 120 }
Ejemplo con agotado (200):



{ "id": 8, "name": "Archivador de anillas", "stock": 0, "mensaje": "Agotado" }
Si no existe (404): sin cuerpo o {} según cliente.

cURL:



curl -s http://localhost:8080/api/articulos/1/basico
Nota: opcionalmente existe variante GET /api/articulos/basico?id=1 si preferís query param.

3) Ejecutar en local (paso a paso)
3.1 Requisitos
Java 21

Maven 3.9+

PostgreSQL (local o Neon).

(Opcional) PHP si usas el pequeño frontend que lista artículos.

3.2 BBDD (PostgreSQL)
Crea una base de datos (ej. papeleria) y la tabla articulo:



CREATE TABLE articulo (
  id       SERIAL PRIMARY KEY,
  name     VARCHAR(100),
  price    DOUBLE PRECISION,
  stock    INTEGER,
  category VARCHAR(100)
);
Inserta algunos datos:



INSERT INTO articulo (name, price, stock, category) VALUES
('Cuaderno A4 80 hojas', 3.5, 120, 'Papelería'),
('Bolígrafo azul BIC', 0.8, 300, 'Escritura');
3.3 Configuración Spring (src/main/resources/application.properties)
Rellena con tus credenciales reales. Ejemplo para Neon:



spring.application.name=Papeleria
spring.datasource.url=jdbc:postgresql://ep-XXXX-pooler.c-2.us-east-1.aws.neon.tech/papeleria?sslmode=require
spring.datasource.username=neondb_owner
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
# Dialecto se elige solo; no es necesario fijarlo en Spring Boot 3.
Si tu DB se llama distinto, cámbiala en la URL. Asegúrate de que el compute de Neon esté ACTIVE, no IDLE.

3.4 Arranque de la API
En la raíz del proyecto:



mvn spring-boot:run
Verás en consola que arranca Tomcat en :8080.
Prueba: http://localhost:8080/api/articulos.

4) Estructura mínima del proyecto


src/
 └─ main/
    ├─ java/com/hellin/demo/
    │  ├─ entity/Articulo.java
    │  ├─ repository/ArticuloRepository.java   (extends JpaRepository<Articulo, Integer>)
    │  ├─ controller/ArticuloController.java   (@RequestMapping("/api/articulos"))
    │  └─ PapeleriaApplication.java            (@SpringBootApplication)
    └─ resources/application.properties
5) Problemas típicos y soluciones rápidas
404 en /: normal, no hay endpoint raíz. Usa /api/articulos.

400 en /api/articulos/{id}/basico: el id debe ser numérico y no vacío.

Error “database … does not exist”: revisa spring.datasource.url (nombre de DB) y que el compute de Neon esté activo.

Acceso denegado: credenciales (username/password) incorrectas.

Con esto debería quedarte la API fina y lista para entregar. Si quieres, te doy un index.php de ejemplo apuntando a /api/articulos para el listado.