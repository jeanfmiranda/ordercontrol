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

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        Date moment = new Date();

        Order order = new Order(moment, OrderStatus.valueOf(status), new Client(clientName, email, birthDate));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i=1;i<=n;i++) {
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
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