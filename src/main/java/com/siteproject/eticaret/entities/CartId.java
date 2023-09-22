package com.siteproject.eticaret.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CartId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer customerId;

    private Integer productId;

    private Integer cartId;
}
