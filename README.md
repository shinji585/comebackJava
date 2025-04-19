# 🧠 Estudio: Manejo de Archivos en Java

Este repositorio contiene ejemplos prácticos y anotaciones sobre la **serialización y deserialización de objetos en Java**. Aquí se estudian temas clave como `ObjectOutputStream`, `ObjectInputStream`, estructuras serializables y su uso práctico en proyectos reales. Además, se pondrá a prueba el estudio de estos conocimientos con ejercicios de criptografía, conexiones a bases de datos y manejo de librerías como **Gson**.

---

## 📂 Estructura del Repositorio

### 📁 `manejoArchivos`
Contiene los **temas explicados y estudiados** paso a paso, incluyendo:
- Serialización básica de objetos.
- Clases abstractas y anidadas.
- Lectura y escritura con streams.
- Polimorfismo y jerarquías de clases.

### 📁 `ejercicioManejoArchivos`
Incluye **ejercicios resueltos y en práctica**, sin importar el orden del tema o nivel. Es un espacio para reforzar lo aprendido mediante pruebas concretas.

---

## 🧱 Temario Estudiado

### 1. Fundamentos
- `FileOutputStream` y `FileInputStream`
  - Escritura y lectura de datos binarios.
  - Métodos importantes: `.write()`, `.read()`.

### 2. Serialización
- `ObjectOutputStream` y `ObjectInputStream`
  - Serialización de objetos usando `Serializable`.
  - Almacenamiento en archivos `.dat`.

### 3. Clases y Polimorfismo
- Uso de clases `abstract`.
- Clases internas `protected static`.
- Herencia y sobrescritura de métodos.

### 4. Lo que sigue...
- Serialización de estructuras (`ArrayList`, `HashMap`).
- Manejo de errores comunes (casting, archivos corruptos).
- Implementación de interfaces adicionales (como `Comparable`).

---

## 📄 Archivos Clave

| Archivo / Paquete                 | Descripción                                      |
|----------------------------------|--------------------------------------------------|
| `ClaseEjemplo.java`              | Clase base abstracta y subclases serializables.  |
| `Manejo2.java`                   | Escritura y lectura de un objeto en archivo `.dat`. |
| `archivos.dat`                   | Archivo generado al serializar el objeto.        |
| `ejercicioManejoArchivos`        | Carpeta con ejercicios prácticos sin orden temático. |

---

## 🛠️ Requisitos

- JDK 8 o superior.
- Conocimientos básicos de Programación Orientada a Objetos.
- Editor o IDE que soporte Java (por ejemplo, IntelliJ IDEA, Eclipse, VS Code).

---

## 🧠 Notas Rápidas

> 🔁 `readObject()` siempre devuelve un `Object`, por lo que debes hacer *cast* al tipo original.  
> 💡 Una clase debe implementar `Serializable` para ser escrita con `ObjectOutputStream`.

---

## 🚀 Autor

**Shinji585** — Estudio autodidacta con el objetivo de dominar el manejo de archivos y persistencia en Java.
