package com.deluxe.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.deluxe.backend.model.Cliente;

public interface IClienteRepository  extends CrudRepository<Cliente, Long> {

}
