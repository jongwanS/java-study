package javainaction.ch2.apple;

import static javainaction.ch2.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean decideStrategy(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
