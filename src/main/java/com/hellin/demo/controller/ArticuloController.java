package com.hellin.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hellin.demo.repository.ArticuloRepository;
import com.hellin.demo.entity.Articulo;

@RestController
@RequestMapping("/api/articulos")
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

    @GetMapping("/{id}/basico")
    public ResponseEntity<Map<String, Object>> obtenerArticuloBasico(@PathVariable Integer id) {
        Optional<Articulo> articuloOpt = articulorepository.findById(id);

        // Si no existe, devolvemos 404
        if (articuloOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Articulo articulo = articuloOpt.get();

        // Creamos un mapa (JSON personalizado)
        Map<String, Object> datosBasicos = new HashMap<>();
        datosBasicos.put("id", articulo.getId());
        datosBasicos.put("name", articulo.getName());
        datosBasicos.put("stock", articulo.getStock());

        // Control de stock agotado
        if (articulo.getStock() == 0) {
            datosBasicos.put("mensaje", "Agotado");
        }

        // Devuelve el JSON
        return ResponseEntity.ok(datosBasicos);
    }
}