package javainaction.ch5;

import javainaction.ch3.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CH5TEST_V2 {
    public static void main(String[] args) {
        /**
         ***** 스트림 *****
         * map : 데이터를 변환한다는 의미
         * Arrays.stream
         * flatMap
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

        //map:데이터 변환의 의미, name은 string
        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
        System.out.println(dishNames);
        //pork, beef, chiken, french fries, rice, season fruit, season fruit, pizza, parawns, salmon

        //Dish 객체 name (string) 변경후, 다시 문자열 length로 변환
        List<Integer> dishNameLenth = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(dishNameLenth);
        /*************************************************************************/

        List<String> words = Arrays.asList("Modern","Java","In","Action");
        //map : length 이므로 integer
        List<Integer> wordLength = words.stream().map(String::length).collect(toList());
        System.out.println(wordLength);
        //6,4,2,6

        //String 배열로 중복문자열을 삭제하고 저장하라
        List<String> helloWolrd = Arrays.asList("hello","world");
        List<String[]> chArr = helloWolrd.stream().map(str -> str.split("")).distinct().collect(toList());
        System.out.println(chArr);

        //flatMap
        //map > List<Stinrg[]> 형태로 바꿈
        //flatMap 이 List<String> 형태로 바꿔준다.
        List<String> helloWords = Arrays.asList("Hello","World");
        List<String> uniqueCharacters = helloWords.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct().collect(toList());
        System.out.println(uniqueCharacters);
    }
}
