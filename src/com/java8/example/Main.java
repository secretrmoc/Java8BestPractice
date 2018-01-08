package com.java8.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	List<Question> questions = new ArrayList<Question>();

	public Main() {
		questions.add(new Question(1l, "Question 1", QuestionType.EASY));
		questions.add(new Question(4l, "Question 4", QuestionType.DIFFICULT));
		questions.add(new Question(5l, "Question 5", QuestionType.DIFFICULT));
		questions.add(new Question(2l, "Question 2", QuestionType.EASY));
		questions.add(new Question(3l, "Question 3", QuestionType.DIFFICULT));
		questions.add(new Question(6l, "Question 6", QuestionType.DIFFICULT));
	}

	// Group Questions By Question Types
	private void groupQuestionsByQuestionTypes() {
		Map<QuestionType, List<Question>> records = questions.stream()
				.collect(Collectors.groupingBy(Question::getQuestionType));
		System.out.println(records);
	}

	// Show Questions Where Id>3
	private void showQuestionsWhereIdGt3() {
		List<Question> records = questions.stream().filter(e -> e.getId() > 3).collect(Collectors.toList());
		System.out.println(records);
	}

	// Retreive Only Question Texts
	private void retreiveOnlyQuestionTexts() {
		List<String> records = questions.stream().map(e -> e.getText()).collect(Collectors.toList());
		System.out.println(records);
	}

	// Sort Questions By Id
	private void sortQuestionsById() {
		List<Question> records = questions.stream().sorted(Comparator.comparing(Question::getId))
				.collect(Collectors.toList());
		System.out.println(records);
	}

	//Remove All Difficult Questions
	private void removeAllDifficultQuestions() {
		questions.removeIf(e -> e.getQuestionType() == QuestionType.DIFFICULT);
		System.out.println("No of remaining questions :" + questions.size());
	}

	public static void main(String args[]) {
		Main obj = new Main();
		obj.groupQuestionsByQuestionTypes();
		obj.showQuestionsWhereIdGt3();
		obj.retreiveOnlyQuestionTexts();
		obj.sortQuestionsById();
		obj.removeAllDifficultQuestions();
	}
}
