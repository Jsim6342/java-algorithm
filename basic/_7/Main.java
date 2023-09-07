package basic._7;

/**
 * 투 포인터
 * 주어진 리스트에서 부분합 M을 만족하는 lt ~ rt 지점 카운트
 */
class Main {

    static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int N = array.length;
    static int M = 10;


    public static void main(String[] args) {

        int count = 0;
        int nowSum = 0;
        int rt = 0;

        for (int lt = 0; lt < N; lt++) {
            if(lt != 0) nowSum -= array[lt - 1];

            while(rt < N && (nowSum + array[rt]) <= M) {
                nowSum += array[rt];
                rt += 1;
            }

            if (nowSum == M) count += 1;
        }

        System.out.println(count);

    }
}
