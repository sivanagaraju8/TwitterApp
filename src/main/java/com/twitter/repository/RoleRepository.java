package com.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitter.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
