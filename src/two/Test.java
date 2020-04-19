package two;

import one.PersonInput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static int count = 0;
    private static List<Person> list = new ArrayList<Person>();
    public static void main(String[] args){

        boolean flag = true;
        Scanner sc  = new Scanner(System.in);
        while (flag){
            System.out.println("请选择功能编号: 1.用户添加，2.用户删除,3.用户修改，4.用户查询，5.所有用户信息，6.退出");
            switch (sc.nextInt()){
                case 1: addPerson();break;
                case 2: deletePerson();break;
                case 3: updatePerson();break;
                case 4: selectPerson();break;
                case 5: all();break;
                case 6: flag=false;break;
            }
        }
    }

    public static void addPerson(){
        two.PersonInput personInput = new two.PersonInput();
        Person person = personInput.process( new Person());
        list.add(person);
    }

    public static void selectPerson(){
        Scanner sc = new Scanner(System.in);
        two.PersonShow personShow = new two.PersonShow();
        System.out.print("请输入查询用户编号: ");
        int i = sc.nextInt();
        System.out.print("编号："+i);
        if(list.size()<=i){
            System.out.println("没有此人");
        }else {
            Person person = personShow.process(list.get(i));
        }


    }

    public static void all(){
        int i=0;
        two.PersonShow personShow = new two.PersonShow();
        for(Person lists : list){
            System.out.println("编号："+i);
            Person person = personShow.process(lists);
            i++;
        }
    }

    public static void deletePerson(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入删除用户编号: ");
        int i = sc.nextInt();
        if(list.size()<=i){
            System.out.println("没有此人");
        }else {
            list.remove(i);
        }
    }

    public static void updatePerson(){
        two.PersonInput personInput = new two.PersonInput();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入修改用户编号: ");
        int i = sc.nextInt();
        if(list.size()<=i){
            System.out.println("没有此人");
        }else {
            Person person = personInput.process( new Person());
            list.get(i).setName(person.getName());
            list.get(i).setAge(person.getAge());
            list.get(i).setIdNo(person.getIdNo());
            list.get(i).setSex(person.getSex());
            list.get(i).setIsMarried(person.getIsMarried());
        }
    }

}
