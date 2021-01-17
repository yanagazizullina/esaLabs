package com.example.esa.repository;

import com.example.esa.model.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Integer> {
}
