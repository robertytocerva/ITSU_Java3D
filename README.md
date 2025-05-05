# ITSU_Java3D

Proyecto Java que utiliza la biblioteca **Java 3D** para renderizar figuras tridimensionales, aplicando transformaciones, iluminación y animaciones. Este proyecto tiene fines educativos, ideal para entender la construcción y manipulación de escenas 3D con Java.

## 📷 Captura

*(Pediente)*

---

## 🚀 Características

- Renderizado de objetos 3D como cubos, esferas y conos.
- Aplicación de transformaciones: rotación, traslación y escala.
- Comportamientos animados usando Java 3D.
- Iluminación básica y control de cámara.
- Interfaz gráfica intuitiva con controles visuales.

---

## 🧱 Estructura del Proyecto

- `Main.java`: Punto de entrada. Crea y lanza la ventana principal.
- `VentanaPrincipal.java`: Interfaz gráfica (`JFrame`) donde se monta el `Canvas3D`.
- `Escena3D.java`: Configura el universo 3D, añadiendo luces, objetos y comportamientos.
- `Objeto3D.java`: Clase base para objetos 3D con geometría y transformaciones.
- `Cubo.java`, `Esfera.java`, `Cono.java`: Extienden `Objeto3D` para representar figuras específicas.
- `ControladorTransformaciones.java`: Aplica transformaciones a los objetos.
- `AnimacionRotacion.java`: Aplica animaciones de rotación continua.

---

## 🔧 Requisitos

- JDK 8–11 (recomendado)
- Java 3D (puede descargarse desde [aquí](https://java3d.java.net/))
- IDE como NetBeans o IntelliJ para compilar y ejecutar

---

## ▶️ Instrucciones de Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/robertytocerva/ITSU_Java3D.git
