package com.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.modal.Product;
import com.modal.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer> {
    List<Seller> findByProduct(Product product);
    List<Seller> findByNameContaining(String name);

    @Query("select s from Seller s where s.name like %:key%")
    List<Seller> searchByTitle(@Param("key") String title);
}


//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.modal.Product;
//import com.modal.Seller;
//
//@Repository
//public interface SellerRepo extends JpaRepository<Seller, Integer>{
//	List<Seller> findByProduct(Product product);
//
//	List<Seller> findByTitleContaining(String title);
//	@Query("select p from Post p where p.title like :key")
//	List<Seller> searchByTitle (@Param("key") String title);
//}
