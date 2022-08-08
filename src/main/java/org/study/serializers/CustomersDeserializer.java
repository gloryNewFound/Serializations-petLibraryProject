package org.study.serializers;

import org.study.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomersDeserializer {

    public static ArrayList<Customer> deserialize(String toFile) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(toFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            customers = (ArrayList<Customer>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassCastException e ){
            System.out.println(e.getMessage());
        }
        return customers;
    }



}
