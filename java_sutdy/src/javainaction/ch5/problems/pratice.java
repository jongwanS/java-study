package javainaction.ch5.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class pratice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //2011 에 일어난 트랜잭션 오름차순 정렬!
        List<Transaction> yearTx = transactions.stream().filter(t->t.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());
        System.out.println("=====================");
        yearTx.forEach(System.out::println);

        //거래자가 근무하는 모든도시 중복없이 나열
        List<String> uniqueCity = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());
        System.out.println("=====================");
        uniqueCity.forEach(System.out::println);

        //캠브리지에 근무하는 거래자 이름순 정렬
        List<Trader> cambTrader = transactions.stream().map(Transaction->Transaction.getTrader())
                .filter(Trader->Trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println("=====================");
        cambTrader.forEach(System.out::println);
        /**
         collect() can only work with mutable result objects.
         reduce() is designed to work with immutable result objects.
         */
        //모든 거래자 이름 알파벳순 정렬 - bad(새로운 문자열 객체를 만듬)
        String tradeStr = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()).distinct()
                .sorted().reduce("",(n1,n2)->n1+n2);
        System.out.println(tradeStr);

        String tradeStrBuffer = transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(tradeStrBuffer);

        //밀라노 거래자가 있는가??
        boolean milanManExist = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanManExist);

        //켐브리지 거주 거래자 모든 트랜잭션값 출력
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getName()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //전체트랜잭션 최대값
        Optional<Integer> high = transactions.stream().map(Transaction::getYear).reduce(Integer::max);
        System.out.println(high.get());
        //전체트랜잭션 최소값
        Optional<Integer> low = transactions.stream().map(Transaction::getYear).reduce(Integer::min);
        System.out.println(low.get());
    }
}
