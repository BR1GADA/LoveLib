package org.peachSpring.app.repositories;

import org.peachSpring.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByNameIgnoreCase( String name);




}
