/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Equipo;

/**
 * @author aitor
 *
 */
public interface IEquipoService {
	// Metodos del CRUD
	public List<Equipo> listarEquipo();

	public Equipo guardarEquipo(Equipo equipo);

	public Equipo equipoById(int codigo);

	public Equipo actualizarEquipo(Equipo equipo);

	public void eliminarEquipo(int codigo);
}
