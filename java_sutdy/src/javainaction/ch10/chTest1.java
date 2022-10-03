package javainaction.ch10;

import static javainaction.ch10.MethodChainingOrderBuilder.forCustomer;

public class chTest1 {
    public static void main(String[] args) {

        Order order = forCustomer("BigBaank")
                    .buy(80)
                    .stock("IBM")
                    .on("NYSE")
                    .at(125.00)
                    .sell(50)
                    .stock("GOOGLE")
                    .on("NASDAQ")
                    .at(375.00)
                    .end();

        System.out.println(order);

    }
}
