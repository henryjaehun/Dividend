package com.dayone.persist;

import com.dayone.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // 아이디를 기준으로 회원정보를 찾기위해서 사용
    Optional<MemberEntity> findByUsername(String username);

    // 회원가입을 할 때 이미 존재하는 아이디인지 확잉용
    boolean existsByUsername(String username);
}
