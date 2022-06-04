package com.example.deleterbot.repository;

import com.example.deleterbot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByChatId(String chatId);

    @Query(value = "select max(id) from users ", nativeQuery = true)
    Integer getMax();
}
