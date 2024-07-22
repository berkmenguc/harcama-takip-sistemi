package com.example.spending_tracking_system.repository;

import com.example.spending_tracking_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User , Long> {
    UserDetails findByUserName(String userName);
    User save(User user);

}
