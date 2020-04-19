package one;

@Label(name = "人员")
public class Person {
    @Label(name = "姓名")
    private String name;
    @Label(name = "性别")
    private String sex;
    @Label(name = "身份证号码")
    private String idNo;
    @Label(name = "年龄")
    private Integer age;
    @Label(name = "是否已婚")
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
