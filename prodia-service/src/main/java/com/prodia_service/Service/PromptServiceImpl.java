package com.prodia_service.Service;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

import com.prodia_service.Model.Effect;
import com.prodia_service.Model.Prompt;
import com.prodia_service.Repository.PromptRepository;

@Service
public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    public PromptServiceImpl(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    @Override
    public void addPrompts(List<Prompt> prompts) {
        promptRepository.saveAll(prompts);
    }

    @Override
    public Prompt getRandomPromptByEffect(Effect effect) {
        List<Prompt> prompts = promptRepository.findByEffect(effect);
        if (prompts.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return prompts.get(random.nextInt(prompts.size()));
    }

    @Override
    public List<Prompt> getAllPrompts() {
        return promptRepository.findAll();
    }

    public void addPrompt(Prompt prompt){
        promptRepository.save(prompt);
    }

    public void removePrompt(List<Prompt> prompts){
        promptRepository.deleteAll(prompts);;
    }
}
