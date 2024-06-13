package org.example.quorabackend.services;

import org.example.quorabackend.models.Answer;
import org.example.quorabackend.models.Question;
import org.example.quorabackend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question ques) {
        return questionRepository.save(ques);
    }
}
