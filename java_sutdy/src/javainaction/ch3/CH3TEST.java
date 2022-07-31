package javainaction.ch3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CH3TEST {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork",false,800,Dish.Type.MEAT),
            new Dish("beef",false,700,Dish.Type.MEAT),
            new Dish("chiken",false,400,Dish.Type.MEAT),
            new Dish("french fries",true,530,Dish.Type.OTHER),
            new Dish("rice",true,350,Dish.Type.OTHER),
            new Dish("season fruit",true,120,Dish.Type.OTHER),
                new Dish("season fruit",true,120,Dish.Type.OTHER),
            new Dish("pizza",true,550,Dish.Type.OTHER),
            new Dish("parawns",false,300,Dish.Type.FISH),
            new Dish("salmon",true,450,Dish.Type.FISH)
        );
        List<String> threeHighCaloricDishNames = menu.stream()
                                                    .filter(dish -> dish.getCalories() < 310)
                                                    .map(Dish::getName)
                                                    .limit(3)
                                                    .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        List<String> heightCalories = menu.stream()
                                        .filter(dish -> dish.getCalories() > 300)
                                        .map(Dish::getName)
                                        .collect(toList());
        System.out.println(heightCalories);

        List<String> names = menu.stream().filter(dish -> {
                                            System.out.println("filtering : " + dish.getName());
                                            return dish.getCalories() > 300;
                                        }).map(dish -> {
                                            System.out.println("mapping : " + dish.getName());
                                            return dish.getName();
                                        }).limit(3).collect(toList());

        long count = menu.stream().filter(dish -> dish.getCalories() < 150).distinct().limit(8).count();
        System.out.println(count);
    }
}
