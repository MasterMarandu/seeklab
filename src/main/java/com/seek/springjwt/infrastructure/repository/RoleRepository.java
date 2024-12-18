package com.seek.springjwt.infrastructure.repository;

import com.seek.springjwt.domain.Role;
import com.seek.springjwt.utils.RoleEnum;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleEnum name);
}
