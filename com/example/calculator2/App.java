package com.example.calculator2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반복 확인 변수
        boolean operationBreak = false;

        // Calculator 객체 생성
        Calculator calculator = new Calculator();

        // 반복
        while (!operationBreak) {

            // 입력
            System.out.print("첫 번째 숫자를 입력하세요: ");
            Integer number1 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.print("두 번째 숫자를 입력하세요: ");
            Integer number2 = sc.nextInt();

            //calculate 메서드 호출 (연산 메서드)
            calculator.calculate(number1, number2, operator);

            //getResultList 메서드 호출 (Getter 메서드)
            System.out.println("Getter 테스트 = " + calculator.getResultList());

            //setResultList 메서드 호출 (Setter 메서드)
            System.out.print("수정한 컬렉션 index를 입력하세요: ");
            Integer index = sc.nextInt();
            System.out.print("수정한 컬렉션 값을 입력하세요: ");
            Integer result = sc.nextInt();
            calculator.setResultList(index, result);
            System.out.println("Setter 후 컬렉션 = " + calculator.getResultList());

            // 컬렉션 첫 번째 데이터 삭제
            System.out.println("첫 번째 데이터를 삭제하시겠습니까? (yes 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("yes")) {
                calculator.removeResultList();
                System.out.println("삭제 후 컬렉션 = " + calculator.getResultList());
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