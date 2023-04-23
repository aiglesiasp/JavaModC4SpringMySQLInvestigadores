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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author aitor
 *
 */
@Entity
@Table(name = "facultad")
public class Facultad {
	// Atributos de entidad departamento
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "equipo")
	private List<Equipo> equipo;

	@OneToMany
	@JoinColumn(name = "investigador")
	private List<Investigador> investigador;

	// CONSTRUCTORES
	public Facultad() {

	}

	public Facultad(String nombre) {
		this.nombre = nombre;
	}

	// GETTERS Y SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigadores")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", equipo=" + equipo + ", investigador="
				+ investigador + "]";
	}

}
