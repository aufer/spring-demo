package de.ausgeufert.demo.members;

import de.ausgeufert.demo.shared.Person;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Member extends Person {

    private Date memberSince;
    private int yearlyFee;
    private String iban;
    private String bic;
    private String sepaReference;
    private boolean dsgvoConfirmation;

    public Member() {
        super();
    }

    public Member(
            Date memberSince,
            int yearlyFee,
            String iban,
            String bic,
            String sepaReference,
            boolean dsgvoConfirmation,
            String firstName,
            String lastName,
            String street,
            String streetNumber,
            String postCode,
            String city,
            String phone,
            String mobile,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.memberSince = memberSince;
        this.yearlyFee = yearlyFee;
        this.iban = iban;
        this.bic = bic;
        this.sepaReference = sepaReference;
        this.dsgvoConfirmation = dsgvoConfirmation;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public int getYearlyFee() {
        return yearlyFee;
    }

    public void setYearlyFee(int yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getSepaReference() {
        return sepaReference;
    }

    public void setSepaReference(String sepaReference) {
        this.sepaReference = sepaReference;
    }

    public boolean isDsgvoConfirmation() {
        return dsgvoConfirmation;
    }

    public void setDsgvoConfirmation(boolean dsgvoConfirmation) {
        this.dsgvoConfirmation = dsgvoConfirmation;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberSince=" + memberSince +
                ", yearlyFee=" + yearlyFee +
                ", iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", sepaReference='" + sepaReference + '\'' +
                ", dsgvoConfirmation=" + dsgvoConfirmation +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
