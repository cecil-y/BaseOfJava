package prototypeMode;

import java.io.*;

//深浅复制的例子
//要实现深复制，需要采用流的形式读入当前对象的二进制输入，再写出二进制数据对应的对象。
public class Prototypes implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String string;

    private SerializableObject obj;

    //    浅复制
    public Object clone() throws CloneNotSupportedException {
        Prototypes prototypes = (Prototypes) super.clone();
        return prototypes;
    }

    //    深复制
    public Object deepClone() throws IOException, ClassNotFoundException {
//        写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

//        读出当前对象的二进制流
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }
}
