package com.Twitter.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Twitter.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
