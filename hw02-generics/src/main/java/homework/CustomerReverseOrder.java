package homework;

import java.util.Deque;
import java.util.LinkedList;

public class CustomerReverseOrder <E>{
    //todo: 2. надо реализовать методы этого класса
    //LinkedList<Customer> lstCustomer = new LinkedList<>();
    Deque<Customer> lstCustomer = new LinkedList<>();

    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    public void add(Customer customer) {
        lstCustomer.push(customer);
    }
    public Customer take() {
        return lstCustomer.pollFirst();
    }
}
