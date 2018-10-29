package visitor;

public class VisitorDemo {

    //银行柜台服务，以后银行要新增业务，只需要新增一个类实现这个接口就可以了
    interface Service{
        void accept(Visitor visitor);
    }

    //来办业务的人，里面可以加上权限控制等等
    static class Visitor{
        public void process(Service service){
            //基本业务
            System.out.println("基本业务");
        }

        public void process(Saving service){
            //存款
            System.out.println("存款");
        }

        public void process(Draw service){
            //提款
            System.out.println("提款");
        }

        public void process(Fund service){
            //基金
            System.out.println("基金");
        }
    }

    static class Saving implements Service{
        @Override
        public void accept(Visitor visitor) {
            visitor.process(this);
        }
    }

    static class Draw implements Service{
        @Override
        public void accept(Visitor visitor) {
            visitor.process(this);
        }
    }

    static class Fund implements Service{
        @Override
        public void accept(Visitor visitor) {
            visitor.process(this);
        }
    }

    public static void main(String[] args) {
        Service saving = new Saving();
        Service fund = new Fund();
        Service draw = new Draw();
        Visitor visitor = new Visitor();
        Visitor guweiwei = new Visitor();
        fund.accept(guweiwei);
        saving.accept(visitor);
        fund.accept(visitor);
        draw.accept(visitor);
    }
}
