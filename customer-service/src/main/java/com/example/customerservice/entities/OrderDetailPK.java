package com.example.customerservice.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable  {
    private long orderId;
    private long productId;

    public OrderDetailPK() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderDetailPK other = (OrderDetailPK) obj;
        return Objects.equals(orderId, other.orderId) && Objects.equals(productId, other.productId);
    }
}
