package br.edu.atitus.greeting_service.controllers;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.greeting_service.dto.GreetingDTO;

// import br.edu.atitus.greeting_service.configs.GreetingConfig;

@RestController
@RequestMapping("greeting-service")
public class GreetingController {

    // private final GreetingConfig greetingConfig;

    // public GreetingController(GreetingConfig greetingConfig) {
    //     super();
    //     this.greetingConfig = greetingConfig;
    // }
    
    private final MessageSource messageSource;

    public GreetingController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    
    @GetMapping({"", "/", "/{namePath}"})
    public ResponseEntity<String> getGreetingService(
        @RequestParam(required = false) String name,
        @PathVariable(required = false) String namePath,
        @RequestParam(defaultValue = "en") String lang) {
        
        Locale locale = Locale.forLanguageTag(lang);

        String greeting = messageSource.getMessage("greeting.text", null, locale);
        String defaultName = messageSource.getMessage("default.name", null, locale);

        if (name == null)
            name = namePath != null ? namePath : defaultName;
        
        String textReturn = String.format("%s, %s!!", greeting, name);
        return ResponseEntity.ok(textReturn);
    }

    @PostMapping("/greeting")
    public ResponseEntity<String> postGreetingService (
        @RequestBody GreetingDTO greetingDTO,
        @RequestParam(defaultValue = "en") String lang) {

        Locale locale = Locale.forLanguageTag(lang);
        String greeting = messageSource.getMessage("greeting.text", null, locale);

        String name = greetingDTO.getName();

        String textReturn = String.format("%s, %s!!", greeting, name);
        return ResponseEntity.ok(textReturn);
        }
}