package com.hellin.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellin.demo.repository.PapeleriaRepository;

import com.hellin.demo.entity.Papeleria;

@RestController
@RequestMapping("/articulos")
/**
 * En este controlador se exponen todos los endpoints referentes a Articulos {{@link name}}
 * @version 1.0
 * @author Iker
 */

 public class PapeleriaController {
    private PapeleriaRepository papeleriaRepository;
    /*
     * Constructor del controlador
     * @param petRepository Repositorio para consultar en BD
     */
   
     public PapeleriaController(PapeleriaRepository papeleriaRepository) {
        this.papeleriaRepository = petRepository;
    }

    /*
    *  Este método devuelve el listado de Articulos
    * @return List<name> Información de cada articulo.
     */
    @GetMapping("/list")
    public List<name> Hello(){
       List<name> listpapeleria = papeleriaRepository.findAll();
        return listpapeleria;
    }
 }