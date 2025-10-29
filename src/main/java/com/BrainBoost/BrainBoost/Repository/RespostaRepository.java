package com.BrainBoost.BrainBoost.Repository;


import com.BrainBoost.BrainBoost.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
