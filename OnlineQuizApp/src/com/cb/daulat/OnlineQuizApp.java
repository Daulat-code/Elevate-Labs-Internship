package com.cb.daulat;

public class OnlineQuizApp {

	public static void main(String[] args) {
		
		QuizeServiceImp quiz = new QuizeServiceImp();

        quiz.addQuestion(new Question(
            "Which is the capital of India?",
            new String[]{"A. Mumbai", "B. New Delhi", "C. Kolkata", "D. Chennai"},
            'B'
        ));

        quiz.addQuestion(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
            'B'
        ));

        quiz.addQuestion(new Question(
            "Who developed Python programming language?",
            new String[]{"A. James Gosling", "B. Dennis Ritchie", "C. Guido van Rossum", "D. Bjarne Stroustrup"},
            'C'
        ));

        quiz.addQuestion(new Question(
            "Which is the largest ocean in the world?",
            new String[]{"A. Atlantic", "B. Pacific", "C. Indian", "D. Arctic"},
            'B'
        ));

        quiz.start();
    }

	}
