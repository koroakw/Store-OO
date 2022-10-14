package aplication;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.util.Locale;

public class program {
    public static void main( String[] args) throws ParseException { //o throws propaga a excessão no parse vai propagar ela pro main
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//faz a formatação da data na ISO para o padrão brasileiro
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client (name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());//faz a conversão do string para o valor correspondente definido no orderstatus
        Order order = new Order(new Date(), status, client);
        System.out.println("How many items to this order? ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            System.out.println("Enter # " + (i+1) + "item data: ");
            System.out.println("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);


        OrderItem it = new OrderItem(quantity, productPrice, product);

        order.addItem(it);//adiciona o pedido ao item
    }
        System.out.println();
        System.out.println(order);
}
}