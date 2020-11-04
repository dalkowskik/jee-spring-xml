package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleCustomerLogger simpleCustomerLogger = context.getBean(SimpleCustomerLogger.class);
        simpleCustomerLogger.log();
        MemoryCustomerRepository memoryCustomerRepository = context.getBean(MemoryCustomerRepository.class);
        Customer customer = new Customer();
        Customer customer1 = new Customer();
        System.out.println("------------------------");
        System.out.println(memoryCustomerRepository.addCustomer(customer));
        System.out.println(memoryCustomerRepository.addCustomer(customer1));
        System.out.println(memoryCustomerRepository.listCustomers());
        System.out.println(memoryCustomerRepository.removeCustomer(customer));
        System.out.println(memoryCustomerRepository.listCustomers());
    }
}
