# 🫕 Práctica de Concurrencia: La Simulación de la Fondue

Este proyecto es una práctica académica desarrollada en Java para el ciclo formativo de **Desarrollo de Aplicaciones Multiplataforma (DAM)**. El objetivo principal es aplicar conceptos avanzados de **programación concurrente y multihilo (Threads)**, gestionando el acceso a recursos limitados mediante mecanismos de sincronización (como `Semaphore` o `synchronized`).

## 🚀 Descripción del Problema

La simulación modela a un grupo de \(N\) amigos comiendo en una fondue, donde el número de tenedores disponibles (\(M\) o \(P\)) es menor que el número de personas. Esto obliga a los hilos (amigos) a competir por los recursos y esperar su turno de forma controlada.

### Condiciones del Entorno:
* **Tiempo de comer**: Fijado en 2 segundos para todos.
* **Tiempo de cocinar**: Aleatorio entre 4 y 7 segundos (asignado por constructor a cada persona).
* **Estados**: Cada hilo debe notificar claramente por consola si está **esperando**, **cocinando** o **comiendo**.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje**: Java 17 o superior.
* **Conceptos de Concurrencia**: `Thread`, `Runnable`, `Semaphore`, Bloqueos mutuos (Deadlocks) y condiciones de carrera.

## 📦 Estructura del Proyecto

El código está dividido en paquetes independientes que corresponden a la evolución y resolución de cada apartado del ejercicio:

```text
practica-fondues-threads/
│
└── src/
    ├── FoundeA/   # Apartado A: Simulación básica con una fondue de carne y M tenedores.
    ├── FoundeB/   # Apartado B: Segunda fondue (queso) con P tenedores; elección al azar con espera.
    ├── FoundeC/   # Apartado C: Alternancia inteligente (si la fondue elegida está llena, intenta la otra).
    ├── FoundeD/   # Apartado D: Restricciones por constructor (preferencias de carne, queso o ambas).
    ├── FoundeE/   # Apartado E: Combinación de alternancia inteligente con restricciones de gustos.
    └── FoundeF/   # Apartado F: Recursos limitados (fin de existencias de comida) y parada controlada del programa.
```

## 📝 Fases de la Práctica (Ejercicios)

* **`FoundeA`**: Implementación del semáforo base para controlar los tenedores limitados de la fondue de carne.
* **`FoundeB`**: Introducción de una fondue de queso paralela con sus propios tenedores independientes. Selección aleatoria con bloqueo en caso de estar llena.
* **`FoundeC`**: Optimización de la espera. Si el recurso principal está ocupado, el hilo no se bloquea inmediatamente; comprueba si la otra fondue tiene hueco.
* **`FoundeD`**: Filtrado de hilos mediante el constructor (`Solo Carne`, `Solo Queso`, `Ambos`), restringiendo las fondues a las que pueden optar.
* **`FoundeE`**: Fusión de la lógica de selección alternativa del apartado C respetando las restricciones alimentarias del apartado D.
* **`FoundeF`**: Gestión del ciclo de vida y finalización de hilos. Introducción de un stock limitado de porciones de carne/queso que finaliza la ejecución global al agotarse.

## 🔧 Ejecución del Proyecto

Cada carpeta contiene su propio punto de entrada (método `main`). Para probar una fase específica desde tu IDE:
1. Navega hasta la carpeta correspondiente (ej. `FoundeF`).
2. Ejecuta la clase principal que inicializa el array de hilos de personas ('Principal.java' dentro de dicho paquete).

## 🤝 Autores

* **Ivan VIlla** - *Desarrollo Completo* - 
