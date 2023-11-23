package ru.dahhwe.lab5.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import ru.dahhwe.lab5.models.User;

import java.util.Collection;

/**
 * Реализация интерфейса UserDetails, предоставляющая информацию о пользователе для Spring Security.
 */
public class UserDetailsImpl implements UserDetails {

    private final User user; // Экземпляр пользователя для которого создается UserDetails.

    /**
     * Конструктор, принимающий пользователя и инициализирующий детали безопасности.
     *
     * @param user Пользователь, для которого будут предоставлены детали безопасности.
     */
    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * Возвращает коллекцию ролей (прав), предоставленных пользователю.
     *
     * @return Коллекция GrantedAuthority, представляющая роли пользователя.
     */
    @Transactional
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    /**
     * Возвращает пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return Имя пользователя.
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Указывает, не истек ли срок учетной записи.
     *
     * @return true, если учетная запись действительна.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; // Можно модифицировать для управления сроком действия учетной записи.
    }

    /**
     * Указывает, не заблокирована ли учетная запись.
     *
     * @return true, если учетная запись не заблокирована.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true; // Можно модифицировать для управления блокировкой учетной записи.
    }

    /**
     * Указывает, не истек ли срок действия учетных данных.
     *
     * @return true, если учетные данные действительны.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Можно модифицировать для управления сроком действия учетных данных.
    }

    /**
     * Указывает, включен ли пользователь.
     *
     * @return true, если пользователь включен.
     */
    @Override
    public boolean isEnabled() {
        return true; // Можно модифицировать для управления активностью пользователя.
    }
}
