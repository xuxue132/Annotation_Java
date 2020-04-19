package two;

import one.Label;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonShow implements PersonAction{
    private Class<?> MyClass;
    @Override
    public Person process(Person person) {
        if(person == null){
            System.out.print("没有此用户！！");
        }else {
            System.out.print("成员信息: ");
            this.MyClass = person.getClass();
            Field[] fields = MyClass.getDeclaredFields();
            for (Field field : fields) {
                Object value = "";
                String name = field.getAnnotation(Column.class).name();
                String personmethon = "get"
                        + field.getName().substring(0, 1).toUpperCase()
                        + field.getName().substring(1);
                try {
                    Method method = MyClass.getMethod(personmethon);
                    value = method.invoke(person);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(name + " : " + value + "");
            }
        }
        return null;
    }
}
