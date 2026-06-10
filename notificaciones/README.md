1. ¿Qué problema busca solucionar el patrón Factory Method?

R/ El problema que busca solucionar el patron es crear objetos directamente y cuando la aplicacion creezca sea dificil de mantener por su alto acoplamiento 

2. ¿Por qué no es recomendable crear objetos directamente en todas las clases del sistema?

R/ No es recomendable porque puede generar una dependencia entre las clases y esto puede hacer que el mantenimiento al sistema sea mas dificil 

3. ¿Qué función cumple la fábrica dentro del patrón?

R/ La funcion de la fábrica es centralizar y encapsular la logica de creacion de los objetos, evitando que las clases clientes tengan que conocer cómo se instancian o qué subclase específica se necesita usar

4. ¿Cuál es la diferencia entre el producto y los productos concretos?

R/ La diferencia es que el producto es la interfaz y los productos concretos son las distintas implementaciones que pueden tener y que heredan de la interfaz 

5. ¿Qué ventajas aporta Factory Method en aplicaciones desarrolladas con Spring Boot?

R/ Permite crear objetos de forma dinámica según lo necesite el sistema, dejando  decida automáticamente qué objeto exacto usar en cada momento sin tener que escribir mucho código repetitivo.

6. ¿Qué ocurriría si fuera necesario agregar un nuevo tipo de objeto al sistema?

R/ Si fuera necesario agragar un nuevo tipo de objeto al sistema solo seria crear el nuevo tipo o sea una nueva clase e implementar el metodo de la interfaz, no se tendria que modificar el cofigo existente 

7. ¿Cómo se relaciona Factory Method con el principio de bajo acoplamiento?

R/ Se relaciona porque las clases ya no dependen de un objeto concreto, sino de una interfaz general, lo que evita que un cambio en una clase obligue a modificar y romper el funcionamiento de las demás.