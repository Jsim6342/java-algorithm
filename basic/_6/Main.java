package basic._6;

import java.util.Arrays;

/**
 * 이분탐색
 * 주어진 리스트에서 10 값 인덱스 구하기
 */
class Main {
    static Integer[] array = new Integer[]{1, 3, 3, 4, 5, 7, 9, 10, 11, 13, 13, 16};
    static int target = 10;

    public static void main(String[] args) {

        Arrays.sort(array);

        int lt = 0;
        int rt = array.length;

        while(rt >= lt) {
            int mid = (lt + rt) / 2;
            if(array[mid] > target){
                rt = mid - 1;
            }else if(array[mid] < target) {
                lt = mid + 1;
            }else {
                System.out.println(mid);
                break;
            }
        }

    }
}
