

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

 - **Game:** Esta clase define los parametros del juego. Esta compuesta por 2 atributos:
	- **Parameter**: que puede ser words o max_time
	- **Value**: que puede tener dos valores, 7 (words) o 300 (max_time)
 - **Letter:** Esta clase define la letra y su posición. Esta compuesta por los siguiente atributos:
	- **Id**: un identificador
	- **Letter:** una letra
	- **Position:** un array bidimensional para guardar la posición de la letra en filas y columnas.
- **Play:** Esta clase define la configuración de la partida. Contiene los siguientes atributos:
	- **WordsNumber**: Indica el numero de palabras que contendrá la partida.
	- **Seconds:** Indica los segundos que tendrá la partida.
	- **List words**: Array de palabras.
	- **Casillero**: Casillero es donde colocamos todas la palabras y letras para construir la sopa de letras.
- **Word**: Esta clase palabra esta compuesta por los siguiente atributos:
	- **id:** un identificador.
	- **word:** una palabra.
	- **description**: una pequeña descripción de la palabra que se mostrará si el usuario gana la partida.


## CAPA CONTROLLADOR
En esta capa encontramos 5 clases, las detallamos a continuación:

 - **GameController:** Servlet encargado de gestionar la configuración del juego.
 En esta clase renderizamos el casillero. Recibimos el listado de las palabras y creamos el casillero otorgándoles una posición.
 - **LoginController:** Servlet encargado de gestionar el logueo del usuario.
 - **PlayController:** Servlet encargado de construir el juego en base a los datos de configuración.
 - **Utilities:** Clase encargada de crear la conexión a la base de datos y al servidor LDAP.
 - **WordController:** Clase encargada de seleccionar palabras aleatorias para ubicarlas dentro del casillero de juego.

## CAPA VISTA
En esta capa vista encontramos todos los archivos .jsp acompañado de un fichero de estilos .css y otro de Javascript .js.

 - **styles.css**: archivo donde damos estilo a funciones como, por ejemplo, tachar la palabra del listado de palabras cuando se encuentra durante el juego, configurar el fondo de la pagina entre otros.
 - **functions.js**: en este archivo gestionamos los eventos que se pueden producir durante el juego como, por ejemplo, las funciones "youWin" o "finishGame" para gestionar la victoria o derrota del jugador, "initGame" la función para iniciar el juego o "checkLetters" que es una función que se encarga de comprobar las letras seleccionadas, entre otras funciones.
 - **templates**: dentro de esta carpeta encontramos 4 archivos .jsp que se encargan de mostrar visualmente la estructura de las dos paginas que usamos en este juego, la pagina de login y la pagina donde se muestra el juego. 
 - **index.jsp:** este archivo es el encargado de cargar la pagina inicial al arrancar juego. Este se construye mediante los archivos .jsp que se encuentran en la carpeta templates.
 - **play.jsp:** este archivo es el encargado de cargar la pagina del juego, una vez logueados. Este se construye mediante los archivos .jsp que se encuentran en la carpeta templates. 

## CAPA DAO
En esta capa realizamos la persistencia de datos usando JDBC y JPA. La estructuración de esta capa la hemos realizado de la siguiente manera:

 - **DAO:** Interfaz Generica con los metodos CRUD.
 - **GameDAO** y **WordDAO**: creadas para la utilización de la interfaz DAO.
 - **Jpa**: dentro de este paquete encontramos las clases encargadas de la implementación del DAO mediante la librería EclipseLink.
 - **Mysql**: dentro de este paquete encontramos las clases encargadas de la implementación del DAO mediante JDBC.

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
 - **EclipseLink:** Framework de Persistencia basado en Java Persistence Api (JPA).

