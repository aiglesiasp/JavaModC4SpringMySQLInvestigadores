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

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Facultad;
import com.aiglesiasp.javamodc4.springmysql.investigadores.service.FacultadServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;

	@GetMapping("/facultades")
	public List<Facultad> listarFacultad() {
		return facultadServiceImpl.listarFacultad();
	}

	@PostMapping("/facultades")
	public Facultad guardarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}

	@GetMapping("/facultades/{codigo}")
	public Facultad facultadById(@PathVariable(name = "codigo") int codigo) {
		Facultad facultad = new Facultad();
		facultad = facultadServiceImpl.facultadById(codigo);
		return facultad;
	}

	@PutMapping("/facultades/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name = "codigo") int codigo, @RequestBody Facultad facultad) {

		Facultad facultad_seleccionado = new Facultad();
		Facultad facultad_actualizado = new Facultad();
		facultad_seleccionado = facultadServiceImpl.facultadById(codigo);
		facultad_seleccionado.setCodigo(codigo);
		facultad_seleccionado.setEquipo(facultad.getEquipo());
		facultad_seleccionado.setInvestigador(facultad.getInvestigador());
		facultad_seleccionado.setNombre(facultad.getNombre());

		facultad_actualizado = facultadServiceImpl.actualizarFacultad(facultad_seleccionado);

		return facultad_actualizado;
	}

	@DeleteMapping("/facultades/{codigo}")
	public void eliminarFacultad(@PathVariable(name = "codigo") int codigo) {
		facultadServiceImpl.eliminarFacultad(codigo);
	}

}
