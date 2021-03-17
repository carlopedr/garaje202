# garaje202
Práctica final curso POO - Java TDS USCO 2020-2
Práctica. Garaje de reparación y revisión de vehículos

Desarrollo
Tomando como base el documento de requisitos que aparece a continuación realizar:
1.	realizar el diseño (diagrama de clases) de la aplicación
2.	implementar el diseño realizado

Documento de requisitos
Descripción general
Se desea realizar una aplicación que permita a los mecánicos de un garaje registrar, consultar y actualizar los trabajos (reparaciones y revisiones) que han sido realizados o que están en proceso de realización en el garaje.
Cada trabajo se identifica unívocamente por su "identificador de trabajo". El "identificador de trabajo" es un número que se asocia con el trabajo en el momento que se registra. El primer trabajo registrado tendrá el identificador 0, el segundo el 1 y así sucesivamente.
Los trabajos incluyen una pequeña descripción de la reparación o revisión a realizar.
Todos los trabajos incluyen el número de horas que van siendo necesarias para su realización. Al crear un trabajo el número de horas es 0. El número de horas irá aumentando a medida que los mecánicos van dedicando tiempo a realizar la reparación o la revisión. Cuando el trabajo se ha finalizado se marca como "finalizado" y el número de horas no puede volver a cambiarse.
Las reparaciones incluyen el precio del material utilizado (piezas o pintura). Al registrar una reparación el precio del material es 0 y va aumentando a medida que los mecánicos van utilizando material en la reparación. Una vez que la reparación se marca como "finalizada" no se puede cambiar el precio del material utilizado.
El precio a cobrar para cada trabajo se compone de una parte fija que resulta de multiplicar el número de horas empleadas por $50.000. Además, dependiendo del tipo de trabajo el coste varía   de la siguiente manera:
•	Reparación mecánica: su precio se calcula como fijo más el coste material multiplicado por 1.1.
•	Reparación de latonería y pintura: su precio se calcula como fijo más el coste material multiplicado por 1.3.
•	Revisión: su precio se calcula como fijo más extra independiente del número de horas de $200.000.
El garaje se ha marcado unos plazos máximos en los que deberían estar terminados los trabajos. Estos plazos son: 21 días para las reparaciones de latonería y pintura, 14 para las reparaciones mecánicas y 7 para las revisiones.
La aplicación se gestionará mediante una interfaz gráfica basada en menú.

Casos de uso
Las operaciones que se desea que los mecánicos puedan realizar son las descritas en los siguientes casos de uso:
Caso de uso "Registra trabajo":
1.	El mecánico selecciona la opción "Registra trabajo".
2.	La aplicación muestra una ventana que permite introducir el tipo de trabajo y su descripción.
3.	El mecánico introduce los datos.
4.	La aplicación añade el trabajo a la lista de trabajos registrados y muestra el identificador asignado al trabajo.
Caso de uso "Aumenta horas":
1.	El mecánico selecciona la opción "Aumenta horas".
2.	La aplicación muestra una ventana que permite introducir el identificador del trabajo y el número de horas.
3.	El mecánico introduce los datos.
4.	La aplicación aumenta las horas al trabajo.
-	Se notifica un error si el trabajo ya está finalizado, el número de horas es negativo o el identificador es incorrecto.
Caso de uso "Aumenta coste piezas":
1.	El mecánico selecciona la opción "Aumenta coste piezas".
2.	La aplicación muestra una ventana que permite introducir el identificador del trabajo y el coste de las piezas.
3.	El mecánico introduce los datos.
4.	La aplicación aumenta el coste de las piezas al trabajo.
-	Se notifica un error si el trabajo no es una reparación, o ya está finalizado, o el coste es negativo o el identificador es incorrecto.
Caso de uso "Finaliza trabajo":
1.	El mecánico selecciona la opción "Finaliza trabajo".
2.	La aplicación muestra una ventana que permite introducir el identificador del trabajo.
3.	El mecánico introduce el identificador.
4.	La aplicación registra el trabajo como finalizado.
-	Se notifica un error si el identificador es incorrecto.
Caso de uso "Muestra trabajo":
1.	El mecánico selecciona la opción "Muestra trabajo".
2.	La aplicación muestra una ventana que permite introducir el identificador del trabajo.
3.	El mecánico introduce el identificador.
4.	La aplicación muestra el identificador, la descripción y el precio del trabajo.
-	Se notifica un error si el identificador es incorrecto.
Caso de uso "Consulta plazo":
1.	El mecánico selecciona la opción "Consulta plazo".
2.	La aplicación muestra una ventana que permite introducir el identificador del trabajo.
3.	El mecánico introduce el identificador.
4.	La aplicación muestra el plazo máximo en el que debería estar finalizado el trabajo.
-	Se notifica un error si el identificador es incorrecto.
Caso de uso "Muestra todos":
1.	El mecánico selecciona la opción "Muestra todos".
2.	La aplicación muestra una ventana que muestra los datos de todos los trabajos: para todos los trabajos se muestra: identificador, horas, precio y plazo. En el caso de las repa- raciones se muestra además el dinero gastado en material.

Entregar
•	Diagrama de clases
•	Código desarrollado

