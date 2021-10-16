package stringbasic;

public class Person {
    //név, e-mail cím, TAJ-szám, bankszámla szám, telefonszám
    private String name;
    private String email;
    private String address;
    private String taj;
    private String bankAccountNumber;
    private String tel;

    public Person(String name, String email, String address, String taj, String bankAccountNumber, String tel) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.taj = taj;
        this.bankAccountNumber = bankAccountNumber;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
