# J2E

Bienvenidos a nuestro proyecto! Este proyecto esta basado en un juego estilo Sopa de letras donde el jugador tendrá un tiempo establecido para encontrar todas las letras definidas en una lista. Ganará el jugador que encuentre todas las palabras, previamente listadas, dentro del tiempo marcado. El premio del ganador será poder ver las definiciones de cada una de las palabras encontradas.

# PRE-REQUISITOS

A continuación detallamos las instrucciones que te permitirán obtener un correcto funcionamiento en tu máquina local para ejecutar esta aplicación.

## SOFTWARE

Debes tener instalado un paquete como XAMPP o MAMP.  Recordemos que estos paquetes son un conjunto de programas software comúnmente usados para desarrollar sitios web dinámicos sobre sistemas operativos.
Principalmente están compuestos por:

 - Apache: Servidor web.
 - MySQL/MariaDB: Gestión de base de datos.
 - PHP: Lenguaje de programación de lado del servidor.
 - Perl: Lenguaje de programación usado para el desarrollo web y administración del sistema.
 
## Instalación MAMP (macOS)
 - Lo primero que debemos hacer es descargarnos la  [versión de MAMP para macOS](https://www.mamp.info/en/downloads/).
 - Seguidamente, iniciamos el instalador de MAMP y esperamos a que la instalación finalice.

Ahora ya podremos iniciar MAMP desde el lanzador de aplicaciones.

## Instalación XAMPP (windows)

 - Lo primero que debemos hacer es descargarnos la  [versión de XAMPP para windows](https://www.apachefriends.org/es/index.html)
 - Haremos doble clic en el archivo descargado para comenzar a instalar XAMPP.
 - Aparecerá una ventana de bienvenida donde todo lo que necesitamos hacer es hacer clic en el botón Next.
 - En la siguiente pantalla, podemos seleccionar los componentes XAMPP que deseamos instalar.
 - Elegiremos la carpeta donde se instalará XAMPP y todos los componentes que seleccionamos anteriormente.
 - La instalación estará lista para comenzar, por lo que solo necesitamos hacer clic en Next.
 
Finalmente, veremos una ventana que nos informa que la instalación se completó con éxito.
 
## EDITOR JAVA
También debes tener un editor donde poder realizar la ejecución de esta aplicación y editar si lo necesitas el código.
En nuestro caso hemos usado IntelliJ pero existen muchos IDE's gratuitos como por ejemplo [Eclipse](https://www.eclipse.org/pdt/) o [Netbeans](https://netbeans.apache.org//).


## Instalación IntelliJ

 - Lo primero que debemos hacer es descargarnos intelliJ desde la [página oficial de JetBrains](https://www.jetbrains.com/es-es/) 
 - Rellenaremos el formulario con los datos requeridos.
 - Nos crearemos una cuenta en la pagina de JetBrains
 - Una vez logueados, en el apartado "Download" de nuestro perfil, podremos descargar el IDE.
 
Una vez finalizados los pasos de la instalación tendremos el IDE listo para su uso.

# DETALLE DE LA IMPLANTACIÓN
En este apartado explicaremos los detalles más relevantes de nuestra código.

## ESTRUCTURA DEL PROYECTO
Hemos estructurado el proyecto de la siguiente manera:

 - **Capa Controller:** Recibe las peticiones del usuario, desencadena las acciones adecuadas en el modelo y muestra la vista correspondiente. Estos controladores se implementarán mediante servlets. En esta capa también creamos la conexión a nuestra Base de Datos.
 - **Capa DAO:** En esta capa realizamos la persistencia de datos usando JDBC y JPA.
 - **Capa Model:** En esta capa tenemos los datos que maneja el sistema, su lógica de negocio y sus mecanismos de persistencia.
 - **Capa Vista:** Capa donde gestionamos la interfaz de usuario, donde mostramos  los datos del modelo. Para implementar las vistas, hemos usado JSPs.

## CAPA MODELO
En esta capa encontramos 4 clases, las detallamos a continuación:

 - **Game:** Esta clase juego esta compuesta por 2 atributos:
	- **Parameter**: que puede ser words o max_time
	- **Value**: que puede tener dos valores, 7 (words) o 300 (max_time)
 - **Letter:** Esta clase letter esta compuesta por los siguiente atributos:
	 - **Id**: un identificador
	 - **Letter:** una letra
	 - **Position:** un array bidimensional para guardar la posición de la letra.
 - **Play:**
 - **Word:**

## CAPA CONTROLLADOR
En esta capa encontramos 5 clases, las detallamos a continuación:

 - **GameController:** Servlet encargado de gestionar la configuración del juego.
 - **LoginController:** Servlet encargado de gestionar el logueo del usuario.
 - **PlayController:** Servlet encargado de construir el juego en base a los datos de configuración.
 - **Utilities:** Clase encargada de crear la conexión a la base de datos.
 - **WordController:** Clase encargada de generar palabras aleatorias para ubicarlas dentro del casillero de juego.

## CAPA VISTA





# TECNOLOGIAS USADAS CON
Las herramientas y tecnologías usadas mas importantes para este proyecto han sido:

 - **Apache Directory Studio:** Autenticación LDAP en el Active Directory.
 - **Entorno Java EE (Jakarta EE):** Plataforma para desarrollar aplicaciones empresariales distribuidas, con arquitecturas multicapa, escritas en Java y que se ejecutan en un servidor de aplicaciones.
 - **Tomcat:** Tomcat es un contenedor web con soporte de servlets y JSPs
 - **Maven:**  Manejador de dependencias.
 - **DAO y JDBC:** Patrón de diseño DAO y gestión de base de datos mediante JDBC.
 - **Servlets:** Programas que se ejecutan en un servidor web.
 - **JSP:** Tecnología que nos permite mezclar HMTL estático con HTML generado dinámicamente.
 - **JQuery:** Librería de Javascript que nos permite agregar interactividad a nuestro sitio web.
 - **Ajax:** Tecnología usada para procesar solicitudes al servidor en segundo plano.
 - **MySQL y phpMyAdmin:** Sistema de gestión de base de datos .
 - **JPA:** API de persistencia estándar para mapear objetos Java a una base de datos relacional.
 - **Hibernate:** Framework para la implementación del estándar JPA mediante el Mapeo objeto-relacional (ORM).

# AUTORES

 - Esteban Bresba - ebresba@uoc.edu
 - Jorge Arrojo - arrojorge@uoc.edu
 - Jordi Molet - jmoletr@uoc.edu
