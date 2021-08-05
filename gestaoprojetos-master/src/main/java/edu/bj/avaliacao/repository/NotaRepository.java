package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bj.avaliacao.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{

}
