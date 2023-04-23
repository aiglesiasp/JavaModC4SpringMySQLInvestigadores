/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author aitor
 *
 */
@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "comienzo")
	private Date comienzo;

	@Column(name = "fin")
	private Date fin;

	@ManyToOne
	@JoinColumn(name = "equipo")
	private Equipo equipo;

	@ManyToOne
	@JoinColumn(name = "investigador")
	private Investigador investigador;

	// CONTRUCTORES
	public Reserva() {

	}

	public Reserva(Date comienzo, Date fin, Equipo equipo, Investigador investigador) {
		this.comienzo = comienzo;
		this.fin = fin;
		this.equipo = equipo;
		this.investigador = investigador;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", equipo=" + equipo
				+ ", investigador=" + investigador + "]";
	}

}
