import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {

    public static List<Address> getAddressesPersonsOlder17(List<Person> persons) {
        if (persons != null) {
            return persons
                    .stream()
                    .filter(p -> p.getAge() > 17)
                    .map(Person::getAddress)
                    .collect(Collectors.toList());
        }
        return new LinkedList<>();
    }

    public static List<String> getDistinctNames(List<Person> persons) {
        return persons
                .stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<Person>> partitionPersonsByAge(List<Person> persons) {
        return persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }

    public static Map<Person, List<BankAccount>> partitionBankAccount(List<BankAccount> accounts) {
        return accounts
                .stream()
                .collect(Collectors.groupingBy(BankAccount::getOwner));
    }

    public static List<String> getIBANs(List<BankAccount> accounts) {
        return accounts
                .stream()
                .map(BankAccount::getIBAN)
                .map(p -> getHiddenIban(p))
                .collect(Collectors.toList());
    }

    public static List<String> getIBANsByPerson(List<Person> persons) {
        return persons
                .stream()
                .flatMap(p -> p.getBankAccounts().stream())
                .map(BankAccount::getIBAN)
                .map(Bank::getHiddenIban)
                .collect(Collectors.toList());
    }

    public static Integer getSumAgePersonsOlder17(List<Person> persons) {
        return persons
                .stream()
                .mapToInt(Person::getAge)
                .filter(p -> p > 17)
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    public static String getHiddenIban(String iban) {
        if (iban.length() != 0) {
            return iban.substring(0, 3) + iban.substring(3).replaceAll("\\w", "*");
        }
        return "";
    }
}