package org.example.quorabackend.services;

import org.example.quorabackend.models.Answer;
import org.example.quorabackend.models.Question;
import org.example.quorabackend.models.User;
import org.example.quorabackend.repository.AnswerRepository;
import org.example.quorabackend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(Long questionId, Answer answer) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            answer.setQuestion(question);
            System.out.println("ANSWER ----- " + answer);
            answerRepository.save(answer);
            return answer;
        } else {
            throw new RuntimeException("Question not found");
        }
    }

    public Answer updateAnswer(Long ansId, Answer updatedAnswer) {
        return answerRepository.findById(ansId).map(answer -> {
            answer.setBody(updatedAnswer.getBody());
            return answerRepository.save(answer);
        }).orElseGet(() -> {
            updatedAnswer.setId(ansId);
            return answerRepository.save(updatedAnswer);
        });
    }
}
