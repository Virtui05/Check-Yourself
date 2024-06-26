package com.example.quizmanagement.controller;

import com.example.quizmanagement.dto.request.QuizRequest;
import com.example.quizmanagement.dto.response.QuizResponse;
import com.example.quizmanagement.dto.response.QuizResponseWithAnswers;
import com.example.quizmanagement.dto.response.SimpleQuizResponse;
import com.example.quizmanagement.mapper.QuizManagementMapper;
import com.example.quizmanagement.repository.QuizRepository;
import com.example.quizmanagement.service.QuizManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quiz")
public class QuizManagementController {
    private final QuizManagementService quizManagementService;

    @PostMapping
    public QuizResponseWithAnswers createQuiz(@Valid @RequestBody QuizRequest quiz) {
        return quizManagementService.save(quiz);
    }

    @GetMapping("/answers/{id}")
    public QuizResponseWithAnswers getQuizWithAnswers(@PathVariable long id) {
        return quizManagementService.getQuizWithAnswers(id);
    }

    @GetMapping("/{id}")
    public QuizResponse getQuizWithoutAnswers(@PathVariable long id) {
        return quizManagementService.getQuizWithoutAnswers(id);
    }

    @PutMapping("/{id}")
    public QuizResponseWithAnswers editQuiz(@RequestBody QuizRequest request, @PathVariable long id) {
        return quizManagementService.editQuiz(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable long id) {
        quizManagementService.deleteQuiz(id);
    }

    @GetMapping("/get-all")
    public List<SimpleQuizResponse> getAllQuizByCompany() {
        return quizManagementService.getAllQuizByCompany();
    }

    @GetMapping("/get-all/{id}")
    public List<SimpleQuizResponse> getAllQuizByCompanyId(@PathVariable Long id) {
        return quizManagementService.getAllQuizByCompanyId(id);
    }

}
