package com.tyss.assignment.dao;

import java.util.Date;
import java.util.List;

import com.tyss.assignment.dto.QuizQuestions;
import com.tyss.assignment.dto.Register;
import com.tyss.assignment.dto.Results;

interface Quiz {

	abstract Register login(String username, String Password);

	abstract Register register(Register register);

	abstract QuizQuestions questions(int id);

	abstract void results(Results results);

	abstract Results getResults(Date date);

	abstract List<Results> getAllResults();

}
