/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Facultad;

/**
 * @author aitor
 *
 */
public interface IFacultadDAO extends JpaRepository<Facultad, Integer> {

}
