package javainaction.ch6;

import javainaction.ch3.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Ch6Test {

    public static void main(String[] args) {

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

        long howManyDishes = menu.stream().collect(Collectors.counting());
        howManyDishes = menu.stream().count();
        System.out.println(howManyDishes);

        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics meIntSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(meIntSummaryStatistics);

        String menuName = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(menuName);
        menuName = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(menuName);

        Map<Dish.Type, List<Dish>> dishsByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishsByType);

        //서브그룹에서 가장 칼로리가 높은요리 찾기
        Map<Dish.Type,Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType, //분류
                                    collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                                            Optional::get)));
        System.out.println(mostCaloricByType);

        //파티션화
        Map<Boolean,List<Dish>> partitionMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionMenu);

    }

}
