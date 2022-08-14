package org.study.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.study.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomersDeserializer {

    public static ArrayList<Customer> deserialize(String fromFile) {
        ArrayList<Customer> customers = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(fromFile);
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

    public static List<Customer> deserializeFromJSON(String fromFile) {
        StringReader reader = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile))){
            reader = new StringReader(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        } catch (JsonProcessingException e) {
            System.out.println(e.getStackTrace());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        List<Customer> customers = new ArrayList<>();
        ObjectMapper objectMapper = null;
        try {
            objectMapper = new ObjectMapper();
            customers =  objectMapper.readValue(reader, new TypeReference<List<Customer>>(){});
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        return customers;
    }



}
