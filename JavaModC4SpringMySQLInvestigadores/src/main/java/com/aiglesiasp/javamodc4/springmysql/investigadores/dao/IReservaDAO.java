package com.aiglesiasp.javamodc4.springmysql.investigadores.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiglesiasp.javamodc4.springmysql.investigadores.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Integer> {

}
