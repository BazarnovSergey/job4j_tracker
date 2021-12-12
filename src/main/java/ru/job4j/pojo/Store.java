package ru.job4j.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] prods = {milk, bread, egg};
        for (Product pr : prods) {
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("Replace milk to oil.");
        prods[0] = new Product("Oil", 11);
        for (Product pr : prods) {
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("Shown only product.count > 10");
        for (Product pr : prods) {
            if (pr.getCount() > 10) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            }
        }
    }
}