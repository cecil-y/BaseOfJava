package keyword.defaulT;

import org.junit.jupiter.api.Test;

public class FormulaImpl {

    /**
     * 只需要实现抽象方法即可
     * 注意：此类未声明实现接口
     */
    @Test
    public void test1() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));

    }


}
