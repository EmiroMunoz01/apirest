package com.example.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.model.entity.Cliente;
import com.example.apirest.service.ICliente;

// 1 esta anotacion se usa para marcar una clase como controlador de
// solicitudes, la anotacion restcontroller se usa para crear servicios web
// restful usando spring mvc
@RestController

// 2 esta anotacion le dara a mi restcontroller la identificacion de que esto es
// un recurso que sera consumido y que trabajar por medio de peticiones

@RequestMapping("/api/v1")
public class ClienteController {

    // 3 debemos llamar al servicio, es la logica de negocio, se debe hacer la
    // inyeccion de dependencia

    @Autowired
    private ICliente clienteServicio;

    // 4 crearemos los metodos

    @PostMapping("/cliente")
    // 9 personalizaremos las respuestas http con ResponseStatus

    @ResponseStatus(HttpStatus.CREATED)
    // 6 estamos indicando que cuando envie por medio de json la informacion al
    // llegar
    // al metodo sera transformada en un cliente. Con el RequestBody
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteServicio.save(cliente);
    }

    // 7

    @PutMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizar(@RequestBody Cliente cliente) {
        return clienteServicio.save(cliente);
    }

    // 10 personalizaremos las respuestas http con ResponseStatus

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // 8 cuando estamos pasando un parametro por variable usaremos el @PathVariable
    public void eliminar(@PathVariable Integer id) {
        // 5 debemos pasar un cliente por parametro para su eliminacion, entonces lo
        // buscaremos por su id, de esta forma le pasamos toda la informacion del
        // cliente que se quiere elminar. Eliminaremos por ID
        Cliente clienteDelete = clienteServicio.findById(id);
        clienteServicio.delete(clienteDelete);
    }

    @GetMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente encontrarporId(@PathVariable Integer id) {
        return clienteServicio.findById(id);
    }

}
