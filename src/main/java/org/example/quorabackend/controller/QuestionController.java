package org.example.quorabackend.controller;


import org.example.quorabackend.models.Answer;
import org.example.quorabackend.models.Question;
import org.example.quorabackend.services.AnswerService;
import org.example.quorabackend.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;
    private AnswerService answerService;

    public QuestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @PostMapping()
    public Question createQuestion(@RequestBody Question newQues) {
        return questionService.createQuestion(newQues);
    }

    @PostMapping("/{quesId}/answers")
    public Answer createAnswer(@RequestBody Answer ans, @PathVariable Long quesId) {
        return answerService.createAnswer(quesId,ans);
    }
}
