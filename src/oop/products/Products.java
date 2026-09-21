package oop.products;

import fileworks.DataImport;

import java.util.ArrayList;

public class Products {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/products.txt");
        ArrayList<Product> allProducts = new ArrayList<>();
        Long allProductsCount = 0L;
        while (di.hasNext()){
            String[] line = di.readLine().split(";");
            if (line.length == 4) allProducts.add(new Product(line[0], line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]) ));
            if (line.length == 3) allProducts.add(new Product(line[0], line[1], Integer.parseInt(line[2])));
            if (line.length == 2){new Product(line[0], line[1]);}

            if (line.length>2) {
                System.out.println("Počet kusů: " + line[2]);
                allProductsCount += Long.parseLong(line[2]);
            }

        }
        System.out.println(allProducts.size());
        System.out.println(allProductsCount);

        di.finishImport();
    }

}
