package com.springboot.example.jpa.repository;

import com.springboot.example.jpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mark-liu
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
