package application;

import entities.Products;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter with path and name File CSV:");
        String strpath = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(strpath))) {

            List<Products> productsList = new ArrayList <>();

            String line = br.readLine();
            while (line != null){
                String[] output = line.split(",");

                System.out.println(output[0]);
                System.out.println(output[1]);
                System.out.println(output[2]);

                String nameProduct = output[0];
                Double priceProduct = Double.parseDouble(output[1]);
                int qtdProduct = Integer.parseInt(output[2]);
                productsList.add(new Products(nameProduct, priceProduct, qtdProduct));
                line = br.readLine();
            }

            System.out.println("List of items CSV:");

            for (Products obj: productsList){
                System.out.println(obj.getName()+";"+obj.getPrice()+";"+obj.getQuantity());
            }


        }catch (IOException e){
            System.out.println("Erro:"+ e.getMessage());
        }
        sc.close();

    }
}
