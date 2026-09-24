package esinf;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Supermarket {
    Map <Invoice, Set<Product>> sup;
    
    Supermarket() {
        sup = new HashMap<>();
    }
    
    // Reads invoices from a list of String
    void getInvoices(List <String> l) throws Exception {
        Invoice currentInvoice = null;
        for(String line: l){
            String[] info = line.split(",");
            if(info[0].equals("I")){
                currentInvoice = new Invoice(info[1], info[2]);
                sup.putIfAbsent(currentInvoice, new HashSet<Product>());
            }else if(info[0].equals("P")){
                Set<Product> products= sup.get(currentInvoice);
                Product product = new Product(info[1],Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                products.add(product);
            }

        }

    }   
    
    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {

        Map<Invoice,Integer>  result = new HashMap<>();

        for(Map.Entry<Invoice, Set<Product>> entry : sup.entrySet()){
            Invoice invoice = entry.getKey();
            Integer numberOfProducts = entry.getValue().size();
            result.put(invoice,numberOfProducts);
        }

        return  result;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> result = new TreeSet<>();
        for(Map.Entry<Invoice,Set<Product>> entry: sup.entrySet()){
            Invoice invoice = entry.getKey();
            LocalDate invoiceDate = invoice.getDate();
        if ( invoiceDate.isAfter(d1) && invoiceDate.isBefore(d2)) {
                result.add(invoice);
            }
        }
        return result;
    }
    
    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
       long result = 0;
       for(Map.Entry<Invoice,Set<Product>> entry: sup.entrySet()){
          Set<Product> products = entry.getValue();
          for(Product product: products){
              if (product.getIdentification().equals(productId)) {
                  result += product.getPrice() * product.getQuantity();
              }
          }
       }
       return result;

    }
    
    // converts a map of invoices and products to a map which key is a product
    // identification and the values are a set of the invoices in which it appears
    Map<String, Set<Invoice>> convertInvoices() {
        Map<String,Set<Invoice>> result = new TreeMap<>();
        Set<Invoice> invoices = new TreeSet<>();
        for(Map.Entry<Invoice,Set<Product>> entry: sup.entrySet()){
            Set<Product> products = entry.getValue();
            invoices.add(entry.getKey());
            for(Product product: products) {
                result.putIfAbsent(product.getIdentification(),invoices);
            }
        }
        return result;
    }
}
