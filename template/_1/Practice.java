package template._1;

import java.util.*;

/**
 * Java 자료구조 정리
 */
class Practice {
    public static void main(String[] args) {
        System.out.println("=============== Array Methods ===============");
        array();
        System.out.println();

        System.out.println("=============== List Methods ===============");
        list();
        System.out.println();

        System.out.println("=============== List Methods ===============");
        linkedList();
        System.out.println();

        System.out.println("=============== Queue, Stack Methods ===============");
        deque();
        System.out.println();

        System.out.println("=============== Hashtable Methods ===============");
        hashTable();
        System.out.println();

        System.out.println("=============== Set Methods ===============");
        set();
        System.out.println();

    }

    // array 자료구조
    private static void array() {
        // 선언
        // todo. 10칸짜리 int array
        // todo. 5칸짜리 String array
//        System.out.println(Arrays.toString(intArray));
//        System.out.println(Arrays.toString(stringArray));

        // char 배열 초기값 설정
        // todo. new 방식
        // todo. 중괄호 방식
//        System.out.println("charArray1: " + Arrays.toString(charArray1));
//        System.out.println("charArray2 : " + Arrays.toString(charArray2));

        // 배열 초기화
        int[] arr1 = { 1, 2, 3, 4, 5 };
        // todo. 모든 인덱스가 5로 초기화된다
//        System.out.println("arr1 : " + Arrays.toString(arr1));

        // 메소드
        // todo. arr1 1번째 원소 접근하기
        // todo. arr1 마지막 원소 접근하기
        // todo. arr1 1번째 원소 수정하기
//        System.out.println("num1 : " + num1);
//        System.out.println("num2 : " + num2);

        // 1차원 배열 복사
        int[] arr2 = { 1, 2, 3, 4, 5 };
        // todo. arr2 전체 복사
        // todo. arr2 2번 인덱스부터 5번 인덱스 이전까지 복사한다.
//        System.out.println("copy2 : " + Arrays.toString(copy2));
//        System.out.println("copyRange : " + Arrays.toString(copyRange));

        // 2차원 배열 복사(내부 배열까지 deep copy 필)
        int[][] arr3 = {{1,2,3}, {4,5,6}, {7,8,9}};
        // todo. arr3 복사
//        System.out.println("copy3 : " + Arrays.deepToString(copy3));
    }


    // list 자료구조
    private static void list() {
        // 1차원 리스트 선언
        // todo. 정수 리스트
        // todo. 정수 리스트 1,2,3 초기화 선언
//        System.out.println("list1: " + list1);
//        System.out.println("list2: " + list2);

        // todo. 1~100 까지 10개 단위 2차원 리스트 선언
//        System.out.println("doubleList1: " + doubleList1);

        // 메소드
        // todo. list2 마지막에 원소 추가 O(1)
        // todo. list1 2번 인덱스에 원소 추가 O(n)
        // todo. 1번째 원소 3으로 수정하기

        // todo. 1번째 원소 접근하기
        // todo. 마지막 원소 삭제 O(1)
        // todo. 2번째 원소 삭제하고 리턴 O(n)

        // 1차원 리스트 복제
        // todo. 선언과 동시에 복제
        // todo. 복제된 sourceList 복제
//        System.out.println("sourceList: " + sourceList);
//        System.out.println("destList: " + destList);

        // 2차원 리스트 복제
        // todo. doubleList1 copyList에 복제
//        System.out.println("copyList: " + copyList);
    }


