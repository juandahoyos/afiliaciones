### SqlBuilder

Es un bloque que se debe usar junto con una base de datos y tiene la finalizadad  de ayudar al desarrollador a tener cargadas funciones  que le permitan hacer consultas mas complejas 
 y generales entre los motores de base de datos mas populares.

En el ejemplo base de este bloque presenta un endpoint  que se puede acceder  por ejemplo localhost:puerto/nombre_micro/usuarios?nombre=nombre_ejemplo o fechaCreacion=2019-09-11
puede llevar alguno de los campos de la query   ,los campos mencionados serviran para buscar lo siguiente:

- nombre : buscara el nombre el la lista de usuarios
- fechaCreacion : buscara la fechacreacion igual o mayor especificada estara en formato yyyy-mm-dd 

### Funciones incorporadas en el bloque para consultas generales en motores de base de datos

- consulta  con  uso del igual (" = ")
- consulta con uso de IS NOT NULL Y IS NULL
- consulta con uso IN
- consulta con los operadores >= y <=
- consulta con Having 
- consulta con Between
- consulta con OrderBy
- consulta con Limite
 
