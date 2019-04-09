package _6_MappingInheritance._6_1_TablePerClassWithImplicitPoly.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
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
}
