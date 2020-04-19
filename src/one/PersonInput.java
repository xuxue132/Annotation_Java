package one;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PersonInput implements PersonAction{

    private Class<?> MyClass;
    @Override
    public Person process(Person person) {
        Scanner sc = new Scanner(System.in);
        this.MyClass = person.getClass();
        Field[] fields = MyClass.getDeclaredFields();
        System.out.println("请输入信息： ");
        for(Field filed:fields){
            String name = filed.getAnnotation(Label.class).name();
            System.out.print("请输入 "+name+": ");
            Object value="";
            switch (filed.getType().getTypeName()){
                case "java.lang.String": value = sc.next() ;break;
                case "java.lang.Integer": value = sc.nextInt(); break;
                case "java.lang.Boolean": value = sc.nextBoolean(); break;
            }
            String methodName = "set"
                    + filed.getName().substring(0, 1).toUpperCase()
                    + filed.getName().substring(1);
            try {
                Method method = MyClass.getMethod(methodName,filed.getType());
                method.invoke(person,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return person;
    }
}
