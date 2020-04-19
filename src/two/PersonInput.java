package two;



import com.sun.org.apache.xpath.internal.objects.XObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class PersonInput implements PersonAction {

    private Class<?> MyClass;
    @Override
    public Person process(Person person) {
        Scanner sc = new Scanner(System.in);
        this.MyClass = person.getClass();
        Field[] fields = MyClass.getDeclaredFields();
        System.out.println("请输入信息： ");
        for(Field filed:fields){
            Annotation infor = filed.getAnnotation(Column.class);
            String name = ((Column) infor).name();
            System.out.print("请输入 "+name+": ");
            Object value="";
            switch (filed.getType().getTypeName()){
                case "java.lang.String":
                    boolean flag=true;
                    while (flag) {
                        value = sc.next();
                        if (!((Column) infor).Nullable() && !(((Column) infor).MaxLength() >= ((String) value).length() && ((Column) infor).MinLength() <= ((String) value).length())) {
                            System.out.print("请输入最高 " + ((Column) infor).MaxLength() + "  最低 " + ((Column) infor).MinLength() + " 字符");
                        }else {
                            flag=false;
                        }
                    }
                    ;break;
                case "java.lang.Integer":
                    boolean flag1=true;
                    while (flag1) {
                        value = sc.nextInt();
                        if (!((Column) infor).Nullable() && !(((Column) infor).MaxValue() > ((Integer) value) && ((Column) infor).MinValue() < ((Integer) value))) {
                            System.out.print("请输入最高 " + ((Column) infor).MaxValue() + "  最低 " + ((Column) infor).MinValue() + " 数值");
                        }else {
                            flag1=false;
                        }
                    }
                    break;
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
