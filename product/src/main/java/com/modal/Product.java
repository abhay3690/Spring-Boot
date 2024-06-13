

package com.modal;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Column(name = "name", length = 20)
    private String ptitle;

    @Column(name = "price", length = 20)
    private String price;

    @Column(name = "image", length = 20)
    private String pimage;

    @Column(name = "discription", length = 100)
    private String pdiscription;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "product_seller", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "seller_id"))
    private List<Seller> sellers = new ArrayList<>();
}

//package com.modal;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Product {
//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int pid;
//	@Column(name = "name", length = 20)
//	private String ptitle;
//	@Column(name = "price", length = 20)
//	private String price;
//	@Column(name = "image", length = 20)
//	private String pimage;
//	@Column(name = "discription", length = 100)
//	private String pdiscription;
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "product_seller", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "seller_id"))
//	private List<Seller> sellers = new ArrayList<>();
//
//}
