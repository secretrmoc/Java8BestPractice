package com.java8.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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

	// Remove All Difficult Questions
	private void removeAllDifficultQuestions() {
		questions.removeIf(e -> e.getQuestionType() == QuestionType.DIFFICULT);
		System.out.println("No of remaining questions :" + questions.size());
	}

	// ListToMapConversion
	private void listToMapConversion() {
		System.out.println(questions.stream().collect(Collectors.toMap(Question::getId, Function.identity())));
	}

	// StreamToArrayConversion
	private void streamToArrayConversion() {
		Stream<String> strStream = Stream.of("A", "B", "C", "D");
		String[] data = strStream.toArray(size -> new String[size]);
		System.out.println("Array's size and first Element-> " + data.length + " : " + data[0]);
	}

	// IterableToStreamConversion
	private void iterableToStreamConversion() {
		Iterable<Question> iterableData = questions;
		StreamSupport.stream(iterableData.spliterator(), false).forEach(System.out::println);
	}

	// StreamToIterableConversion
	private void streamToIterableConversion() {
		Stream<String> strStream = Stream.of("A", "B", "C", "D");
		Iterable<String> strIterable = strStream::iterator;
		for (String str : strIterable) {
			System.out.println(str);
		}
	}

	// GetFirstItem
	private void getFirstItem() {
		System.out.println(
				questions.stream().filter(e -> e.getQuestionType() == QuestionType.DIFFICULT).findFirst().get());
	}

	// GetSumOfAllIds
	private void getSumOfAllIds() {
		System.out.println(questions.stream().mapToLong(Question::getId).sum());
		//OR
		long result=questions.stream().collect(Collectors.summingLong(Question::getId));
		System.out.println(result);
	}

	public static void main(String args[]) {
		Main obj = new Main();
		obj.groupQuestionsByQuestionTypes();
		obj.showQuestionsWhereIdGt3();
		obj.retreiveOnlyQuestionTexts();
		obj.sortQuestionsById();
		obj.listToMapConversion();
		obj.streamToArrayConversion();
		obj.iterableToStreamConversion();
		obj.getFirstItem();
		obj.streamToIterableConversion();
		obj.getSumOfAllIds();
		obj.removeAllDifficultQuestions();

	}
}
