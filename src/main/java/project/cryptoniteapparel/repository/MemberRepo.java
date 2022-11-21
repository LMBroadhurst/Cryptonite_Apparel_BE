package project.cryptoniteapparel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cryptoniteapparel.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {
}
