import java.io.Serializable;

public class Customer implements Serializable {
    String name,phone,age,job;
    boolean isIndividual;

    public Customer(String name, String phone, String age, String job, boolean isIndividual) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.job = job;
        this.isIndividual = isIndividual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isIndividual() {
        return isIndividual;
    }

    public void setIndividual(boolean individual) {
        isIndividual = individual;
    }

    @Override
    public String toString() {
        return " name= " + name + "\n"+" phone= " + phone + "\n"+" age= " + age +"\n"+" job= " + job +"\n"+" isIndividual=" + isIndividual +"\n";

    }
}
