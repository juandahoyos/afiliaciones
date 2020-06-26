CREATE TABLE Afiliado(
 id int NOT NULL AUTO_INCREMENT,
 TipoDocumento varchar(50) NOT NULL,
 Documento varchar(50) NOT NULL,
 Nombre varchar(100) NOT NULL,
 Apellido varchar(100) NOT NULL,
 Sexo varchar(1) NOT NULL,
 Direccion varchar(45) NULL,
 Telefono varchar(45) NULL,
 Correo varchar(50) NULL,
 Activo bit NOT NULL,
 FechaCreacion datetime(0) NULL,
 PRIMARY KEY (Id));