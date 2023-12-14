package com.cleanbrain.appspringbootadmin.user.controller;

import com.cleanbrain.appspringbootadmin.common.response.dto.CommonResponseBody;
import com.cleanbrain.appspringbootadmin.user.dto.UserDto;
import com.cleanbrain.appspringbootadmin.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-14
 * Comments: 사용자 REST 컨트롤러
 * </pre>
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<CommonResponseBody> createUser(@RequestBody UserDto userDto) {
        this.userService.create(userDto.toEntity());
        return ResponseEntity.ok(CommonResponseBody.builder().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponseBody> readUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(CommonResponseBody.builder()
                .result(this.userService.read(id))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponseBody> updateUser(@RequestBody UserDto userDto) {
        this.userService.update(userDto.toEntity());
        return ResponseEntity.ok(CommonResponseBody.builder().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponseBody> deleteUser(@PathVariable("id") Long id) {
        this.userService.delete(id);
        return ResponseEntity.ok(CommonResponseBody.builder().build());
    }
}

