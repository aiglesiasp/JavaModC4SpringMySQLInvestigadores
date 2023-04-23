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

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Reserva;
import com.aiglesiasp.javamodc4.springmysql.investigadores.service.ReservaServiceImpl;

/**
 * @author aitor
 *
 */
@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;;

	@GetMapping("/reservas")
	public List<Reserva> listarReserva() {
		return reservaServiceImpl.listarReserva();
	}

	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}

	@GetMapping("/reservas/{id}")
	public Reserva reservaById(@PathVariable(name = "id") int id) {
		Reserva reserva = new Reserva();
		reserva = reservaServiceImpl.reservaById(id);
		return reserva;
	}

	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") int id, @RequestBody Reserva reserva) {

		Reserva reserva_seleccionado = new Reserva();
		Reserva reserva_actualizado = new Reserva();
		reserva_seleccionado = reservaServiceImpl.reservaById(id);
		reserva_seleccionado.setId(id);
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setEquipo(reserva.getEquipo());
		reserva_seleccionado.setFin(reserva.getFin());
		reserva_seleccionado.setInvestigador(reserva.getInvestigador());

		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);
		return reserva_actualizado;
	}

	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name = "id") int id) {
		reservaServiceImpl.eliminarReserva(id);
	}

}
