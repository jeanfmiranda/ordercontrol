package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        Client client = new Client(clientName, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        Date moment = new Date();

        Order order = new Order(moment, OrderStatus.valueOf(status));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i=0;i<n;i++) {
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product p = new Product(productName, price);
            OrderItem orderItem = new OrderItem(quantity, p.getPrice(), p);
            order.addItem(orderItem);
        }

        System.out.println(order);

        sc.close();
    }
}