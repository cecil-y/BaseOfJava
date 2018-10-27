package adapterMode.objectAdapterMode;

import adapterMode.classAdapterMode.Source;
import adapterMode.classAdapterMode.Targetable;

public class Test {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method1();
    }
}
