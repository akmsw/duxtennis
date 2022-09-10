# 🎾 DuxTennis

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
- [Compilación manual](https://github.com/akmsw/duxtennis#-compilaci%C3%B3n-manual)
- [¿Cómo se usa?](https://github.com/akmsw/duxtennis#-c%C3%B3mo-se-usa)
- [Solución a problemas frecuentes](https://github.com/akmsw/duxtennis#%EF%B8%8F-soluci%C3%B3n-a-problemas-frecuentes)
  - [En Linux](https://github.com/akmsw/duxtennis#-en-linux)
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
- ### Versión recomendada
    🟢 [Apache Maven 3.8.6](https://maven.apache.org/download.cgi)

## 📥 Descarga
La versión estable más reciente del programa se encuentra disponible para descargar en la sección [releases](https://github.com/akmsw/duxtennis/releases) de este proyecto.

## ▶️ Instalación y ejecución
Más allá de los requisitos listados, no hace falta ninguna instalación para correr este programa.\
Una vez descargado el archivo con extensión ***.jar***, e independientemente del sistema operativo que se utilice, se lo puede ejecutar con un simple *doble click*. En caso de estar en Linux y que el programa no se abra, revisar la sección de [solución a problemas frecuentes en linux](https://github.com/akmsw/duxtennis#-en-linux).\
Una alternativa es abrir una terminal dentro de la carpeta contenedora del archivo y ejecutar el comando:
```bash
java -jar nombre_del_archivo.jar
```

## 👨‍🏭 Compilación manual
Para compilar manualmente el programa, asumiendo que tanto los [requisitos generales]() como los [requisitos de compilación]() han sido instalados correctamente, se debe dirigir a la carpeta contenedora del proyecto y ejecutar Apache Maven haciendo uso del archivo `pom.xml` con el siguiente comando:
```bash
mvn package --file pom.xml
```
o, simplemente:
```bash
mvn package
```

Esto creará una carpeta llamada `target`. Dentro de esa carpeta estará el archivo ejecutable en formato `.jar`. Para ejecutarlo, dentro de la carpeta contenedora, se debe ejecutar el comando indicado anteriormente:
```bash
java -jar nombre_del_archivo.jar
```

## 📝 ¿Cómo se usa?


## 🛠️ Solución a problemas frecuentes
### 🐧 En Linux
- Si el archivo ***.jar*** no se ejecuta al hacerle doble click, hacer lo siguiente:
  - Click derecho sobre el archivo descargado
  - Propiedades
  - Abrir con...
  - En el campo de ingreso de comando personalizado, ingresar: `java -jar`
  - Seleccionarlo como opción predeterminada para la ejecución de archivos .jar

## 📸 Capturas de pantalla