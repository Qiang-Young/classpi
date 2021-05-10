package com.example.classchoolsp.repository;

import com.example.classchoolsp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
