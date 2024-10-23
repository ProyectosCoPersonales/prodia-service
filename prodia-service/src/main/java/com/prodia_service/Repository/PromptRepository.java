package com.prodia_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prodia_service.Model.Effect;
import com.prodia_service.Model.Prompt;

import java.util.List;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {
    List<Prompt> findByEffect(Effect effect);
}