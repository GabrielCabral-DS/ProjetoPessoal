package br.com.gabrielcabralprojetopessoal.projetopessoal.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "HEIGHT") // Altura
    private Double height;
    @Column(name = "WEIGHT")
    private Double weight; // Peso
    @Column(name = "PASSWORD")
    private String passWord;

    // Contrutor Vazio

    public User() {

    }

    // Construtor passando parametros

    public User(String name, String userName, String email, String phone, Double height, Double weight,
            String passWord) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
        this.passWord = passWord;
    }

}
