/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Facultad;

/**
 * @author aitor
 *
 */
public interface IFacultadService {
	// Metodos del CRUD
	public List<Facultad> listarFacultad();

	public Facultad guardarFacultad(Facultad facultad);

	public Facultad facultadById(int codigo);

	public Facultad actualizarFacultad(Facultad facultad);

	public void eliminarFacultad(int codigo);
}
