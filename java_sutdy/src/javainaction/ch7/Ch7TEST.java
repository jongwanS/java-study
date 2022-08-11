package javainaction.ch7;

import java.util.stream.Stream;

public class Ch7TEST {
    public static void main(String[] args) {

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        long a = streamSum(50000000);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

        beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        long b = parallelSum(50000000);
        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);


    }
    public static void printBenchMark(){

    }

    public static long streamSum(long n){
        return Stream.iterate(1L,i->i+1).limit(n).reduce(0L, Long::sum);
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1).limit(n).parallel().reduce(0L, Long::sum);
    }

}
