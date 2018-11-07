public class BankAccount {

    private String IBAN;
    private Person owner;

    public BankAccount(String IBAN, Person owner) {
        this.IBAN = IBAN;
        this.owner = owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", owner=" + owner +
                '}';
    }
}
