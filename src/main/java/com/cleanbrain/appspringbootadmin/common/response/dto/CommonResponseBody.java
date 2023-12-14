package com.cleanbrain.appspringbootadmin.common.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-14
 * Comments:
 * </pre>
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class CommonResponseBody {
    @Builder.Default
    private boolean success = true;
    private String code;
    private Object result;
}
