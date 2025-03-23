/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhm.repositories.Impl;

import com.nhm.pojo.OrderDetail;
import com.nhm.pojo.Product;
import com.nhm.pojo.SaleOrder;
import com.nhm.repositories.ProductRepository;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    public static final int PAGE_SIZE = 6;
    @Autowired
    private LocalSessionFactoryBean factory;
    public List<Product> getProducts(Map<String,String> params){
        Session s = this.factory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            List<Predicate> predicates = new ArrayList<>();
            if(params!=null && params.containsKey("name")){
                String name =  params.get("name");
                predicates.add(b.like(root.get("name"),'%' +name+'%'));
            }else if(params!=null && params.containsKey("endPrice") &&  params.containsKey("endPrice")){
                Double beginPrice = Double.parseDouble(params.get("beginPrice")) ;
                Double endPrice = Double.parseDouble(params.get("endPrice")) ;
                predicates.add(b.between(root.get("price"), beginPrice,endPrice));
            }else if(params!=null && params.containsKey("categoryId")){
                int cateId = Integer.parseInt(params.get("categoryId"));
                predicates.add(b.equal(root.get("categoryId").as(Integer.class), cateId));
            }
            q.select(root).where(predicates.toArray(Predicate[]::new));
            Query query =s.createQuery(q);
            if(params!=null){
                int page = Integer.parseInt(params.getOrDefault("page", "1"));
                int start = (page-1)*PAGE_SIZE;
                query.setMaxResults(PAGE_SIZE);
                query.setFirstResult(start);
            }
            return query.getResultList();
        }
}
