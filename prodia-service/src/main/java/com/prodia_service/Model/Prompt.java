package com.prodia_service.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prompts")
public class Prompt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Effect effect;
    @Column(columnDefinition = "TEXT")
    private String description;
    public Long getId() {
        return id;
    }
    public Prompt() {
    }
    public Prompt(Long id, Effect effect, String description) {
        this.id = id;
        this.effect = effect;
        this.description = description;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Effect getEffect() {
        return effect;
    }
    public void setEffect(Effect effect) {
        this.effect = effect;
    }
    
}
