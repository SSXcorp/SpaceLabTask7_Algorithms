package Task4;

import java.util.Scanner;

import static Task4.BracketChecker.checkBrackets;
import static Task4.BracketChecker.isValid;

public class Main {
    public static void main(String[] args) {

        //using checker
        Scanner scanner = new Scanner(System.in);


            System.out.print("Введите уравнение: ");
            String expression = scanner.nextLine();

            if (checkBrackets(expression)) {
                System.out.println("Скобки расставлены правильно.");
            } else {
                System.out.println("Ошибка в расстановке скобок.");
            }

        //using stack
        System.out.println(isValid(expression));

    }
}
