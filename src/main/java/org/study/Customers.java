package org.study;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "customers")
@XmlRootElement
public class Customers {
    @XmlElement(name = "customer", namespace = "")
    public List<Customer> list = new ArrayList<>();
}
