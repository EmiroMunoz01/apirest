package com.example.apirest.service;


import com.example.apirest.model.entity.Cliente;



public interface ICliente {

    // guardara un cliente
    //este metodo tambien nos servira para guardar 
    Cliente save(Cliente cliente);

    Cliente findById(Integer id);
    
    void delete(Cliente cliente);

}
