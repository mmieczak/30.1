package pl.mmieczak.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmieczak.cookbook.domain.Author;
import pl.mmieczak.cookbook.repository.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Optional<Author> findLoginExist(String userName) {
        return Optional.ofNullable(authorRepository.findByFirstnameContainsIgnoreCase(userName));
    }
}
