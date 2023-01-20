package com.btrco.springbootlibrary.dao;

import com.btrco.springbootlibrary.entitiy.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findCheckoutsByUserEmail(String userEmail);
}
