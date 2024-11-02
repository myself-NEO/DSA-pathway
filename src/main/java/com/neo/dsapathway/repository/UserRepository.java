package com.neo.dsapathway.repository;

import com.neo.dsapathway.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
