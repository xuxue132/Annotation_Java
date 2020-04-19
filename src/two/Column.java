package two;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})//变量和类
public @interface Column {
    //注解
    public String name() default "";
    public boolean Nullable() default false;
    public int MaxLength() default -1;
    public int MinLength() default -1;
    public int MaxValue() default -1;
    public int MinValue() default  -1;
}
