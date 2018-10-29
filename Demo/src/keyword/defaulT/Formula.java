package keyword.defaulT;

/**
 * java8允许使用default关键字为接口添加非抽象的方法实现
 * 此方法被称为扩展方法
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
