package _6_MappingInheritance._6_2_TablePerClassWithUnions.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "BillingDetails_2")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "billing_details2", schema = "_6_mapping_inheritance")
public class BillingDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String owner;


    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BillingDetails[" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ']';
    }
}