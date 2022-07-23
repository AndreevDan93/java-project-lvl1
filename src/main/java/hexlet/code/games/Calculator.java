package hexlet.code.games;

import hexlet.code.Engine;


public class Calculator {
    public static void game() {
        Engine.greeting();
        System.out.println("What is the result of the expression?");
        boolean isWin = true;
        for (int i = 0; i < Engine.getCountOfRounds(); i++) {

            String randomExpression = getRandomExpression();
            System.out.println("Question: " + randomExpression);
            int answer = Engine.getScanner().nextInt();
            int correctAnswer = getResultOfRandomExpression(randomExpression);
            if (answer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'\n", answer, correctAnswer);
                System.out.println("Let's try again, " + Engine.getPlayerName() + "!");
                isWin = false;
                break;
            }
        }
        if (isWin) {
            System.out.printf("Congratulations, %s \n", Engine.getPlayerName());
        }
    }

    public static String getRandomExpression() {
        int num1 = Engine.getRandomNum(Engine.getRandomRange());
        int num2 = Engine.getRandomNum(Engine.getRandomRange());
        String operation = Engine.getRandomOperation();
        return num1 + " " + operation + " " + num2;

    }

    public static int getResultOfRandomExpression(String randomExpression) {
        String[] expression = randomExpression.split(" ");

        return switch (expression[1]) {
            case "+" -> Integer.parseInt(expression[0]) + Integer.parseInt(expression[2]);
            case "-" -> Integer.parseInt(expression[0]) - Integer.parseInt(expression[2]);
            case "*" -> Integer.parseInt(expression[0]) * Integer.parseInt(expression[2]);
            default -> 0;
        };
    }


}
