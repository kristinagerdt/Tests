import java.util.List;

public class Person {
    private String name;
    private int age;
    private Address address;
    private List<BankAccount> bankAccounts;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, Address address, List<BankAccount> bankAccounts) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
        this.bankAccounts = bankAccounts;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}