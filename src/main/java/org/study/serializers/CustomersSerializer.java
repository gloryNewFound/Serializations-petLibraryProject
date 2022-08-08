package org.study.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.study.Customer;

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

    public static void serializeToJSON(List<Customer> customers, String toFile) throws IOException {
        StringWriter stringWriter = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(toFile), customers);
    }
}
