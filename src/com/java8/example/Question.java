package com.java8.example;

public class Question {

	private Long id;
	private String text;
	private QuestionType questionType;

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(Long id, String text, QuestionType questiontype) {
		this.id = id;
		this.text = text;
		this.questionType = questiontype;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

}
