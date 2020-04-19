package one;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonDisplay implements PersonAction{
    private Class<? extends Person> MyClass;

    @Override
    public Person process(Person person) {
        System.out.print("成员信息: ");
        this.MyClass = person.getClass();
        Field[] fields = MyClass.getDeclaredFields();
        for (Field field:fields){
            Object value = "";
            String name = field.getAnnotation(Label.class).name();
            String personmethon = "get"
                    + field.getName().substring(0, 1).toUpperCase()
                    + field.getName().substring(1);
            try {
                Method method = MyClass.getMethod(personmethon);
                value = method.invoke(person);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(name+" : "+value+"");
        }
        return null;
    }
}
