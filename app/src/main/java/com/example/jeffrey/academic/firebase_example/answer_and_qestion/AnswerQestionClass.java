package com.example.jeffrey.academic.firebase_example.answer_and_qestion;

public class AnswerQestionClass {
    private String answer;
    private String qestion;
    private boolean answered;

    public AnswerQestionClass(String answer, String qestion,boolean answered) {
        this.answer = answer;
        this.qestion = qestion;
        this.answered=answered;
    }

    public AnswerQestionClass() {
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQestion() {
        return qestion;
    }

    public void setQestion(String qestion) {
        this.qestion = qestion;
    }
}
