package info.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.entity.User;

public interface EmployeeReposetory extends JpaRepository<User, Long> {

}
