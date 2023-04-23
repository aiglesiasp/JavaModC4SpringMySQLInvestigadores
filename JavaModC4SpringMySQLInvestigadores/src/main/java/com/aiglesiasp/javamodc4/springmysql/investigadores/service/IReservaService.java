/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.service;

import java.util.List;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Reserva;

/**
 * @author aitor
 *
 */
public interface IReservaService {
	// Metodos del CRUD
	public List<Reserva> listarReserva();

	public Reserva guardarReserva(Reserva reserva);

	public Reserva reservaById(int id);

	public Reserva actualizarReserva(Reserva reserva);

	public void eliminarReserva(int id);
}
