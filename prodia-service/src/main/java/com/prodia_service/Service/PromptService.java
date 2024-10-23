package com.prodia_service.Service;

import java.util.List;
import com.prodia_service.Model.Effect;
import com.prodia_service.Model.Prompt;

public interface PromptService {
    void addPrompts(List<Prompt> prompts);
    Prompt getRandomPromptByEffect(Effect effect);
    List<Prompt> getAllPrompts();
    void addPrompt(Prompt prompt);
    void removePrompt(List<Prompt> prompts);
}