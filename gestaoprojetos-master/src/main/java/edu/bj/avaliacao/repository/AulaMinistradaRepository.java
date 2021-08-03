package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bj.avaliacao.model.AulaMinistrada;

@Repository
public interface AulaMinistradaRepository extends JpaRepository<AulaMinistrada, Long>{
	
}
