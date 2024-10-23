package com.example.apirest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apirest.model.dao.ClienteDao;
import com.example.apirest.model.entity.Cliente;
import com.example.apirest.service.ICliente;

//debemos indicar que es una capa de servicios
@Service
public class ClienteImpl implements ICliente {
    // 1 llamaremos directamente al clienteDao
    @Autowired
    private ClienteDao clienteDao;

    // 4 con el Transactional indicamos que solo es una opcion de lectura
    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    // 6 cuando es una consulta de datos debemos enviarlo como read, para que no se
    // puedan hacer modificaciones desde el metodo indicado, asi indicamos que es
    // solo una consulta, el transactional debe ser de spring boot

    @Transactional(readOnly = true)
    // 2 el orElse es necesario en caso de que no encontremos el cliente lo
    // retorne como null
    @Override
    public Cliente findById(Integer id) {
        // 3 en caso de no encontrar el cliente sera null
        return clienteDao.findById(id).orElse(null);
    }

    // 5 aqui tenemos la opcion de eliminar,
    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

}
 