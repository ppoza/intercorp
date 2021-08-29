# Intercorp challenge

La aplicación permite iniciar sesión con Facebook, para despues completar tus datos personales y terminar la creación de tu cuenta. Si el usuario que se loguea y tiene creada una cuenta le muestra sus datos.

# Sobre el desarrollo de la aplicación.

* **Lenguaje:** 
  - Java
 
* **Herramientas:** 
  - Live Data
  - View Binding
  - Data Binding
  - Firebase Authentication
  - Firebase Realtime Database

# Arquitectura
MVVM: Siguiendo las recomendaciónes y las herramientas provistas Android

# Lineamientos
Al patrón MVVW se le sumo el seguimiento de las reglas de Clean Architecture, agregando varias capas a la aplicación permitiendo separar las distintas responsabilidades en cada capa.
  
  **Beneficios obtenidos:**
  - La UI no sabe nada de lógica de negocio. A excepción del login con Facebook, debido a la solución de Facebook que te obliga a delegar un poco de esa logica al LoginButton.
  - Los view model solo se encargan de escuchar las interaciones del usuario para disparar los distintos casos de usos sin saber acerca de su implementación.
  - El acesso a la información se soluciono agregando un repositorio que usa una DataSource abstracto, que nos permite cambiar de forma facil su implementación u origen del los datos sin que las demás capas se enteren de dicho cambio.

# Resolución de dependeciás

Se opto por una solución simple, donde la Application tiene tiene la responsabilidad de construir todo objectos complejos, sabiendo de sus dependecias y como resolverlas. Una vez construidos los objectos complejos se los inyecta a un View Model Factory que tiene la responsabilidad de construir los distintos view models.
En una aplicación mas compleja hubiese usado Hilt o Dagger para solucionar la Injeccion de Dependencias.

# Google Play

  [Descargar app](https://play.google.com/store/apps/details?id=com.ppoza.intercorp)
  
