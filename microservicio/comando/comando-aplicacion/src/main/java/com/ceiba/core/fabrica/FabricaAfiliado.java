package com.ceiba.core.fabrica;

import org.springframework.stereotype.Component;
import com.ceiba.core.comando.ComandoAfiliado;
import com.ceiba.core.modelo.afiliado.Afiliado;

@Component
public class FabricaAfiliado {
	
	public Afiliado crear(ComandoAfiliado comandoAfiliado) {
	    return new Afiliado(
	    	comandoAfiliado.getId(),
	        comandoAfiliado.getTipoDocumento(),
	    	comandoAfiliado.getDocumento(),
	        comandoAfiliado.getNombre(),
	        comandoAfiliado.getApellido(),
	        comandoAfiliado.getSexo(),
	        comandoAfiliado.getDireccion(),
	        comandoAfiliado.getTelefono(),
	        comandoAfiliado.getCorreo(),
	        comandoAfiliado.isActivo());
	}

	public Afiliado actualizar(ComandoAfiliado comandoAfiliado) {
		return new Afiliado(
				comandoAfiliado.getId(),
				comandoAfiliado.getTipoDocumento(),
				comandoAfiliado.getDocumento(),
				comandoAfiliado.getNombre(),
				comandoAfiliado.getApellido(),
				comandoAfiliado.getSexo(),
				comandoAfiliado.getDireccion(),
				comandoAfiliado.getTelefono(),
				comandoAfiliado.getCorreo(),
				comandoAfiliado.isActivo());
	}

}
