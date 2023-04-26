package com.ecartportal.ecartportal.repository;

import com.ecartportal.ecartportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u.role FROM User u WHERE u.username = :username AND u.password = :password")
    String findRoleByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
