package _6_MappingInheritance._6_2_TablePerClassWithUnions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "BankAccount_2")
@Table(name = "bank_accounts2", schema = "_6_mapping_inheritance")
public class BankAccount extends BillingDetails {

    @NotNull
    private String account;

    @NotNull
    @Column(name = "bank_name")
    private String bankname;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @Override
    public String toString() {
        return "BankAccount[" +
                "id=" + getId() +
                ", owner='" + getOwner() + '\'' +
                ", account='" + account + '\'' +
                ", bankname='" + bankname + '\'' +
                ']';
    }
}
