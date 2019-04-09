package _4_EmbeddableComponents.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "_4_embeddable_components")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @AttributeOverrides({
            @AttributeOverride(name = "city",
                    column = @Column(name = "home_city", nullable = false)),
            @AttributeOverride(name = "street",
                    column = @Column(name = "home_street", nullable = false)),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "home_zipcode", nullable = false, length = 5))
    })
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "city",
                    column = @Column(name = "work_city", nullable = false)),
            @AttributeOverride(name = "street",
                    column = @Column(name = "work_street", nullable = false)),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "work_zipcode", nullable = false, length = 5))
    })
    private Address workAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
    }
}
