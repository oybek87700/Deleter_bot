package com.example.deleterbot.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupId;
    private String groupName;
    private String groupUserName;

    public Groups(String groupId, String groupName, String groupUserName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupUserName = groupUserName;
    }
}
