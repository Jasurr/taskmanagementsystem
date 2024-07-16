package org.example.taskmanagementsystem.service;

import org.example.taskmanagementsystem.dto.AppUserGetDto;
import org.example.taskmanagementsystem.dto.AppUserPostDto;
import org.example.taskmanagementsystem.dto.AuthRequest;
import org.example.taskmanagementsystem.mapper.MapStructMapper;
import org.example.taskmanagementsystem.model.AppUser;
import org.example.taskmanagementsystem.model.UserRoles;
import org.example.taskmanagementsystem.repository.UserRepository;
import org.example.taskmanagementsystem.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final MapStructMapper mapper;

    public UserService(UserRepository userRepository,
                       MapStructMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public AppUserGetDto save(AppUser user) {
        return mapper.appUserGetDto(userRepository.save(user));
    }


    public AppUserGetDto getUserByEmail(String email) {
        Optional<AppUser> appUser = userRepository.findAppUsersByEmail(email);
        if (!appUser.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return mapper.appUserGetDto(appUser.get());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userRepository.findAppUsersByEmail(username);
        if (appUser.isPresent()) {
            Set<SimpleGrantedAuthority> authorities = appUser.get().getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toSet());
            return User
                    .withUsername(appUser.get().getEmail())
                    .password(appUser.get().getPassword())
                    .authorities(authorities)
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }


    public Optional<AppUser> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }
}
