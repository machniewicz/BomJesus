package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bj.avaliacao.model.TextoSimples;

@Repository
public interface TextoSimplesRepository extends JpaRepository<TextoSimples, Long>{

}
