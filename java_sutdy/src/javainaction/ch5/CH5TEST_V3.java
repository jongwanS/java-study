package javainaction.ch5;

import javainaction.ch3.Dish;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class CH5TEST_V3 {
    public static void main(String[] args) {
        /**
         ***** 스트림 *****
         * anyMatch 하나라도 있는지 여부 판단
         * allMatch 모두 일치하는지 여부 판단
         * reduce : 연산을 하여 최종 연산을 도출
         */

        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chiken",false,400, Dish.Type.MEAT),
                new Dish("french fries",true,530, Dish.Type.OTHER),
                new Dish("rice",true,350, Dish.Type.OTHER),
                new Dish("season fruit",true,120, Dish.Type.OTHER),
                new Dish("season fruit",true,120, Dish.Type.OTHER),
                new Dish("pizza",true,550, Dish.Type.OTHER),
                new Dish("parawns",false,300, Dish.Type.FISH),
                new Dish("salmon",true,450, Dish.Type.FISH)
        );
        //anyMatch 하나라도 일치하는지 확인
        boolean anyMatch = menu.stream().anyMatch(Dish::isVegetarian);
        System.out.println(anyMatch);

        //allMatch 모두 일치하는지 여부 판단
        boolean allMatch = menu.stream().allMatch(Dish::isVegetarian);
        System.out.println(allMatch);

        //nonMatch 하나도 일치 안하는지 확인, 하나도 일치하지 않으면 true
        boolean nonMatch = menu.stream().noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println(nonMatch);

        //null을 회피하기위한 optional
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();

        menu.stream().filter(Dish::isVegetarian)
                .findAny()//optional 리턴
                .ifPresent(d-> System.out.println(d.getName()));

        //리듀싱 연산 : 단계적으로 스트림연산을 진행함, 초기값 0, 초기값+1, 초기값+1+2 ...
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        int sum = nums.stream().reduce(0,(a,b)-> {
                                    System.out.println(a+b);
                                    return a+b;
                                    });
        sum = nums.stream().reduce(0,Integer::sum);
        System.out.println(sum);

        //요리 개수 구하기
        int mealCnt = menu.stream().map(d -> d.getName()).distinct().map(d-> 1).reduce(0,(a,b)->a+b);
        System.out.println(mealCnt);

    }
}
