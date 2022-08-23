package org.study;

import org.study.serializers.CustomersDeserializer;
import org.study.serializers.CustomersSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String FILE_NAME = "serialized.ser";
    public static String JSON_FILE_NAME = "JSONserialized.txt";
    public static String XML_FILE_NAME = "XMLserialized.xml";
    public static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        customers.add(new Customer("Phosagro", "Fertilizers", 1000));
        customers.add(new Customer("Severstal", "Metals", 900));
        customers.add(new Customer("GazPromNeft", "Oil and gas", 500));

        //CustomersSerializer.serialize(customers, FILE_NAME);
        //for (Customer customer: CustomersDeserializer.deserialize(FILE_NAME)) {
        //    System.out.println(customer.toString());
        //}

        //CustomersSerializer.serializeToJSON(customers, JSON_FILE_NAME);
        //for (Customer customer: CustomersDeserializer.deserializeFromJSON(JSON_FILE_NAME)) {
        //    System.out.println(customer.toString());
        //}

        //CustomersSerializer.serializeToXML(customers, XML_FILE_NAME);
        for (Customer customer: CustomersDeserializer.deserializeFromXML(XML_FILE_NAME)) {
            System.out.println(customer.toString());
        }

    }
}