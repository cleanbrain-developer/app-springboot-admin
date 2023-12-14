package com.cleanbrain.appspringbootadmin.user.service;

import com.cleanbrain.appspringbootadmin.user.model.AppUser;
import com.cleanbrain.appspringbootadmin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * User: clean_brain
 * Date: 2023-12-14
 * Comments: 사용자 Service
 * </pre>
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(AppUser appUser) {
        this.userRepository.create(appUser);
    }

    public AppUser read(Long id) {
        return this.userRepository.read(id);
    }

    public void update(AppUser updatedAppUser) {
        this.userRepository.update(updatedAppUser);
    }

    public void delete(Long id) {
        this.userRepository.delete(id);
    }
}