    /**
     * ArrayDeque - queue, stack
     */
    private static void deque() {
        // Deque 인터페이스로 선언하여 유연성을 높입니다.
        // todo. 데큐 선언

        // ### 1. 큐(Queue)처럼 사용하기 (선입선출: FIFO) ###
        System.out.println("--- 1. Queue 예시 ---");

        // [방법] 뒤로 넣고(offerLast), 앞으로 뺀다(pollFirst).
        // todo. 큐 비었는지 체크
//        System.out.println("큐가 비었나요? " + queueCheck); // true

        // 데이터 추가
        // todo. 큐에 10 추가
        // todo. 큐에 20 추가
        // todo. 큐에 30 추가
        // todo. 큐 사이즈 조회
//        System.out.println("현재 큐 상태: " + deque + ", 크기: " + queueSize);

        // 데이터 확인 (제거하지 않음)
        // todo. 가장 먼저 나올 데이터 확인 원소 탐색
//        System.out.println("가장 먼저 나올 데이터 확인: " + num1);

        // 데이터 꺼내기
        // todo. 데이터 꺼내기 3번
//        System.out.println("데이터 꺼내기: " + num2);
//        System.out.println("데이터 꺼내기: " + num3);
//        System.out.println("데이터 꺼내기: " + num4);

        // 비어있는 큐에서 꺼내기
//        System.out.println("빈 스택에서 데이터 꺼내기: " + num5); // 예외 없이 null 반환

        System.out.println("\n========================================\n");

        // ### 2. 스택(Stack)처럼 사용하기 (후입선출: LIFO) ###
        System.out.println("--- 2. Stack 예시 ---");

        // [방법] 앞으로 넣고(offerFirst), 앞으로 뺀다(pollFirst).
        // 데이터 추가 (Push)
        // todo. 스택에 100 push
        // todo. 스택에 200 push
        // todo. 스택에 300 push
        // todo. 스택 사이즈 조회
//        System.out.println("현재 스택 상태: " + deque + ", 크기: " + stackSize);

        // 데이터 확인 (제거하지 않음)
        // todo. 가장 나중에 들어온 데이터 확인 탐색
//        System.out.println("가장 나중에 들어온 데이터 확인(peekFirst): " + num6);

        // 데이터 꺼내기 (Pop)
        // todo. 데이터 꺼내기 3번
//        System.out.println("데이터 꺼내기: " + num7);
//        System.out.println("데이터 꺼내기: " + num8);
//        System.out.println("데이터 꺼내기: " + num9);

        // 비어있는 스택에서 꺼내기
//        System.out.println("빈 스택에서 데이터 꺼내기: " + num10); // 예외 없이 null 반환
    }


    /**
     * hashTable
     *  단일값이 아닌 여러 값을 조합(클래스)을 추가해야하는 경우, equals()와 hashCode() 메소드 오버라이드 필요
     *  -> 해시맵, 해시셋에서 key로 사용할 클래스는 equals()와 hashCode() 메소드 구현 필요(자료 참고)
     */
    private static void hashTable() {
        // 선언
        // todo. hashtable1 빈 해시테이블 선언
        // todo. hashtable2 선언과 동시에 초기화 - (a, 1), (b, 2)


        // 메소드
        // todo. hashtable2에 key-value 쌍 추가하기
        // todo. hashtable2 key에 해당하는 value 접근하기
        // todo. hashtable2 key에 해당하는 value 수정하기
        // todo. hashtable2에 key-value 쌍 제거
        // todo. 해당 key가 존재하는지 확인
    }


    /**
     * set
     *  단일값이 아닌 여러 값을 조합(클래스)을 추가해야하는 경우, equals()와 hashCode() 메소드 오버라이드 필요
     *  -> 해시맵, 해시셋에서 key로 사용할 클래스는 equals()와 hashCode() 메소드 구현 필요(자료 참고)
     */
    private static void set() {
        // 선언
        // todo. hashset1 빈 해시셋 선언
        // todo. hashset2 값 초기화 선언 - a, b

        // 메소드
        // todo. hashset2에 값 추가
        // todo. hashset2에 값 삭제
        // todo. hashset2에 값 존재하는지 확인
    }

    /**
     * linked list
     * 실제 코테에선 ArrayDeque로 대체(캐시 친화적, GC 부담 낮은, 성능 최적화 이슈 등으로)
     */
    private static void linkedList() {
        // 선언
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>(List.of(1, 2, 3, 4));

        // 메소드
        list2.addLast(5);
        list2.addFirst(0);
        System.out.println("list2 after add: " + list2);
        list2.removeLast();
        list2.removeFirst();
        System.out.println("list2 after remove last: " + list2);
    }


}
