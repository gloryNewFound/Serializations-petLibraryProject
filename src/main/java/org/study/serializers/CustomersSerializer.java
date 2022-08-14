package org.study.serializers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.study.Customer;
import org.study.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.List;

public class CustomersSerializer {

    public static void serialize(List<Customer> customers, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))
        {
                objectOutputStream.writeObject(customers);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void serializeToJSON(List<Customer> customers, String toFile){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(toFile), customers);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void serializeToXML(List<Customer> customers, String toFile) {
        File file = new File(toFile);
        try {
            Customers listOfCustomers = new Customers();
            for (Customer one: customers) {
                listOfCustomers.list.add(one);
            }
            JAXBContext context = JAXBContext.newInstance(Customers.class, Customer.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(listOfCustomers, file);
        } catch (JAXBException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
