/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author aitor
 *
 */
@Entity
@Table(name = "investigadores")
public class Investigador {
	// Atributos de entidad departamento
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "dni")
	private String dni;
	@Column(name = "nomApels")
	private String nomApels;

	@OneToMany
	@JoinColumn(name = "venta")
	private List<Reserva> venta;

	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	// CONSTRUCTORES
	public Investigador() {

	}

	public Investigador(String dni, String nomApels, Facultad facultad) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.facultad = facultad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Ventas")
	public List<Reserva> getVenta() {
		return venta;
	}

	public void setVenta(List<Reserva> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Investigador [id=" + id + ", dni=" + dni + ", nomApels=" + nomApels + ", venta=" + venta + ", facultad="
				+ facultad + "]";
	}

}
