package br.com.gabrielcabralprojetopessoal.projetopessoal.domain;

import java.util.UUID;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    // Atributos

    private UUID id;
    private String name;
    private String userName;
    private String email;
    private String phone;
    private Double height; // Atura
    private Double weight; // Peso
    private String password;

    // Construtor Vazio
    public UserDTO() {

    }

    // Construtor passando paramentros
    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        userName = user.getUserName();
        email = user.getEmail();
        phone = user.getPhone();
        height = user.getHeight();
        weight = user.getWeight();
        password = user.getPassWord();

    }
}
