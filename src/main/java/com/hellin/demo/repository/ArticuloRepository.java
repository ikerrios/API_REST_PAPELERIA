package com.hellin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hellin.demo.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
    
}