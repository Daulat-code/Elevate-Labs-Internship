package com.cb.daulat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizeServiceImp implements QuizeService {
	
	private List<Question> questions;
    private int score;

    public QuizeServiceImp() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void start() {
    	
    	 Collections.shuffle(questions);
        Scanner sc = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println("\n" + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = sc.next().charAt(0);

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctAnswer);
            }
        }

        showResult();
        sc.close();
    }

    public void showResult() {
        int total = questions.size();
        double percentage = ((double) score / total) * 100;

        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Score: " + score + "/" + total);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Remarks: " + getRemarks(percentage));
    }

    public String getRemarks(double percentage) {
        if (percentage >= 80) {
            return "Excellent! 🎉";
        } else if (percentage >= 50) {
            return "Good job! 👍";
        } else {
            return "Needs Improvement. 📚";
        }
    }

}
