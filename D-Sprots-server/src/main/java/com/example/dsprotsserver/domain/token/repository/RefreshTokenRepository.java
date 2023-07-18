package com.example.dsprotsserver.domain.token.repository;

import com.example.dsprotsserver.domain.token.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
