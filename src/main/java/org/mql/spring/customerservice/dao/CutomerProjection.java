package org.mql.spring.customerservice.dao;

import org.mql.spring.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Customer.class)
public interface CutomerProjection {
    public Long getId();
    public String getName();
}
