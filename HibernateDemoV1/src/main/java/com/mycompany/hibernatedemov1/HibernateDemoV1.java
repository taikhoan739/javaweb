/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hibernatedemov1;

import com.nhm.repositories.Impl.CategoryRepositoryImpl;
import com.nhm.repositories.Impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemoV1 {

    public static void main(String[] args) {
        CategoryRepositoryImpl c = new CategoryRepositoryImpl();
        c.getCates().forEach(ca->System.out.println(ca.getName()));
        ProductRepositoryImpl prod = new ProductRepositoryImpl();
        prod.getProducts(null).forEach(p-> System.out.printf("%d - %s - %.1f\n",p.getId(),p.getName(),p.getPrice()));    
        Map<String,String> params = new HashMap<>();
        params.put("name", "iPhone");
        System.out.println("Filter Name ============");
        prod.getProducts(params).forEach(p-> System.out.printf("%d - %s - %.1f\n",p.getId(),p.getName(),p.getPrice()));
        params.clear();
        
        params.put("beginPrice", "11000000");
        params.put("endPrice", "20000000");
        System.out.println("Filter Price ============");
        prod.getProducts(params).forEach(p-> System.out.printf("%d - %s - %.1f\n",p.getId(),p.getName(),p.getPrice()));
        params.clear();
        
        params.put("categoryId", "2");
        System.out.println("Filter CateogyId ============");
        prod.getProducts(params).forEach(p-> System.out.printf("%d - %s - %.1f\n",p.getId(),p.getName(),p.getPrice()));
        params.clear();
         params.put("page", "2");
        System.out.println("Filter Page ============");
        prod.getProducts(params).forEach(p-> System.out.printf("%d - %s - %.1f\n",p.getId(),p.getName(),p.getPrice()));

        
        
    }
    
}
