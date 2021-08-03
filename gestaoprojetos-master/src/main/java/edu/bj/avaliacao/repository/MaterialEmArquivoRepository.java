package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bj.avaliacao.model.MaterialEmArquivo;

@Repository
public interface MaterialEmArquivoRepository extends JpaRepository<MaterialEmArquivo, Long>{

}
