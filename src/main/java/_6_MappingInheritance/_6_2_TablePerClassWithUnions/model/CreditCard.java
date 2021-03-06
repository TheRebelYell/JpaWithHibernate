package _6_MappingInheritance._6_2_TablePerClassWithUnions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "CreditCard_2")
@Table(name = "credit_cards2", schema = "_6_mapping_inheritance")
public class CreditCard extends BillingDetails {

    @NotNull
    @Column(name = "card_number")
    private String cardNumber;

    @NotNull
    @Column(name = "exp_month")
    private String expMonth;

    @NotNull
    @Column(name = "exp_year")
    private String expYear;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    @Override
    public String toString() {
        return "CreditCard[" +
                "id=" + getId() +
                ", owner='" + getOwner() + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expMonth='" + expMonth + '\'' +
                ", expYear='" + expYear + '\'' +
                ']';
    }
}
