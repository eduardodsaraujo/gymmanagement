package br.com.fiap.gymmanagement.members.domain.repositories;

import br.com.fiap.gymmanagement.members.domain.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
