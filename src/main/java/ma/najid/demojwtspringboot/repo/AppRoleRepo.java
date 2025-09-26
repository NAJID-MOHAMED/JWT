package ma.najid.demojwtspringboot.repo;

import ma.najid.demojwtspringboot.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole,Long> {
   AppRole findByRoleName(String roleName);
}
