package homework;

import java.io.Serializable;
import java.util.*;

public class CustomerService {
    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    TreeMap<Customer, String> treeCustomer;

    public CustomerService() {
        treeCustomer = new TreeMap<>(Comparator.comparingLong(Customer::getScores));
    }

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String>  treeCustomerCopy = treeCustomer.firstEntry();

        return Map.entry(new Customer(treeCustomerCopy.getKey()), treeCustomerCopy.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String>  treeCustomerCopy = treeCustomer.higherEntry(customer);
        if (treeCustomerCopy == null) {
            return null;
        }
        return Map.entry(new Customer(treeCustomerCopy.getKey()), treeCustomerCopy.getValue());
    }

    public void add(Customer customer, String data) {
        treeCustomer.put(customer, data);

    }


}
