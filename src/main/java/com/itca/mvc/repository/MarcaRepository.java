package com.itca.mvc.repository;

import com.itca.mvc.entity.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{
    
}
