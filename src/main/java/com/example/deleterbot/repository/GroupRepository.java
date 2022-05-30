package com.example.deleterbot.repository;

import com.example.deleterbot.entity.Groups;
import com.example.deleterbot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Groups,Long> {
    Optional<Groups> findByGroupId(String chatId);

    @Query(value = "select max(id) from groups ", nativeQuery = true)
    Integer getMax();
}
