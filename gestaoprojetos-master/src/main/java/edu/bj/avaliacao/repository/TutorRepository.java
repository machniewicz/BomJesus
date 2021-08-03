package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.bj.avaliacao.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{

}
