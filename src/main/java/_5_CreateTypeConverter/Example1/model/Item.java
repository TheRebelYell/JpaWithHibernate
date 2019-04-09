package _5_CreateTypeConverter.Example1.model;

import _5_CreateTypeConverter.Example1.converter.MonetaryAmountConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "items", schema = "_5_create_type_converter")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Convert(converter = MonetaryAmountConverter.class)
    @Column(name = "price", length = 63)
    private MonetaryAmount buyNowPrice;

    @NotNull
    @Temporal(value = TemporalType.TIMESTAMP)
    private final Date createdOn = new Date();


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonetaryAmount getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(MonetaryAmount buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buyNowPrice=" + buyNowPrice +
                ", createdOn=" + createdOn +
                '}';
    }
}
