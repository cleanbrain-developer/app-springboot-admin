package com.cleanbrain.appspringbootadmin.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-14
 * Comments: 사용자 Entity
 * </pre>
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long groupId;
    private String name;
    private String description;
    @Builder.Default
    private Date createDate = new Date();
    @Builder.Default
    private Date updateDate = new Date();
}
