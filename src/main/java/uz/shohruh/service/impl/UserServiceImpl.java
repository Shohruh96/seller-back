package uz.shohruh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.shohruh.model.Role;
import uz.shohruh.model.User;
import uz.shohruh.repository.UserRepository;
import uz.shohruh.service.UserService;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(user.getPassword());
        user.setRole(Role.USER);
        user.setCreateTime(LocalDate.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional// Transactional is required when executing on update/delete query.
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username, newRole);
    };
}
