# 馃幘 DuxTennis v0.1

[![build](https://github.com/akmsw/duxtennis/actions/workflows/maven.yml/badge.svg?branch=develop)](https://github.com/akmsw/duxtennis/actions/workflows/maven.yml)
[![issuesBadge](https://img.shields.io/github/issues/akmsw/duxtennis.svg?logo=github)](https://github.com/akmsw/duxtennis/issues)
[![checkStyleBadge](https://img.shields.io/badge/checkstyle10.3.3-passing-brightgreen)](https://checkstyle.sourceforge.io/)
[![sonarLintBadge](https://img.shields.io/badge/sonarlint-passing-brightgreen?logo=sonarlint)](https://www.sonarlint.org/)

[![openJDKTarget](https://img.shields.io/badge/jdk-11%2B-red?logo=openjdk)](https://openjdk.org/projects/jdk/11/)
[![apacheMavenBadge](https://img.shields.io/badge/apache-maven-orange?logo=apachemaven)](https://maven.apache.org/)
[![operatingSystemBadge](https://img.shields.io/badge/os-cross--platform-blueviolet?logo=windows-terminal)](https://en.wikipedia.org/wiki/Cross-platform_software)

## 馃摐 脥ndice
- [驴Qu茅 es?](https://github.com/akmsw/duxtennis#-qu%C3%A9-es)
- [Requisitos generales](https://github.com/akmsw/duxtennis#-requisitos-generales)
  - [Java](https://github.com/akmsw/duxtennis#-java)
    - [Versi贸n m铆nima](https://github.com/akmsw/duxtennis#versi%C3%B3n-m%C3%ADnima)
    - [Versi贸n recomendada](https://github.com/akmsw/duxtennis#versi%C3%B3n-recomendada)
- [Requisitos para compilaci贸n](https://github.com/akmsw/duxtennis#%EF%B8%8F-requisitos-para-compilaci%C3%B3n)
  - [Apache Maven](https://github.com/akmsw/duxtennis#-apache-maven)
    - [Versi贸n recomendada](https://github.com/akmsw/duxtennis#versi%C3%B3n-recomendada-1)
- [Descarga](https://github.com/akmsw/duxtennis#-descarga)
- [Instalaci贸n y ejecuci贸n](https://github.com/akmsw/duxtennis#%EF%B8%8F-instalaci%C3%B3n-y-ejecuci%C3%B3n)
- [Compilaci贸n manual](https://github.com/akmsw/duxtennis#%EF%B8%8F-compilaci%C3%B3n-manual)
- [驴C贸mo se usa?](https://github.com/akmsw/duxtennis#-c%C3%B3mo-se-usa)
- [Reglas del juego](https://github.com/akmsw/duxtennis#-reglas-del-juego)
- [Comentarios](https://github.com/akmsw/duxtennis#-comentarios)
- [Reportes y sugerencias](https://github.com/akmsw/duxtennis#%EF%B8%8F-reportes-y-sugerencias)
- [Capturas de pantalla](https://github.com/akmsw/duxtennis#-capturas-de-pantalla)

## 馃攷 驴Qu茅 es?
Desarrollado completamente en Java, este programa representa la segunda parte de la prueba t茅cnica del proceso de selecci贸n en DuxSoftware.\
Se trata de un simulador de partidos de tenis de 2 jugadores.

## 馃摝 Requisitos generales
### 鈽? Java
- #### Versi贸n m铆nima
    馃煛 [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)
- #### Versi贸n recomendada
    馃煝 [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) *(o m谩s reciente)*

## 鈿欙笍 Requisitos para compilaci贸n
### 馃 Apache Maven
- #### Versi贸n recomendada
    馃煝 [Apache Maven 3.8.6](https://maven.apache.org/download.cgi)

## 馃摜 Descarga
La versi贸n estable m谩s reciente del programa se encuentra disponible para descargar en la secci贸n [releases](https://github.com/akmsw/duxtennis/releases) de este proyecto.

## 鈻讹笍 Instalaci贸n y ejecuci贸n
M谩s all谩 de los requisitos listados, no hace falta ninguna instalaci贸n para correr este programa.\
Una vez descargado el archivo con extensi贸n ***.jar***, e independientemente del sistema operativo que se utilice, se lo puede ejecutar con un simple *doble click*.
Una alternativa es abrir una terminal dentro de la carpeta contenedora del archivo y ejecutar el comando:
```bash
java -jar duxtennis-0.1.jar
```

## 馃洜锔? Compilaci贸n manual
Para compilar manualmente el programa, asumiendo que tanto los [requisitos generales](https://github.com/akmsw/duxtennis#-requisitos-generales) como los [requisitos para compilaci贸n](https://github.com/akmsw/duxtennis#%EF%B8%8F-requisitos-para-compilaci%C3%B3n) han sido instalados correctamente, se debe dirigir a la carpeta contenedora del proyecto y ejecutar Apache Maven haciendo uso del archivo `pom.xml` con el siguiente comando:
```bash
mvn package --file pom.xml
```
o, simplemente:
```bash
mvn package
```

Esto crear谩 una carpeta llamada `target`. Dentro de esa carpeta estar谩 el archivo ejecutable en formato `.jar`. Para ejecutarlo, dentro de la carpeta contenedora, se debe ejecutar el comando indicado anteriormente:
```bash
java -jar duxtennis-0.1.jar
```

## 馃摑 驴C贸mo se usa?
Para comenzar un partido, se debe ingresar el nombre del torneo y de los dos jugadores que participan en el mismo. Luego, se puede calibrar la probabilidad que tiene cada jugador de ganar el partido (recordar que las probabilidades van de 0% a 100% y son complementarias). Finalmente, se puede elegir si jugar un partido a 3 sets o a 5 sets.

Cuando estos par谩metros hayan sido establecidos, se podr谩 hacer click en el bot贸n 'Continuar' para comenzar la simulaci贸n.

En ese momento se abrir谩 una ventana que mostrar谩 el progreso de la simulaci贸n del partido, indicando qui茅n saca en cada set, y cu谩ntos puntos, games y sets ganados tiene cada jugador en el transcurso del mismo. Durante esta simulaci贸n, el usuario s贸lo puede observar el progreso de la simulaci贸n.

Cuando la simulaci贸n finalice, el usuario tendr谩 frente a s铆 una nueva ventana que mostrar谩 el resumen del partido, indicando el resultado de cada set y el ganador del partido del torneo. En este punto, el usuario puede optar por jugar una revancha (iniciar un partido con los mismos jugadores y los mismos par谩metros que los ingresados en un principio), o volver al men煤 principal para comenzar otra simulaci贸n distinta.

## 馃摉 Reglas del juego
Como simple recordatorio, se detallan a continuaci贸n las reglas b谩sicas de un partido de tenis tenidas en cuenta para el desarrollo de este programa.

- El jugador que efect煤a el saque cambiar谩 cada set.
- El primer saque del juego (primer set) ser谩 asignado a un jugador de manera aleatoria.
- El resto de saques ser谩 intercalado (el jugador que sac贸 en el set anterior, recibir谩 en el set actual).
- Cada partido se puede jugar a 3 贸 5 sets.
- Cada set est谩 compuesto por 6 games en principio.
- Para ganar un game, un jugador debe pasar los 40 puntos con diferencia de 2.
- Los puntos son de la forma: 0-15-30-40-game
- Si los jugadores empatan 40-40 en los puntos, el game se disputa por diferencia de 2.
- Si los jugadores empatan 5-5 en games, el set se jugar谩 a 7; y para ganar el set, uno de los dos deber谩 ganar 7-5 (diferencia de 2).
- Si los jugadores empatan 6-6 en games, se entra a un 'tie break', donde jugar谩n m铆nimo hasta 7 puntos (comenzando desde 0), y ganar谩 el set el jugador que gane el tie break a 7 con diferencia de 2.
- Si los jugadores empatan 6-6 en el tie break, se desempatar谩 el tie break con diferencia de 2.
- Si el partido es a 3 sets y un jugador gana 2 sets seguidos, el tercer set no se jugar谩.
- Si el partido es a 5 sets y un jugador gana 3 sets seguidos, el cuarto set no se jugar谩.
- Si el partido es a 5 sets y un jugador gana 3 sets y el otro s贸lo 1, el quinto set no se jugar谩.

## 馃挰 Comentarios
- En la ventana de ingreso de par谩metros, el bot贸n 'Continuar' est谩 deshabilitado al comienzo. Para habilitarlo, es necesario ingresar todos los nombres pedidos (escribir en el campo de texto y presionar la tecla 'Enter').
- Los nombres de los jugadores y del torneo deben estar escritos s贸lo con letras de la A la Z (incluyendo la 脩), en may煤scula o min煤scula, con o sin acentos, con o sin espacios, sin m谩s de 10 caracteres en total.

## 鈿狅笍 Reportes y sugerencias
Si el programa presenta alg煤n error que deber铆a ser reportado para arreglarlo, si podr铆a haber alguna nueva funcionalidad para agregar al programa, o si algo podr铆a ser modificado, la secci贸n de [issues](https://github.com/akmsw/duxtennis/issues) est谩 abierta para hacer estos reportes y/o sugerencias. Es necesario tener una cuenta en GitHub para abrir un nuevo reporte en el repositorio.

## 馃摳 Capturas de pantalla
![mainMenu](./src/main/res/img/readme/ss1.png)\
*Ventana del men煤 principal*

![dataInput](./src/main/res/img/readme/ss2.png)\
*Ventana de ingreso de par谩metros*

![simulation1](./src/main/res/img/readme/ss3.png)\
*Ventana de progreso de simulaci贸n de partido sin deuce ni empates*

![simulation2](./src/main/res/img/readme/ss4.png)\
*Ventana de progreso de simulaci贸n de partido con deuce*

![simulation3](./src/main/res/img/readme/ss5.png)\
*Ventana de progreso de simulaci贸n de partido con empate*

![result1](./src/main/res/img/readme/ss6.png)\
*Ventana de resultado de partido sin empates*

![result2](./src/main/res/img/readme/ss7.png)\
*Ventana de resultado de partido con empates*
