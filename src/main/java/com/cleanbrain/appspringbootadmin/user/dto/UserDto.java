package com.cleanbrain.appspringbootadmin.user.dto;

import com.cleanbrain.appspringbootadmin.user.model.AppUser;
import lombok.Setter;

import java.util.Date;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-14
 * Comments: 사용자 Dto
 * </pre>
 */
@Setter
public class UserDto {
    private Long id;
    private Long groupId;
    private String name;
    private String description;
    private Date createDate;
    private Date updateDate;

    public AppUser toEntity() {
        return AppUser.builder()
                .id(this.id)
                .groupId(this.groupId)
                .name(this.name)
                .description(this.description)
                .build();
    }
}
