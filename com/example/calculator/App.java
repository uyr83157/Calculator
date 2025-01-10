package com.example.calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반복 확인 변수
        boolean operationBreak = false;

        // 반복
        while (!operationBreak) {

            // 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            Integer number1 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            Integer number2 = sc.nextInt();

            // 예외 처리
            boolean error = false;


            // 연산
            int result = 0;
            double result2 = 0.0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        error = true;
                        break;
                    } else {
                        result2 = (double)number1 / number2;
                        break;
                    }
                default:
                    System.out.println("연산 기호 오류 입니다");
                    error = true;
            }

            // 출력
            if (error) {
                System.out.println("연산에 오류가 발생했습니다");
            } else if (operator == '/'){
                System.out.println("결과: " + number1 + " " + operator + " " + number2 + " = " + result2);
            } else {
                System.out.println("결과: " + number1 + " " + operator + " " + number2 + " = " + result);
            }

            // 반복 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {
                operationBreak = true;
            }
        }
    }
}