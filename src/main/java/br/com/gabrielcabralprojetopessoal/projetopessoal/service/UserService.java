package br.com.gabrielcabralprojetopessoal.projetopessoal.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielcabralprojetopessoal.projetopessoal.domain.User;
import br.com.gabrielcabralprojetopessoal.projetopessoal.domain.UserDTO;
import br.com.gabrielcabralprojetopessoal.projetopessoal.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO) {
        User existingUser = userRepository.findByUserName(userDTO.getUserName());
        User existingEmail = userRepository.findByEmail(userDTO.getEmail());

        if (existingUser != null) {
            throw new IllegalArgumentException("Usuário informado já cadastrado! ");
        } else if (existingEmail != null) {
            throw new EntityNotFoundException("Email informado já cadastrado! ");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setHeight(userDTO.getHeight());
        user.setWeight(userDTO.getWeight());
        user.setPhone(userDTO.getPhone());

        return userRepository.save(user);
    }

    public List<UserDTO> listUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .toList();
    }

    public User updatUser(UUID id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setName(userDTO.getName());
            user.setPhone(userDTO.getPhone());
            user.setHeight(userDTO.getHeight());
            user.setWeight(userDTO.getWeight());
            user.setPassWord(userDTO.getPassword());

            return userRepository.save(user);
        }else {
           throw new EntityNotFoundException("Usuário não encontrado!");
        }
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
