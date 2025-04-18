﻿# Actividad 2 - Java (Casa Inteligente)

## Descripción

Este proyecto fue desarrollado como parte de la **Actividad 2** del curso de Java en la Universidad de la Ciudad de Buenos Aires por **Emiliano Caparroz**.  
Consiste en una aplicación de consola que simula una **Casa Inteligente**, permitiendo ejecutar comandos para encender luces, establecer temperatura y cambiar el modo de operación.

El proyecto se apoya en dos librerías externas:
- [`commons-cli`](https://commons.apache.org/proper/commons-cli/): para parsear argumentos de consola.
- [`log4j2`](https://logging.apache.org/log4j/2.x/): para registrar eventos de forma ordenada y profesional.

---

## Estructura del Proyecto

- Proyecto Maven.
- Artefacto: `Actividad2`
- GroupId: `ar.edu.udeci.pv`
- Versión: `1.0-SNAPSHOT`

---

## Código de ejemplo por librería

### Commons CLI

```java
Options options = new Options();
options.addOption("el", "encender-luz", false, "Enciende la luz de la casa");
CommandLineParser parser = new DefaultParser();
CommandLine cmd = parser.parse(options, args);
if (cmd.hasOption("encender-luz")) {
    System.out.println("Luz encendida");
}