# GUIA DE USUARIO
En el siguiente enlace podréis la guía de usuario de la aplicación Sopa de letras en formato video.
[Guia Usuario - Sopa de Letras](https://youtu.be/kzlLvN3CwcU)


# EJB

## Definición

Los EJB (Enterprise Java Beans) se definen como **interfaces de programación** de aplicaciones. Es el entorno de trabajo estándar que equivale al núcleo del ecosistema JEE y comparte carácter de **Framework** con Spring, Hibernate, etc... Todo servidor de aplicaciones debe poder desplegarlos.
Los EJB proporcionan un modelo de componentes distribuido estándar del lado del servidor, permitiendo al programador centrarse solamente en la parte de la lógica que necesita implementar para el propósito que persigue.
Los EJB aportan:

 - Transaccionalidad distribuida
 - Seguridad Persistencia manejada por el contendor EJB
 - Control de la concurrencia 
 - Eventos mediante JMS (Java Messaging Service)
 - Servicio de nombres y directorio
 - Escalabilidad
 
 Los EJBs o Beans son manejados de forma centralizada por un contenedor.
 
 Los nombres de las especificaciones EJB y JavaBeans y de sus componentes son muy similares, ahí es donde terminan las similitudes. La especificación y el modelo de componentes de JavaBeans y el modelo de componentes Enterprise JavaBeans tienen muy poco en común

## Tipos de EJB

Se denominan con el nombre de Beans. Tenemos los siguientes tipos:

 - **Beans de Sesión:** Representa un proceso o una acción de negocio con uno o más clientes. Mantienen el estado pero solo mientras el cliente interactúa con el bean. No son persistentes. Existe correspondiencia 1 a 1 entre el bean y el cliente. Es decir, diferentes clientes no pueden compartir el mismo bean de sesión. Existen:
    - Con estado
	- Sin estado
- **Beans de Entidad** Modelan conceptos o datos de negocios que pueden representarse con un sustantivo. Los beans de entidad describen tanto el estado como la conducta de objetos del mundo real y permiten a los desarrolladores encapsular las reglas de datos y de negocio asociadas con un concepto específico. Tienen
	- Persistencia
	- Acceso compartido
	- Clave primaria
	- Relaciones
- **Beans dirigidos por mensajes** permiten que las aplicaciones J2EE reciban mensajes JMS de forma asíncrona. Así, el hilo de ejecución de un cliente no se bloquea cuando está esperando que se complete algún método de negocio de otro enterprise bean. Los mensajes pueden enviarse desde cualquier componente J2EE (una aplicación cliente, otro enterprise bean, o un componente Web) o por una aplicación o sistema JMS que no use la tecnología J2EE.

## Servicios del contenedor EJB

- Transacciones
- Seguridad
- Persistencia

## Transacciones

Una transacción de un sistema de negocios (transacción para abreviar) es la ejecución de una
unidad-de-trabajo que accede uno o más recursos compartidos, normalmente bases de datos.
Una unidad-de-trabajo es un conjunto de actividades que se relacionan mutuamente y que
deben ser realizadas completamente.

Transacción quiere decir, un intercambio entre dos partes. Es importante verificar que el proceso se ha llevado a cabo según lo esperado.

## Seguridad

La seguridad es un aspecto fundamental de las aplicaciones empresariales. Cualquier aplicación interna o accesible via web va a intentar ser hackeada por extraños. Podemos analizar tres elementos fundamentales en la seguridad de una aplicación:

- Autentificación

Dicho sencillamente, la autentificación valida la identidad del usuario. La forma más común de autentificación es una simple ventana de login que pide un nombre de usuario y una contraseña. Una vez que los usuarios han pasado a través del sistema de autentificación, pueden usar el sistema libremente, hasta el nivel que les permita el control de acceso. La autentificación se puede basar también en tarjetas de identificación, certificados y en otros tipos de identificación.

- Control de acceso

El control de acceso (también conocido como autorización) aplica políticas de seguridad que regulan lo que un usuario específico puede y no puede hacer en el sistema. El control de acceso asegura que los usuarios accedan sólo a aquellos recursos y operaciones a los que se les ha dado permiso. El control de acceso puede restringir el acceso de un usuario a subistemas, datos, y objetos de negocio. Por ejemplo, a algunos usuarios se les puede dar permiso de modificar información, mientras que otros sólo tienen permiso de visualizarla.

- Comunicación segura

Los canales de comunicación entre un cliente y un servidor son un elemento muy importante en la seguridad del sistema. Un canal de comunicación puede hacerse seguro mediante aislamiento físico (por ejemplo, via una conexión de red dedicada) o por medio de la encriptación de la comunicación entre el cliente y el servidor. El aislamiento físico es caro, limita las posibilidades del sistema y es casi imposible en Internet, por lo que lo más usual es la encriptación. Cuando la comunicación se asegura mediante la encriptación, los mensajes se codifican de forma que no puedean ser leídos ni manipulados por individuos no autorizados. Esto se suele consigue mediante el intercambio de claves criptográficas entre el cliente y el servidor. Las claves permiten al receptor del mensaje decodificarlo y leerlo.

La mayoría de los servidores EJB soportan la comunicación segura a través del protocolo SSL (Secure Socket Layer) y proporcionan algún mecanismo de autentificación, pero la especificación Enterprise JavaBeans sólo especifica el control de acceso a los enterprise beans.

## Persistencia

El mapeo objeto-relacional implícito en los beans de entidad requiere que un bean de entidad sea responsable de insertar, actualizar, seleccionar y eliminar datos dentro de la fuente de datos. Este proceso del manejo de la comunicación entre el componente y la fuente de datos se llama persistencia. En otras palabras, persistencia es el proceso de escribir la información en una fuente de datos externa. Hay dos tipos de persistencia para los beans de entidad:

- Persistencia Manejada por el Bean (BMP)
Con la persistencia manejada por el bean (BMP), el programador es el responsable de escribir dentro del bean todo el código para acceder a la fuente de datos. Este tipo de persistenca le da más flexibilidad al programador porque controla todos los accesos a la fuente de datos.
- Persistencia Manejada por el Contenedor (CMP)
Con la persistencia manejada por el contenedor EJB es el propio contenedor EJB el que maneja todos los accesos a la base de datos requeridos por el bean de entidad. Como resultado, el código de acceso a los datos del bean, no está acoplado programáticamente a una fuente de datos específica. Esto libera al programador de tener que escribir código de acceso a los datos y permite que el bean de entidad se pueda desplegar en diferentes contenedores y/o contra diferentes fuentes de datos.


Cuando queremos crear la **lógica** de nuestra aplicación para una clase en concreto usaremos los EJB (Enterprise Java Bean)

> La **lógica** del programa es  toda aquella parte que se encarga de la parte central del sistema, de lo que el sistema verdaderamente tiene que hacer como funcionamiento para proveer funcionalidades a las necesidades del cliente, como operaciones que se encargan de trabajar con los datos en la BBDD (Crud) y validaciones como  evitar  que se carguen valores nulos en un campo, que se repitan datos con los mismo valores, etc...
JAVA EE nos provee un apartado donde nosotros podemos centralizar y unificar todo lo que corresponde a la lógica de la aplicación y ese apartado lo denominamos Session Bean.

## ESTRUCTURA DE NUESTRO SERVIDOR DE APLICACIONES USANDO EJB.
Dentro de nuestro contenedor del servidor de aplicaciones tenemos el contenedor EJB, donde tenemos una parte o los componentes que se ocupan de la lógica de negocio, llamados Beans de Sesión o los Beans gestionados por mensajes.

En una capa inferior tenemos el nivel de persistencia donde tenemos las clases de entidad o **beans de entidad** donde tenemos que definir nuestra clase que representa a la tabla en la BBDD vinculando cada uno de nuestros campos con los atributos de la entidad que tenemos en nuestra aplicación, es decir crear ese mapeo objeto-relacional de las clases junto con la BBDD.
Tenemos otras librerías que serán utilizadas como los **ORM correlacionadores de datos** y clases **DAO**.

[Ver imagen.](https://ibb.co/pffXkd8)

## ENLACES INTERESANTES SOBRE EJB

 - [SPRING VS EJB](https://www.youtube.com/watch?v=jQxJ10PLHfo)
 - [Videotutorial No. 1 Curso de EJB 3 - Introducción](https://www.youtube.com/watch?v=B-svHYbqZYE)
 - [Introducción a la tecnología EJB](http://www.jtech.ua.es/j2ee/2003-2004/abierto-j2ee-2003-2004/ejb/sesion01-apuntes.htm)
 - [EJB 3.0: Resurrection](https://www.adictosaltrabajo.com/2007/05/07/ejb-3-resurrection/)

# AUTORES

 - Esteban Bresba - ebresba@uoc.edu
 - Jorge Arrojo - arrojorge@uoc.edu
 - Jordi Molet - jmoletr@uoc.edu
