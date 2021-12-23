package com.example.course.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entities.Orderitem;

public interface OrderitemRepository extends JpaRepository<Orderitem, Long>{
}
