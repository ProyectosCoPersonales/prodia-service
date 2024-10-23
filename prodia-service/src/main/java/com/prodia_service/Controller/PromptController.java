package com.prodia_service.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodia_service.Model.Prompt;
import com.prodia_service.Service.PromptService;

@RestController
@RequestMapping("/api/prompt")
public class PromptController {
    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping
    public ResponseEntity<Void> addPrompts(@RequestBody List<Prompt> prompts) {
        promptService.addPrompts(prompts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Prompt>> getAllPrompts(){
        return new ResponseEntity<>(promptService.getAllPrompts(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPrompt(@RequestBody Prompt prompt) {
        promptService.addPrompt(prompt);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePrompt(@RequestBody List<Prompt> prompts) {
        promptService.removePrompt(prompts);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
