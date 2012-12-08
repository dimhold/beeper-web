package com.eucsoft.beeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eucsoft.beeper.model.User;

@Component
@Repository
public interface UserDAO extends JpaRepository< User, Long >{

	//User findByName( final String name );

}
