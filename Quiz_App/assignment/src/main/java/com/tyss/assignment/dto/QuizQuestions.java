package com.tyss.assignment.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class QuizQuestions implements Serializable {

	@Id
	@Column
	private int id;
	@Column
	private String question1;
	@Column
	private String question2;
	@Column
	private String question3;
	@Column
	private String question4;
	@Column
	private String question5;
	@Column
	private String question5answerString;
	@Column
	private String question4answerString;
	@Column
	private String question3answerString;
	@Column
	private String question2answerString;
	@Column
	private String question1answerString;

}
