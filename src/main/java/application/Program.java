package application;

import entities.Products;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter with path and name File CSV:");
        String strpath = sc.nextLine();
        List<Products> productsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(strpath))) {
            String line = br.readLine();
            while (line != null) {
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
        }catch (IOException e){
            System.out.println("Erro:"+ e.getMessage());
        }
        System.out.println("Creating subfolder out");
        File path = new File(strpath);
        boolean sucess = new File(path.getParent() + "\\out").mkdir();
        System.out.println(sucess);
        String strpathout = path.getParent() + "\\out\\summary.csv";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(strpathout))){

            System.out.println("Creating a new CSV:");
            for (Products obj : productsList) {
                bw.write(obj.getName()+";"+ String.format("%.2f%n", obj.totalprice()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        sc.close();
    }
}
