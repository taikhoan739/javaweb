/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhm.repositories.Impl;

import com.mycompany.hibernatedemov1.HibernateUtils;
import com.nhm.pojo.OrderDetail;
import com.nhm.pojo.Product;
import com.nhm.pojo.SaleOrder;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class StatsRepositoryImpl {
    public List<Object> getRevenue(int month){
        try(Session s = HibernateUtils.getFACTORY().openSession()){
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
             Root root = q.from(SaleOrder.class);
             Join<SaleOrder,OrderDetail> join = root.join("order_id",JoinType.RIGHT);
             q.multiselect(root.get("id"),builder.sum(builder.prod(join.get("unitPrice"), join.get("quantity"))), join.get("createdDate"));
                
            Query query =s.createQuery(q);
            return query.getResultList();
        }
    }
}
