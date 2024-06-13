package org.example.quorabackend.controller;

import org.example.quorabackend.models.Answer;
import org.example.quorabackend.services.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PutMapping("/{ansId}")
    public Answer updateAnswer(@PathVariable Long ansId, @RequestBody Answer ans) {
        return answerService.updateAnswer(ansId, ans);
    }
}
