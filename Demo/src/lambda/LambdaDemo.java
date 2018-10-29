package lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {

    /**
     * lambda简易例子
     */
    @Test
    public void demo1() {
        List<String> names = Arrays.asList("peter", "anno", "mike", "xenia");

        //以前的方法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //改成Lambda表达式
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //更加简洁和易读
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        //省略参数类型，由java编译器自动识别
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    /**
     * 函数式接口
     */
    @Test
    public void demo2() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }

    /**
     * 方法引用
     */
    @Test
    public void demo3() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("java");
        System.out.println(converted);
    }


    /**
     * 构造函数引用
     * 通过构造函数引用来把所有东西拼在一起，而不是像以前一样，通过手动实现一个工厂来这么做。
     */
    @Test
    public void demo4() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println("firstName:" + person.firstName +
                "\nlastName:" + person.lastName);
    }

    /**
     * 访问局部变量
     */
    @Test
    public void demo5() {
        final int num = 1;
        //lambda表达式外部的final局部变量
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);
        System.out.println(stringConverter.convert(2));

        int num1 = 1;
        //与匿名对象不一样的是，即使变量num不是fianl，代码依旧可行
        Converter<Integer, String> stringConverter1 = from -> String.valueOf(from + num1);
        System.out.println(stringConverter1.convert(2));

        //然而，num在编译的时候被隐式地当作final变量来处理就不行
        int num2 = 1;
//        Converter<Integer, String> stringConverter2 = (from) -> String.valueOf(from + num2);
        num2 = 3;
        //在lambda表达式内部改变num的值也是不行的
    }

    /**
     * 访问成员变量和静态变量
     * 与局部变量不同，我们在lambda表达式的内部能获取到对成员变量或静态变量的读写权。这种访问行为在匿名对象里是非常典型的。
     */
    static int outerStaticNum;
    int outerNum;
    @Test
    public void demo6(){
        Converter<Integer, String> stringCOnverter1 = (from) ->{
            outerNum = 23;
            return String.valueOf(from);
        };
        Converter<Integer,String> StringConverter2 = (from) ->{
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }

    /**
     * 访问默认接口方法
     * 默认方法无法在lambda表示内部被访问，所以以下代码是无法通过编译的
     */
    @Test
    public void demo7(){
//        Formula formula = (a) ->sqrt(a * 100);
    }
}
