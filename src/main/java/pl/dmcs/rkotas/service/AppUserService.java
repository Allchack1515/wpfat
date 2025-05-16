package pl.dmcs.rkotas.service;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.rkotas.domain.AppUser;
import java.util.List;

public interface AppUserService {

    @Secured("ROLE_ADMIN")
    void addAppUser(AppUser appUser);

    @PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")
    void editAppUser(@Param("appUser")AppUser appUser);

    List<AppUser> listAppUser();

    @Secured("ROLE_ADMIN")
    void removeAppUser (long id);
    AppUser getAppUser(long id);
    AppUser findByLogin(String login);


    void activateInactiveAppUsers();
}

