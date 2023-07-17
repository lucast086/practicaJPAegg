# CLASE PRACTICA DE JPA

## Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Contributing](../CONTRIBUTING.md)

## About <a name = "about"></a>

Repositorio de la clase practica de JPA, hay 2 ejercicios el pruebaJPA es el armado fuera de clase como ejemplo. y el practicaJPA es el que modificamos jutnso en clase.

## Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

Netbeans
Java jdk 8
jdk 17
Driver de Myqsl 8.0.x


### Installing

Recuerda que debes configurar tu unidad de persistencia con los datos de tu coneccion.
ademas debes editar la linea en RepositorioJPA con el nombre de tu unidad de persistencia

```
    public RepositorioJPA() {
        emf = Persistence.createEntityManagerFactory("practicaJPAPU");
        em = emf.createEntityManager();
    }
```


## Usage <a name = "usage"></a>

Modifica el proyecto a tu gusto, replicalo, y nunca dejes de practicar.
