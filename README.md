# 🎾 DuxTennis v0.1

[![build](https://github.com/akmsw/duxtennis/actions/workflows/maven.yml/badge.svg?branch=develop)](https://github.com/akmsw/duxtennis/actions/workflows/maven.yml)
[![issuesBadge](https://img.shields.io/github/issues/akmsw/duxtennis.svg?logo=github)](https://github.com/akmsw/duxtennis/issues)
[![checkStyleBadge](https://img.shields.io/badge/checkstyle10.3.3-passing-brightgreen)](https://checkstyle.sourceforge.io/)
[![sonarLintBadge](https://img.shields.io/badge/sonarlint-passing-brightgreen?logo=sonarlint)](https://www.sonarlint.org/)

[![openJDKTarget](https://img.shields.io/badge/jdk-11%2B-red?logo=openjdk)](https://openjdk.org/projects/jdk/11/)
[![apacheMavenBadge](https://img.shields.io/badge/apache-maven-orange?logo=apachemaven)](https://maven.apache.org/)
[![operatingSystemBadge](https://img.shields.io/badge/os-cross--platform-blueviolet?logo=windows-terminal)](https://en.wikipedia.org/wiki/Cross-platform_software)

## 📜 Índice
- [¿Qué es?](https://github.com/akmsw/duxtennis#-qu%C3%A9-es)
- [Requisitos generales](https://github.com/akmsw/duxtennis#-requisitos-generales)
  - [Java](https://github.com/akmsw/duxtennis#-java)
    - [Versión mínima](https://github.com/akmsw/duxtennis#versi%C3%B3n-m%C3%ADnima)
    - [Versión recomendada](https://github.com/akmsw/duxtennis#versi%C3%B3n-recomendada)
- [Requisitos para compilación](https://github.com/akmsw/duxtennis#%EF%B8%8F-requisitos-para-compilaci%C3%B3n)
  - [Apache Maven](https://github.com/akmsw/duxtennis#-apache-maven)
    - [Versión recomendada](https://github.com/akmsw/duxtennis#versi%C3%B3n-recomendada-1)
- [Descarga](https://github.com/akmsw/duxtennis#-descarga)
- [Instalación y ejecución](https://github.com/akmsw/duxtennis#%EF%B8%8F-instalaci%C3%B3n-y-ejecuci%C3%B3n)
- [Compilación manual](https://github.com/akmsw/duxtennis#%EF%B8%8F-compilaci%C3%B3n-manual)
- [¿Cómo se usa?](https://github.com/akmsw/duxtennis#-c%C3%B3mo-se-usa)
- [Reglas del juego](https://github.com/akmsw/duxtennis#-reglas-del-juego)
- [Comentarios](https://github.com/akmsw/duxtennis#-comentarios)
- [Reportes y sugerencias](https://github.com/akmsw/duxtennis#%EF%B8%8F-reportes-y-sugerencias)
- [Capturas de pantalla](https://github.com/akmsw/duxtennis#-capturas-de-pantalla)

## 🔎 ¿Qué es?
Desarrollado completamente en Java, este programa representa la segunda parte de la prueba técnica del proceso de selección en DuxSoftware.\
Se trata de un simulador de partidos de tenis de 2 jugadores.

## 📦 Requisitos generales
### ☕ Java
- #### Versión mínima
    🟡 [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)
- #### Versión recomendada
    🟢 [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) *(o más reciente)*

## ⚙️ Requisitos para compilación
### 🪶 Apache Maven
- #### Versión recomendada
    🟢 [Apache Maven 3.8.6](https://maven.apache.org/download.cgi)

## 📥 Descarga
La versión estable más reciente del programa se encuentra disponible para descargar en la sección [releases](https://github.com/akmsw/duxtennis/releases) de este proyecto.

## ▶️ Instalación y ejecución
Más allá de los requisitos listados, no hace falta ninguna instalación para correr este programa.\
Una vez descargado el archivo con extensión ***.jar***, e independientemente del sistema operativo que se utilice, se lo puede ejecutar con un simple *doble click*.
Una alternativa es abrir una terminal dentro de la carpeta contenedora del archivo y ejecutar el comando:
```bash
java -jar duxtennis-0.1.jar
```

## 🛠️ Compilación manual
Para compilar manualmente el programa, asumiendo que tanto los [requisitos generales](https://github.com/akmsw/duxtennis#-requisitos-generales) como los [requisitos para compilación](https://github.com/akmsw/duxtennis#%EF%B8%8F-requisitos-para-compilaci%C3%B3n) han sido instalados correctamente, se debe dirigir a la carpeta contenedora del proyecto y ejecutar Apache Maven haciendo uso del archivo `pom.xml` con el siguiente comando:
```bash
mvn package --file pom.xml
```
o, simplemente:
```bash
mvn package
```

Esto creará una carpeta llamada `target`. Dentro de esa carpeta estará el archivo ejecutable en formato `.jar`. Para ejecutarlo, dentro de la carpeta contenedora, se debe ejecutar el comando indicado anteriormente:
```bash
java -jar duxtennis-0.1.jar
```

## 📝 ¿Cómo se usa?
Para comenzar un partido, se debe ingresar el nombre del torneo y de los dos jugadores que participan en el mismo. Luego, se puede calibrar la probabilidad que tiene cada jugador de ganar el partido (recordar que las probabilidades van de 0% a 100% y son complementarias). Finalmente, se puede elegir si jugar un partido a 3 sets o a 5 sets.

Cuando estos parámetros hayan sido establecidos, se podrá hacer click en el botón 'Continuar' para comenzar la simulación.

En ese momento se abrirá una ventana que mostrará el progreso de la simulación del partido, indicando quién saca en cada set, y cuántos puntos, games y sets ganados tiene cada jugador en el transcurso del mismo. Durante esta simulación, el usuario sólo puede observar el progreso de la simulación.

Cuando la simulación finalice, el usuario tendrá frente a sí una nueva ventana que mostrará el resumen del partido, indicando el resultado de cada set y el ganador del partido del torneo. En este punto, el usuario puede optar por jugar una revancha (iniciar un partido con los mismos jugadores y los mismos parámetros que los ingresados en un principio), o volver al menú principal para comenzar otra simulación distinta.

## 📖 Reglas del juego
Como simple recordatorio, se detallan a continuación las reglas básicas de un partido de tenis tenidas en cuenta para el desarrollo de este programa.

- El jugador que efectúa el saque cambiará cada set.
- El primer saque del juego (primer set) será asignado a un jugador de manera aleatoria.
- El resto de saques será intercalado (el jugador que sacó en el set anterior, recibirá en el set actual).
- Cada partido se puede jugar a 3 ó 5 sets.
- Cada set está compuesto por 6 games en principio.
- Para ganar un game, un jugador debe pasar los 40 puntos con diferencia de 2.
- Los puntos son de la forma: 0-15-30-40-game
- Si los jugadores empatan 40-40 en los puntos, el game se disputa por diferencia de 2.
- Si los jugadores empatan 5-5 en games, el set se jugará a 7; y para ganar el set, uno de los dos deberá ganar 7-5 (diferencia de 2).
- Si los jugadores empatan 6-6 en games, se entra a un 'tie break', donde jugarán mínimo hasta 7 puntos (comenzando desde 0), y ganará el set el jugador que gane el tie break a 7 con diferencia de 2.
- Si los jugadores empatan 6-6 en el tie break, se desempatará el tie break con diferencia de 2.
- Si el partido es a 3 sets y un jugador gana 2 sets seguidos, el tercer set no se jugará.
- Si el partido es a 5 sets y un jugador gana 3 sets seguidos, el cuarto set no se jugará.
- Si el partido es a 5 sets y un jugador gana 3 sets y el otro sólo 1, el quinto set no se jugará.

## 💬 Comentarios
- En la ventana de ingreso de parámetros, el botón 'Continuar' está deshabilitado al comienzo. Para habilitarlo, es necesario ingresar todos los nombres pedidos (escribir en el campo de texto y presionar la tecla 'Enter').
- Los nombres de los jugadores y del torneo deben estar escritos sólo con letras de la A la Z (incluyendo la Ñ), en mayúscula o minúscula, con o sin acentos, con o sin espacios, sin más de 10 caracteres en total.

## ⚠️ Reportes y sugerencias
Si el programa presenta algún error que debería ser reportado para arreglarlo, si podría haber alguna nueva funcionalidad para agregar al programa, o si algo podría ser modificado, la sección de [issues](https://github.com/akmsw/duxtennis/issues) está abierta para hacer estos reportes y/o sugerencias. Es necesario tener una cuenta en GitHub para abrir un nuevo reporte en el repositorio.

## 📸 Capturas de pantalla
![mainMenu](./src/main/res/img/readme/ss1.png)\
*Ventana del menú principal*

![dataInput](./src/main/res/img/readme/ss2.png)\
*Ventana de ingreso de parámetros*

![simulation1](./src/main/res/img/readme/ss3.png)\
*Ventana de progreso de simulación de partido sin deuce ni empates*

![simulation2](./src/main/res/img/readme/ss4.png)\
*Ventana de progreso de simulación de partido con deuce*

![simulation3](./src/main/res/img/readme/ss5.png)\
*Ventana de progreso de simulación de partido con empate*

![result1](./src/main/res/img/readme/ss6.png)\
*Ventana de resultado de partido sin empates*

![result2](./src/main/res/img/readme/ss7.png)\
*Ventana de resultado de partido con empates*
