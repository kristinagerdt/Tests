import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private List<Person> persons = new LinkedList<>();
    private List<BankAccount> accounts = new LinkedList<>();
    private List<Person> listOfPerson = new LinkedList<>();

    @Before
    public void setInputData() {
        Address a1 = new Address("Baker", 3);
        Address a2 = new Address("Oxford", 14);
        Address a3 = new Address("Carnaby", 1);

        Person p1 = new Person("Ivan", 34, a1);
        Person p2 = new Person("Maria", 14, a2);
        Person p3 = new Person("Stepan", 34, a3);
        Collections.addAll(persons, p1, p2, p3);

        BankAccount ba1 = new BankAccount("AABBCC111", p1);
        BankAccount ba2 = new BankAccount("FFGGHH222", p1);
        BankAccount ba3 = new BankAccount("LLMMNN333", p2);
        BankAccount ba4 = new BankAccount("QQRRSS444", p3);
        Collections.addAll(accounts, ba1, ba2, ba3, ba4);

        Person p5 = new Person("Ivan", 45, a1, Arrays.asList(ba1, ba2));
        Person p6 = new Person("Stepan", 34, a3, Arrays.asList(ba4));
        Collections.addAll(listOfPerson, p5, p6);
    }

    @Test
    public void testGetAddressesPersonsOlder17() {
        List<Address> expected = Arrays.asList(
                new Address("Baker", 3),
                new Address("Carnaby", 1));
        List<Address> actual = Bank.getAddressesPersonsOlder17(persons);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListGetAddressesPersonsOlder17() {
        List<Address> expected = new LinkedList<>();
        List<Address> actual = Bank.getAddressesPersonsOlder17(new LinkedList<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testNullGetAddressesPersonsOlder17() {
        List<Address> expected = new LinkedList<>();
        List<Address> actual = Bank.getAddressesPersonsOlder17(null);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDistinctNames() {
        List<String> expected = Arrays.asList("Ivan", "Maria", "Stepan");
        List<String> actual = Bank.getDistinctNames(persons);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListGetDistinctNames() {
        List<String> expected = new LinkedList<>();
        List<String> actual = Bank.getDistinctNames(new LinkedList<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testPartitionPersonsByAge() {
        Map<Integer, List<Person>> expected = new HashMap<>();
        expected.put(34, Arrays.asList(persons.get(0), persons.get(2)));
        expected.put(14, Collections.singletonList(persons.get(1)));
        Map<Integer, List<Person>> actual = Bank.partitionPersonsByAge(persons);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListPartitionPersonsByAge() {
        Map<Integer, List<Person>> expected = new HashMap<>();
        Map<Integer, List<Person>> actual = Bank.partitionPersonsByAge(new LinkedList<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testPartitionBankAccount() {
        Map<Person, List<BankAccount>> expected = new HashMap<>();
        expected.put(persons.get(0), Arrays.asList(accounts.get(0), accounts.get(1)));
        expected.put(persons.get(1), Collections.singletonList(accounts.get(2)));
        expected.put(persons.get(2), Collections.singletonList(accounts.get(3)));
        Map<Person, List<BankAccount>> actual = Bank.partitionBankAccount(accounts);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListPartitionBankAccount() {
        Map<Person, List<BankAccount>> expected = new HashMap<>();
        Map<Person, List<BankAccount>> actual = Bank.partitionBankAccount(new LinkedList<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetIBANs() {
        List<String> expected = Arrays.asList("AAB******", "FFG******", "LLM******", "QQR******");
        List<String> actual = Bank.getIBANs(accounts);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListGetIBANs() {
        List<String> expected = new LinkedList<>();
        List<String> actual = Bank.getIBANs(new LinkedList<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHiddenIban() {
        String expected = "AAB******";
        String actual = Bank.getHiddenIban("AABBCC111");
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyStringGetHiddenIban() {
        String expected = "";
        String actual = Bank.getHiddenIban("");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetIBANsByPerson() {
        List<String> expected = Arrays.asList("AAB******", "FFG******", "QQR******");
        List<String> actual = Bank.getIBANsByPerson(listOfPerson);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListGetIBANsByPerson() {
        List<String> expected = new LinkedList<>();
        List<String> actual = Bank.getIBANsByPerson(new LinkedList<>());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSumAgePersonsOlder17() {
        Integer expected = 68;
        Integer actual = Bank.getSumAgePersonsOlder17(persons);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyListGetSumAgePersonsOlder17() {
        Integer expected = 0;
        Integer actual = Bank.getSumAgePersonsOlder17(new LinkedList<>());
        assertEquals(expected, actual);
    }
}