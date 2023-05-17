# BackendChallenge HackathonT-Systems


> Aplicación acceso a base de datos desde postman usando filtros por usuario admin

**Badges (opcional)** 
En algunos archivos READMEs, es posible que hayas visto pequeñas imágenes que transmiten metadatos, como si todas las pruebas están pasando o no para el proyecto. Puedes usar [Shields](http://shields.io/) para agregar algunos a tu README. Muchos servicios también tienen instrucciones para agregar una insignia. 

## Motivación 
Practicar y adquirir experiencia en el desarrollo de aplicaciónes usando las tecnologías correspondientes e interactuar con ellas 

## Uso
El usuario, lo primero que ve al hacer una consulta a la raíz es un mensaje de bienvenida "Login & Register server Developede by Alejandro Jiménez Álvarez", se registra con el verbo POST accediendo a localhost:8181/login pasando por el body {username:admin, password:password} petición a la que el servidor devuelve un bearer token que nos permite, introduciendolo en el apartado Authorization hacer peticiónes a endpoints solo accesibles una vez registrado.

```shell
    # Acceder al mensaje de bievenida
localhost:8181
```

```shell
    # Iniciar sesión como usuario "Body: {"username":"admin","password":"password"}"
localhost:8181/login
```


## Installation
Instalación de Spring: https://spring.io/
Instalación de Postman: https://www.postman.com/downloads/
## Stack 
BBDD: MySQL
Backend: Spring, SpringBoot,SpringSecurity
Test: Postman

## License 

Inlcuir la licéncia y el link a esta
[MIT](https://opensource.org/licenses/MIT)
