package inflearn.ch9_Greedy._1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 9-1. 씨름 선수
class Person implements Comparable<Person>{
    int height;
    int weight;
    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person o) {
        if(this.height > o.height) {
            return 1;
        }

        if(this.height == o.height) {
            return 0;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class Main {


    public int solution(Person[] people) {
        int answer = 0;
        Arrays.sort(people, Comparator.reverseOrder());

        int maxHeight = Integer.MIN_VALUE;
        int maxWeight = Integer.MIN_VALUE;

        for (Person person : people) {
            if(person.height > maxHeight || person.weight > maxWeight) {
                maxHeight = Math.max(person.height, maxHeight);
                maxWeight = Math.max(person.weight, maxWeight);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(sc.nextInt(), sc.nextInt());
        }

        System.out.println(T.solution(people));

    }
}
