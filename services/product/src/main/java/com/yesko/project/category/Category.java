package com.yesko.project.category;

import com.yesko.project.product.Product;
import jakarta.persistence.*;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "t_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category" ,cascade = CascadeType.REMOVE)
    private List<Product> productList;
}
