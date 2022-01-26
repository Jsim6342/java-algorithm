package programmers._18;

import java.util.*;

// 수식 최대화(틀린 풀이)
class Main {
    static ArrayList<String> nowOperations = new ArrayList<>();
    static String[] operationTypes = {"-","+","*"};
    static ArrayList<ArrayList<String>> operatorCases = new ArrayList<>();
    static ArrayList<Long> answers = new ArrayList<>();

    public long solution(String expression) {

        Deque<Long> numbers = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();


        String[] splitNums = expression.split("-|\\*|\\+");
        for (String stringNum : splitNums) {
            numbers.add(Long.valueOf(stringNum));
        }
        String[] splitOperators = expression.split("[0-9]");
        for (String operator : splitOperators) {
            operators.add(operator);
        }


        getOperatorCases(0);



        for (ArrayList<String> operatorCase : operatorCases) {
            //solve(operatorCase, numbers, operators);
        }

        for (Long answer : answers) {
            System.out.println(answer);
        }
        return 0L;
    }

    public static void solve(ArrayList<String> operatorCase, Deque<Long> numbers, Deque<String> operators) {
        Deque<Long> nextNumbers = new ArrayDeque<>();
        nextNumbers.add(numbers.pollFirst());

        for (String nowOperator : operatorCase) {
            for (String operator: operators) {
                if(nowOperator == operator) {
                    Long result = calc(nextNumbers.getLast(), numbers.pollFirst(), operator.charAt(0));
                    nextNumbers.add(result);
                }else{
                    nextNumbers.add(numbers.pollFirst());
                }
            }
        }
        answers.add(Math.abs(nextNumbers.getLast()));
    }

    public static Long calc(Long num1, Long num2, char op){
        long num = 0;
        switch (op){
            case '+' : {
                return num1 + num2;
            }
            case '-' : {
                return num1 - num2;
            }
            case '*' : {
                return num1 * num2;
            }
        }
        return num;
    }

    public void getOperatorCases(int level) {
        if(level == operationTypes.length) {
            ArrayList<String> temp = new ArrayList<>();
            for (String nowOperation : nowOperations) {
                temp.add(nowOperation);
            }
            operatorCases.add(temp);
        }else {
            for (String operationType : operationTypes) {
                if(nowOperations.contains(operationType)) continue;
                else {
                    nowOperations.add(operationType);
                    getOperatorCases(level + 1);
                    nowOperations.remove(operationType);
                }
            }
        }
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String expression ="50*6-3*2";

        System.out.println(T.solution(expression));
    }


}
