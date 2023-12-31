package com.example.ramiro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ramiro.model.Question;
import com.example.ramiro.model.QuestionForm;
import com.example.ramiro.model.Result;
import com.example.ramiro.repository.QuestionRepo;
import com.example.ramiro.repository.ResultRepo;

@Service
public class QuizService {

	@Autowired
	QuestionForm qForm;
	@Autowired
	QuestionRepo qRepo;
	@Autowired
	Result result;
	@Autowired
	ResultRepo rRepo;
	
	public QuestionForm getQuestions() {
		List<Question> allQues = qRepo.findAll();
		Collections.shuffle(allQues);

		int numberQuestions = Math.min(allQues.size(),10);
		List<Question> questionsList = new ArrayList<>(allQues.subList(0,numberQuestions));
		qForm.setQuestions(questionsList);
		
		return qForm;
	}
	
	public int getResult(QuestionForm qForm) {
		int correct = 0;
		
		for(Question q: qForm.getQuestions())
			if(q.getAns() == q.getChose())
				correct++;
		
		return correct;
	}
	
	public void saveScore(Result result) {
		Result saveResult = new Result();
		saveResult.setUsername(result.getUsername());
		saveResult.setTotalCorrect(result.getTotalCorrect());
		rRepo.save(saveResult);
	}
	
	public List<Result> getTopScore() {

        return rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));
	}
}
