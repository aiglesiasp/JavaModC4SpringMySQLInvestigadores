/**
 * 
 */
package com.aiglesiasp.javamodc4.springmysql.investigadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Investigador;

/**
 * @author aitor
 *
 */
public interface IInvestigadorDAO extends JpaRepository<Investigador, Integer> {

}
