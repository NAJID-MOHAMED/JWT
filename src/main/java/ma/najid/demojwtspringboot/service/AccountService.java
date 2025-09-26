package ma.najid.demojwtspringboot.service;

import ma.najid.demojwtspringboot.entities.AppRole;
import ma.najid.demojwtspringboot.entities.AppUser;

import java.util.List;


public interface AccountService {
   AppUser addUser(AppUser user);
   AppRole addRole(AppRole role);
   void addRoleToUser(String username, String role);
   AppUser loadUserByUsername(String username);
   List<AppUser>listUsers();
}
