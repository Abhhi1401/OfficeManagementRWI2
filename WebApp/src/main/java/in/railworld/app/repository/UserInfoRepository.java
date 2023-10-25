package in.railworld.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.railworld.app.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {




	Optional<UserInfo> findByName(String username);

}
