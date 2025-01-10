package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */

    // 컬렉션 ArrayList 선언 및 생성 (+캡슐화)
    private final ArrayList<Double> resultList = new ArrayList<>();

    // Calculator 클래스의 생성자 (기본형이라 생략 가능)
//    public Calculator() {
//    }

    // enum 연산자 모음 (클래스의 일종)
    public enum OperatorType {
        /* 구현 */
        ADD('+'),
        SUBTRACT('-'),
        MULTIPLY('*'),
        DIVIDE('/');

        public final char operator2;

        // OperatorType 생성자
        OperatorType(char operator2) {
            this.operator2 = operator2;
        }

    }

    // enum OperatorType 의 operator2 값과 calculate2의 operator 입력값을 대조해서 매칭시켜주는 메서드
    public static OperatorType matchingOperator(char operator) {
        for (OperatorType finalOperator : OperatorType.values()) {
            if (finalOperator.operator2 == operator) {
                return finalOperator;
            }
        }
        throw new IllegalArgumentException("연산 기호 오류 입니다");
    }

    // ArithmeticCalculator 클래스
    public class ArithmeticCalculator /* Hint */ {
        /* 수정 */

        // ArithmeticCalculator 클래스의 연산메서드2
        public <T extends Double> double calculate2(T number1, T number2, char operator) {

            double result = 0.0;

            // operator 입력값을 matchingOperator 메서드로 보내서 매칭시킴
            OperatorType operatorType = Calculator.matchingOperator(operator);


            // operator 입력값이 정확하지 않을 때, null 로 반환 후 오류 출력
//            if (operatorType == null) {
//                System.out.println("연산 기호 오류 입니다");
//                return result;
//            }

            // 연산
            switch (operatorType) {
                case ADD:
                    result = number1.doubleValue() + number2.doubleValue();
                    break;
                case SUBTRACT:
                    result = number1.doubleValue() - number2.doubleValue();
                    break;
                case MULTIPLY:
                    result = number1.doubleValue() * number2.doubleValue();
                    break;
                case DIVIDE:
                    if (number2.doubleValue() == 0) {
                        // throw 로 산술 연산 예외 처리 (ArithmeticException)
                        throw new ArithmeticException("0으로 나눌 수 없습니다.");
//                        System.out.println("0으로 나눌 수 없습니다.");
//                        return result;
                    }
                    result = number1.doubleValue() / number2.doubleValue();
                    break;
//                default:
//                    throw new IllegalArgumentException("연산 기호 오류 입니다");
            }


            // ArrayList 컬렉션에 결과값 저장
            resultList.add(result);
            System.out.println("결과 목록 = " + resultList);

            return result;
        }

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

    // 입력값 보다 큰 결과값들 출력 (Lambda & Stream 활용)
    public List<Double> getBigValue(double value) {
        return resultList.stream()
                // filter Lambda 활용
                .filter(result -> result > value)
                .collect(Collectors.toList());
    }

}
