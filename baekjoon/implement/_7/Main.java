package baekjoon.implement._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 문제: 백준 20546번. 기적의 매매법
 * 링크: https://www.acmicpc.net/problem/20546
 * 문제 요약
 * BNP 방법: 주식을 살 수 있다면, 곧 바로 매수 후 마지막에 매도
 * TIMING 방법: 3일 연속 하락 시  매수, 3일 연속 상승 시 매도
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        List<Integer> stocks = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Person joon = new Person("준현", money, 0);
        Person sung = new Person("성민", money, 0);

        int BNP = 0;
        int TIMING = 0;

        int preStock = stocks.get(0);
        int upDownCount = 0;
        for(Integer stock : stocks) {
            upDownCount = upDownUpdate(preStock, stock, upDownCount);

            if(joon.money/stock > 0) joon.buyStock(stock);
            if(upDownCount <= -3) sung.buyStock(stock);
            if(upDownCount == 3 && sung.stockCount != 0) TIMING = sung.sellStock(stock);

            preStock = stock;
        }

        if(TIMING == 0) TIMING = sung.sellStock(stocks.get(stocks.size() - 1));
        BNP = joon.sellStock(stocks.get(stocks.size() - 1));

        if(BNP > TIMING) System.out.println("BNP");
        if(BNP == TIMING) System.out.println("SAMESAME");
        if(BNP < TIMING) System.out.println("TIMING");

    }

    private static int upDownUpdate(int preStock, int stock, int upDownCount) {
        if(stock > preStock) {
            if(upDownCount > 0 || upDownCount == 0) upDownCount++;
            else if(upDownCount < 0) upDownCount = 1;
        }
        if(stock < preStock) {
            if(upDownCount > 0) upDownCount = -1;
            else if(upDownCount < 0 || upDownCount == 0) upDownCount--;
        }
        return upDownCount;
    }

}

class Person {
    String name;
    int money;
    int stockCount;
    public Person(String name, int money, int stockCount) {
        this.name = name;
        this.money = money;
        this.stockCount = stockCount;
    }

    public void buyStock(int stock) {
        this.stockCount += this.money / stock;
        this.money = this.money % stock;
    }

    public int sellStock(int stock) {
        return this.money + (this.stockCount*stock);
    }
}