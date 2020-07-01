update afiliado
set TipoDocumento = :tipoDocumento,
	Documento = :documento,
	Nombre = :nombre,
	Apellido = :apellido,
	Sexo = :sexo,
	Direccion = :direccion,
	Telefono = :telefono,
	Correo = :correo,
	Activo = :activo
where IdAfiliado = :idAfiliado