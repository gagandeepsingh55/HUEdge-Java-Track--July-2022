package com.hashkart.payment.repository;

import com.hashkart.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query(value = "select id from payment where orderid = :id",nativeQuery = true)
    Payment findStatusbyOrderId(@Param("id") int id);
}
