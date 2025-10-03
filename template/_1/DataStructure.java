package template._1;

import java.util.*;

/**
 * Java 자료구조 정리
 */
class DataStructure {
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

        System.out.println("=============== Queue Methods ===============");
        queue();
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
        int[] intArray = new int[10]; // 10칸짜리 int array
        String[] stringArray = new String[5]; // 5칸짜리 String array
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));

        // 초기값 설정
        char[] charArray1 = new char[]{ 'h', 'e', 'l', 'l', 'o' };
        char[] charArray2 = { 'h', 'e', 'l', 'l', 'o' }; // new char[] 생략 가능
        System.out.println("charArray1: " + Arrays.toString(charArray1));
        System.out.println("charArray2 : " + Arrays.toString(charArray2));

        // 배열 초기화
        int[] arr1 = { 1, 2, 3, 4, 5 };
        Arrays.fill(arr1, 5); // 모든 인덱스가 5로 초기화된다
        System.out.println("arr1 : " + Arrays.toString(arr1));

        // 메소드
        int num1 = intArray[1]; // 1번째 원소 접근하기
        int num2 = intArray[intArray.length - 1]; // 마지막 원소 접근
        intArray[1] = 3; // i번째 원소 수정
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);

        // 1차원 배열 복사
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] copy2 = Arrays.copyOf(arr2, arr2.length); // 전체 복사
        int[] copyRange = Arrays.copyOfRange(arr2, 2, 5); // 2번 인덱스부터 5번 인덱스 이전까지 복사한다.
        System.out.println("copy2 : " + Arrays.toString(copy2));
        System.out.println("copyRange : " + Arrays.toString(copyRange));

        // 2차원 배열 복사(내부 배열까지 deep copy 필)
        int[][] arr3 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] copy3 = new int[arr3.length][arr3[0].length];


        for (int i = 0; i < arr3.length; i++) {
            copy3[i] = Arrays.copyOf(arr3[i], arr3[0].length);
        }
        System.out.println("copy3 : " + Arrays.deepToString(copy3));
    }


    // list 자료구조
    private static void list() {
        // 1차원 리스트 선언
        List<Integer> list1 = new ArrayList<>(); // 정수 리스트
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3)); // 초기화 선언
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        // 2차원 리스트 선언
        List<List<Integer>> doubleList1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<Integer> newRow = new ArrayList<>(); // 새 열을 추가
            for (int j = 1; j <= 10; j++) {
                newRow.add(i * 10 + j);
            }
            doubleList1.add(newRow);
        }
        System.out.println("doubleList1: " + doubleList1);

        // 메소드
        list1.add(1); // 마지막에 원소 추가 O(1)
        list1.add(2); // 마지막에 원소 추가 O(1)
        list1.add(3); // 마지막에 원소 추가 O(1)
        list1.add(2, 10); // 중간에 원소 추가 O(n)
        list1.set(1, 3); // 1번째 원소 3으로 수정하기

        list1.get(1); // 1번째 원소 접근하기
        list1.remove(list1.size() - 1); // 마지막 원소 삭제 O(1)
        list1.remove(2); // 중간 원소 삭제 O(n)
        list1.remove(Integer.valueOf(2)); // 2번째 index에 있는 값을 삭제하고 리턴

        // 1차원 리스트 복제
        List<Integer> sourceList = new ArrayList<>(List.of(1, 3, 2, 5, 4));
        List<Integer> destList = new ArrayList<>(sourceList);
        System.out.println("sourceList: " + sourceList);
        System.out.println("destList: " + destList);

        // 2차원 리스트 복제
        // .. doubleList 초기화
        List<List<Integer>> copyList = new ArrayList<>();
        for (List<Integer> row : doubleList1) {
            copyList.add(new ArrayList<>(row));
        }
        System.out.println("copyList: " + copyList);
    }


    /**
     * ArrayDeque - queue, stack
     * 코테에서 큐는 주로 BFS 구현, 투 포인터 사용, 시뮬레이션 및 구현 문제 등에서 활용
     * 코테에서 스택은 주로 짝 맞추기(괄호 쌍, 동일 블록 제거), 재귀 등에서 활용
     *
     * 맨 앞에 추가	offerFirst(E e)	스택의 push 역할
     * 맨 뒤에 추가	offerLast(E e)	큐의 offer 역할
     * 맨 앞 제거 & 확인	pollFirst()	스택의 pop, 큐의 poll 역할
     * 맨 뒤 제거 & 확인	pollLast()	(덱 고유 기능)
     * 맨 앞 확인 (제거X)	peekFirst()	스택/큐의 peek 역할
     * 맨 뒤 확인 (제거X)	peekLast()	(덱 고유 기능)
     *
     * 상태 확인	isEmpty()	덱이 비어있는지 확인 (true/false)
     * 크기 확인	size()	덱에 들어있는 요소의 개수 확인
     *
     * 큐로 사용할 때: offerLast(), pollFirst(), peekFirst()
     * 스택으로 사용할 때: offerFirst(), pollFirst(), peekFirst()
     */
    private static void queue() {
        // Deque 인터페이스로 선언하여 유연성을 높입니다.
        Deque<Integer> deque = new ArrayDeque<>();

        // ### 1. 큐(Queue)처럼 사용하기 (선입선출: FIFO) ###
        System.out.println("--- 1. Queue 예시 ---");

        // [방법] 뒤로 넣고(offerLast), 앞으로 뺀다(pollFirst).
        System.out.println("큐가 비었나요? " + deque.isEmpty()); // true

        // 데이터 추가
        deque.offerLast(10); // 큐에 10 추가
        deque.offerLast(20); // 큐에 20 추가
        deque.offerLast(30); // 큐에 30 추가
        System.out.println("현재 큐 상태: " + deque + ", 크기: " + deque.size());

        // 데이터 확인 (제거하지 않음)
        System.out.println("가장 먼저 나올 데이터 확인(peekFirst): " + deque.peekFirst());

        // 데이터 꺼내기
        System.out.println("데이터 꺼내기(pollFirst): " + deque.pollFirst());
        System.out.println("데이터 꺼낸 후 큐 상태: " + deque);

        System.out.println("데이터 꺼내기(pollFirst): " + deque.pollFirst());
        System.out.println("데이터 꺼내기(pollFirst): " + deque.pollFirst());

        // 비어있는 큐에서 꺼내기
        System.out.println("큐가 비었나요? " + deque.isEmpty()); // true
        System.out.println("빈 큐에서 데이터 꺼내기(pollFirst): " + deque.pollFirst()); // 예외 없이 null 반환

        System.out.println("\n========================================\n");

        // ### 2. 스택(Stack)처럼 사용하기 (후입선출: LIFO) ###
        System.out.println("--- 2. Stack 예시 ---");

        // [방법] 앞으로 넣고(offerFirst), 앞으로 뺀다(pollFirst).
        // 데이터 추가 (Push)
        deque.offerFirst(100); // 스택에 100 push
        deque.offerFirst(200); // 스택에 200 push
        deque.offerFirst(300); // 스택에 300 push
        System.out.println("현재 스택 상태: " + deque + ", 크기: " + deque.size());

        // 데이터 확인 (제거하지 않음)
        System.out.println("가장 나중에 들어온 데이터 확인(peekFirst): " + deque.peekFirst());

        // 데이터 꺼내기 (Pop)
        System.out.println("데이터 꺼내기(pollFirst): " + deque.pollFirst());
        System.out.println("데이터 꺼낸 후 스택 상태: " + deque);

        System.out.println("데이터 꺼내기(pollFirst): " + deque.pollFirst());
        System.out.println("데이터 꺼내기(pollFirst): " + deque.pollFirst());

        // 비어있는 스택에서 꺼내기
        System.out.println("빈 스택에서 데이터 꺼내기(pollFirst): " + deque.pollFirst()); // 예외 없이 null 반환
    }


    /**
     * hashTable
     *  단일값이 아닌 여러 값을 조합(클래스)을 추가해야하는 경우, equals()와 hashCode() 메소드 오버라이드 필요
     *  -> 해시맵, 해시셋에서 key로 사용할 클래스는 equals()와 hashCode() 메소드 구현 필요(자료 참고)
     */
    private static void hashTable() {
        // 선언
        Map<Integer, String> hashtable1 = new HashMap<>();
        Map<Integer, String> hashtable2 = new HashMap<>() {{
            put(2022390, "노정호");
            put(2022392, "배준석");
        }}; // 선언과 동시에 초기화


        // 메소드
        hashtable2.put(2022390, "노정호"); // key-value 쌍 추가하기
        hashtable2.get(2023390); // key에 해당하는 value 접근하기
        hashtable2.replace(2023390, "이승규"); // key에 해당하는 value 수정하기
        hashtable2.remove(2023390); // key-value 쌍 제거

        // 해당 key가 존재하는지 확인 (containsKey() - 시간복잡도 O(1))
        if (hashtable2.containsKey(2023390)) {
            System.out.println(hashtable2.get(2023390)); // 키가 있다면 출력
        } else {
            System.out.println("저장된 키가 없습니다.");
        }
    }


    /**
     * set
     *  단일값이 아닌 여러 값을 조합(클래스)을 추가해야하는 경우, equals()와 hashCode() 메소드 오버라이드 필요
     *  -> 해시맵, 해시셋에서 key로 사용할 클래스는 equals()와 hashCode() 메소드 구현 필요(자료 참고)
     */
    private static void set() {
        // 선언
        Set<String> hashset1 = new HashSet<>();
        Set<String> hashset2 = new HashSet<>() {{
            add("노정호");
            add("배준석");
        }}; // 값 초기화 선언


        // 메소드
        hashset2.add("노정호");
        hashset2.remove(2023390);
        hashset2.contains("노정호"); // true
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
