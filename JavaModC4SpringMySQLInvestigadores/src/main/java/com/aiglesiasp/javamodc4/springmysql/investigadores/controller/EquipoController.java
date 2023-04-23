/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Equipo;
import com.aiglesiasp.javamodc4.springmysql.investigadores.service.EquipoServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;

	@GetMapping("/equipos")
	public List<Equipo> listarCajero() {
		return equipoServiceImpl.listarEquipo();
	}

	@PostMapping("/equipos")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}

	@GetMapping("/equipos/{id}")
	public Equipo equipoById(@PathVariable(name = "id") int id) {
		Equipo equipo = new Equipo();
		equipo = equipoServiceImpl.equipoById(id);
		return equipo;
	}

	@PutMapping("/equipos/{id}")
	public Equipo actualizarEquipo(@PathVariable(name = "id") int id, @RequestBody Equipo equipo) {

		Equipo equipo_seleccionado = new Equipo();
		Equipo equipo_actualizado = new Equipo();
		equipo_seleccionado = equipoServiceImpl.equipoById(id);
		equipo_seleccionado.setId(id);
		equipo_seleccionado.setFacultad(equipo.getFacultad());
		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setNumserie(equipo.getNumserie());
		equipo_seleccionado.setVenta(equipo.getVenta());

		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);

		return equipo_actualizado;
	}

	@DeleteMapping("/equipos/{id}")
	public void eliminarEquipo(@PathVariable(name = "id") int id) {
		equipoServiceImpl.eliminarEquipo(id);
	}

}
