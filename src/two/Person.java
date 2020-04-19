package two;

import two.Label;

@Label(name = "人员")
public class Person {
    @Column(name = "姓名",Nullable = false, MaxLength = 10, MinLength = 1)
    private String name;
    @Column(name = "性别", Nullable = false, MaxLength = 2, MinLength = 1)
    private String sex;
    @Column(name = "身份证号",Nullable = false, MaxLength = 10, MinLength = 1 )
    private String idNo;
    @Column(name = "年龄",Nullable = false, MaxValue =100 , MinValue =0 )
    private Integer age;
    @Column(name = "是否婚配",Nullable = false, MaxValue =0 , MinValue =0 )
    private Boolean isMarried;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean married) {
        isMarried = married;
    }
}
