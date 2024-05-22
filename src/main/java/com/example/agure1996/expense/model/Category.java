package com.example.agure1996.expense.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    private Long id;

    private String name;

    @ManyToOne@Cascade(CascadeType.PERSIST)
    private User user;


}
