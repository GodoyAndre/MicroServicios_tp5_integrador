# 📄 Ejercicio Integrador TP2

## 🗂 Descripción
Este proyecto implementa un sistema de gestión con PostgreSQL como base de datos y RabbitMQ para la comunicación entre servicios. El sistema gestiona información detallada sobre estudiantes y carreras.

---

## 📁 Estructura del Proyecto
El proyecto está organizado en los siguientes componentes principales:

- **Microservicio de Estudiantes**
- **Microservicio de Carreras**
- **Base de datos PostgreSQL** para Estudiantes
- **Base de datos PostgreSQL** para Carreras
- **RabbitMQ** para la comunicación entre servicios
- **pgAdmin** para la gestión de bases de datos

---

## 📋 Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas:

- 🐳 Docker (versión 20.10.0 o superior)
- 🐳 Docker Compose (versión 1.29.0 o superior)
- 💾 Al menos 4GB de RAM disponible
- 💽 10GB de espacio en disco

---

## 🛠 Configuración con Docker

Utilizamos `docker-compose` para desplegar todos los servicios necesarios para el proyecto.

### 🚀 Instrucciones de Uso

1. Ejecuta el siguiente comando para iniciar todos los servicios:

    ```bash
    docker-compose up -d
    ```

    Este comando iniciará los siguientes contenedores:

    - PostgreSQL para Estudiantes en el puerto `5432`
    - PostgreSQL para Carreras en el puerto `5433`
    - pgAdmin en el puerto `80`
    - RabbitMQ en los puertos `5672` (AMQP) y `15672` (Management Interface)

2. Accede a pgAdmin desde tu navegador en `http://localhost`:

    - **Email:** `admin@admin.com`
    - **Contraseña:** `admin`

3. Agregar las bases de datos en pgAdmin:

    - Agrega dos nuevos servidores con las siguientes configuraciones:

        - **Para Estudiantes:**
            - Nombre del servidor: Estudiantes
            - Host: postgres_estudiantes
            - Puerto: 5432
            - Base de datos de mantenimiento: estudiantes_db
            - Usuario: root
            - Contraseña: root

        - **Para Carreras:**
            - Nombre del servidor: Carreras
            - Host: postgres_carreras
            - Puerto: 5432
            - Base de datos de mantenimiento: carreras_db
            - Usuario: root
            - Contraseña: root

4. Dentro de pgAdmin, selecciona cada base de datos y navega a la pestaña `Query Tool` para ejecutar los scripts de datos de prueba.

5. Carga y ejecuta los scripts ubicados en `script/` para llenar las bases de datos con datos de prueba.

6. Verifica que los datos hayan sido cargados correctamente navegando por las tablas en pgAdmin.

7. Para acceder a la interfaz de administración de RabbitMQ, visita `http://localhost:15672` en tu navegador:

    - **Usuario:** guest
    - **Contraseña:** guest

---

## 🔧 Variables de Entorno

Las variables de entorno necesarias están configuradas en el archivo `docker-compose.yml`. Si necesitas modificarlas, edita este archivo antes de iniciar los contenedores.

---

## 🧪 Pruebas

Para ejecutar las pruebas del proyecto, sigue estos pasos:

1. Asegúrate de que todos los contenedores estén en ejecución.
2. Ejecuta el siguiente comando en la raíz del proyecto:

    ```bash
    ./run-tests.sh
    ```

---

## 🔍 Solución de Problemas

Si encuentras algún problema, aquí hay algunas soluciones comunes:

- Si los contenedores no se inician, verifica que los puertos no estén en uso por otras aplicaciones.
- Si no puedes conectarte a las bases de datos, asegúrate de que los servicios de PostgreSQL estén en ejecución y saludables.

---

## 🤝 Contribuir

Si deseas contribuir al proyecto, por favor:

1. Haz un fork del repositorio
2. Crea una nueva rama para tu feature
3. Realiza tus cambios y haz commit
4. Envía un pull request

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

## 📧 Contacto

Si tienes alguna pregunta o sugerencia, no dudes en contactarnos:

- **Enzo Heredia:** [herediaenzo414@gmail.com](mailto:herediaenzo414@gmail.com)
- **Stephanie Godoy:** [sgodoy@alumnos.exa.unicen.edu.ar](mailto:sgodoy@alumnos.exa.unicen.edu.ar)
- **Pablo Hernandez:** [pablohrnz9365@gmail.com](mailto:pablohrnz9365@gmail.com)

---

## 🙏 Agradecimientos

Agradecemos a todos los contribuyentes y a las siguientes tecnologías que hacen posible este proyecto:

- PostgreSQL
- RabbitMQ
- Docker
- Spring Boot (si se utiliza)
"""
