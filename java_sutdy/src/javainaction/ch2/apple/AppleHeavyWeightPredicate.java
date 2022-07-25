package javainaction.ch2.apple;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean decideStrategy(Apple apple) {
        return apple.getWeight() > 150;
    }
}
