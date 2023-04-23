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

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Investigador;
import com.aiglesiasp.javamodc4.springmysql.investigadores.service.InvestigadorServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;

	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigador() {
		return investigadorServiceImpl.listarInvestigador();
	}

	@PostMapping("/investigadores")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}

	@GetMapping("/investigadores/{id}")
	public Investigador investigadorById(@PathVariable(name = "id") int id) {
		Investigador proveedor = new Investigador();
		proveedor = investigadorServiceImpl.investigadorById(id);
		return proveedor;
	}

	@PutMapping("/investigadores/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name = "id") int id,
			@RequestBody Investigador investigador) {

		Investigador investigador_seleccionado = new Investigador();
		Investigador investigador_actualizado = new Investigador();
		investigador_seleccionado = investigadorServiceImpl.investigadorById(id);
		investigador_seleccionado.setId(id);
		investigador_seleccionado.setDni(investigador.getDni());
		investigador_seleccionado.setFacultad(investigador.getFacultad());
		investigador_seleccionado.setNomApels(investigador.getNomApels());
		investigador_seleccionado.setVenta(investigador.getVenta());

		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);
		return investigador_actualizado;
	}

	@DeleteMapping("/investigadores/{id}")
	public void eliminarInvestigador(@PathVariable(name = "id") int id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}

}
