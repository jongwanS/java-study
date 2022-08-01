package javainaction.ch5;

import javainaction.ch3.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CH5TEST {
    public static void main(String[] args) {
        /**
         ***** 스트림 *****
         * 필터링
         * takeWhile
         * dropWhile
         * limit
         * skip
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
        //필터링
        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian).collect(toList());
        for(Dish d : vegetarianDishes){
            System.out.println(d.getName());
        }

        //고유요소 필터링 distinct.. 객체 hashcode, equals 새로 정의한거에따라 다름.
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(integer -> integer%2==0)
                .distinct()
                .forEach(System.out::println);

        /**===========================================================**/

        List<Dish> specialMenu = Arrays.asList(
                new Dish("pork",false,100, Dish.Type.MEAT),
                new Dish("beef",false,200, Dish.Type.MEAT),
                new Dish("chiken",false,300, Dish.Type.MEAT),
                new Dish("french fries",true,430, Dish.Type.OTHER),
                new Dish("rice",true,650, Dish.Type.OTHER),
                new Dish("pizza",true,750, Dish.Type.OTHER),
                new Dish("salmon",true,850, Dish.Type.FISH)
        );
        //칼로리가 정렬되어있는다는 가정하에 takeWhile 쓰면 해당 조건 이상인것이 나오면 멈춤
        List<Dish> filteredMenu = specialMenu.stream()
                .takeWhile(Dish -> Dish.getCalories() <= 300)
                .collect(toList());
        //filteredMenu : pork, beef, chiken


        //칼로리가 정렬되어있는다는 가정하에 dropWhile 쓰면 처음 프리케이트가 거짓이되면 남은요소를 버린다
        List<Dish> filteredMenuDrop = specialMenu.stream()
                .dropWhile(Dish -> Dish.getCalories() <= 300)
                .collect(toList());
        //filteredMenuDrop: french fries, rice, pizza, salmon


        //스트림 축소
        List<Dish> dishes = specialMenu.stream().filter(dish -> dish.getCalories() > 300).limit(3).collect(toList());
        //dishes :  french fries, rice, pizza

        //건너뛰기 : 칼로리 300이상인것 필터, 앞에나온 2개 건너뛴다.
        List<Dish> dishSkips = specialMenu.stream().filter(dish -> dish.getCalories() > 300).skip(2).collect(toList());
        //dishSkips : pizza, salmon

        //quiz : 처음 등장하는 두 고기 요리 필터링
        List<Dish> meats = specialMenu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).limit(2).collect(toList());
        //meats : pork, beef

    }
}
