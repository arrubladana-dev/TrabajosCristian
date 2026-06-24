1. ¿Qué problema busca solucionar el patrón Singleton?

R/ El problema que busca solucionar el patro singleton es evitar que hayan
muchas instancias de la misma clase y asi garantizar que se crear muchos objetos

2. ¿Por qué es importante garantizar que una clase tenga una única instancia en determinados escenarios?

R/ Es importante garantizar una unica instancia para evitar problemas con las instancias que pueden llegar 
a causar conflictos y tambien consumirian mucha memoria 

3. ¿Qué características identifican a una clase implementada mediante el patrón Singleton?

R/ Las caracteristicas que se identifican un constructor privado, en sprint boot los beans, un metodo para 
obtener la instancia unica, 

4. ¿Cuál es la diferencia entre crear múltiples instancias de una clase y utilizar una única instancia compartida?

R/ La diferencia cuando se crea una instancia multiple de una clase y una unica instancia es que 
cuando se crean michas instancias, cada veaz que se crea una nueva se crea un espacio en memoria cada que se crea un objeto
indetpendiente. Cuando se crea una unica instancia solo va a haber un unico objeto para toda la aplicacion.

5. ¿Cómo implementa Spring Boot el comportamiento del patrón Singleton en sus Beans?

R/ Spring Boot implementa el singleton atravez de los beans como @Service, @Repository etc.. estos beans automaticamente crea una 
sola instancia 

6. ¿Qué ventajas ofrece utilizar Beans Singleton administrados por Spring Boot frente a implementar el patrón
manualmente en Java?

R/ Las ventajas que ofrece es simplificar el codigo mediante los beans que ahorran lineas de codigo 

7. ¿En qué situaciones considera que el uso del patrón Singleton puede ser una buena alternativa dentro de una
aplicación de software?

R/ Las situaciones en las que se podria implementar el patron de singleton son 
por ejemplo en las clases de servicio ny repositorios para garantizar que se utice una unica instancia para toda la aplicacion
ya que estos son clases unicas que solo se necesita una instancia para toda la aplicacion