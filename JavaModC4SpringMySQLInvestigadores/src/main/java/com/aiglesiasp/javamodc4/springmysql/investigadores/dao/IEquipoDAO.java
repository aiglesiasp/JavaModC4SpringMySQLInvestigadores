/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Equipo;

/**
 * @author aitor
 *
 */
public interface IEquipoDAO extends JpaRepository<Equipo, Integer> {

}
