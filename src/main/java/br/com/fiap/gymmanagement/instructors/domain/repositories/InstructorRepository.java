package br.com.fiap.gymmanagement.instructors.domain.repositories;

import br.com.fiap.gymmanagement.instructors.domain.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
