package com.hellin.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellin.demo.repository.ArticuloRepository;
import com.hellin.demo.entity.Articulo;

@RestController
@RequestMapping("/articulos")
 /**
 * En este controlador se exponen todos los endpoints referentes a Articulos {{@link name}}
 * @version 1.0
 * @author Iker
 */

 public class ArticuloController {
    private ArticuloRepository articulorepository;
    /*
     * Constructor del controlador
     * @param ArticuloRepository Repositorio para consultar en BD
     */
   
     public ArticuloController(ArticuloRepository articulorepository) {
        this.articulorepository = articulorepository;
    }

    /*
    *  Este método devuelve el listado de Articulos
    * @return List<Articulo> Información de cada articulo.
     */
    @GetMapping("/list")
    public List<Articulo> Listaarticulos(){
        return articulorepository.findAll();
    }
 }