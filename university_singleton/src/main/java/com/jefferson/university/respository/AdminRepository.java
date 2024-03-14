package com.jefferson.university.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jefferson.university.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
}
