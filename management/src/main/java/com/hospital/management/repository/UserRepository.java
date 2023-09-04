package com.hospital.management.repository;

import com.hospital.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByUserName(String userName);
    User findByToken(String token);
    User findByUserType(String usertype);
    @Query(value = "Select * from users a where a.speciality_id=?1", nativeQuery = true)
    List<User> findBySpeciality(Long id);
}
