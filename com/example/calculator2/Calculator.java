package com.example.calculator2;

import java.util.ArrayList;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    // 컬렉션 ArrayList 선언 및 생성 (+캡슐화)
    private final ArrayList<Double> resultList = new ArrayList<>();

    // 생성자 (기본형이라 생략 가능)
//    public Calculator() {
//    }

    // 연산 메서드
    public double calculate(int number1, int number2, char operator) {
        /* 위 요구사항에 맞게 구현 */
        // 연산
        boolean error = false;
        double result = 0.0;

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
                } else {
                    result = (double) number1 / number2;
                }
                break;
            default:
                System.out.println("연산 기호 오류 입니다");
                error = true;
        }

        // 예외 처리 및 결과값 출력
        if (error) {
            System.out.println("연산에 오류가 발생했습니다");
        } else {
            System.out.println("결과: " + number1 + " " + operator + " " + number2 + " = " + result);

        }

        // ArrayList 컬렉션에 결과값 저장
        resultList.add(result);
        System.out.println("결과 목록 = " + resultList);

        /* return 연산 결과 */
        // 결과값 반환
        return result;
    }

    // Getter 메서드
    public ArrayList<Double> getResultList() {
        return resultList;
    }

    // Setter 메서드

    public void setResultList(int index, double result) {
        try {
            resultList.set(index, result);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 값에 오류가 있습니다.");
        }
    }

    // 컬렉션 첫 번째 데이터 삭제
    public void removeResultList() {
        resultList.remove(0);
    }


}
