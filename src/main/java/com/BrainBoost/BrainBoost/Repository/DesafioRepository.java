package com.BrainBoost.BrainBoost.Repository;

import com.BrainBoost.BrainBoost.model.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafioRepository extends JpaRepository<Desafio, Long> {
}
