package com.example.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.apirest.model.entity.Cliente;


//usaremos crud repository para un crud
//usar JpaRepository cuando estemos realizando consultas muy complejas

public interface ClienteDao extends CrudRepository<Cliente, Integer>{


}
