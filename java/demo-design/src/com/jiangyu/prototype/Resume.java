package com.jiangyu.prototype;

/**
 * 具体原型角色   简历
 * 实现了克隆功能
 * @author JIAO
 *
 */
public class Resume implements Cloneable {
    private String name;
    private int age;
    private String sex;
    private String tel;
    private String workExperience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }


    public Resume(String name, int age, String sex, String tel,
                  String workExperience) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.workExperience = workExperience;
    }
    public Resume(String name, int age, String sex, String tel) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
    }
    public Resume(){}



    @Override
    public String toString() {
        return "Resume [name=" + name + ", age=" + age + ", sex=" + sex
                + ", tel=" + tel + ", workExperience=" + workExperience + "]";
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

