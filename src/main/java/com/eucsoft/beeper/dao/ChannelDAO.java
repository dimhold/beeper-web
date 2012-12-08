package com.eucsoft.beeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eucsoft.beeper.model.Channel;

@Component
@Repository
public interface ChannelDAO extends JpaRepository< Channel, Long >{


}
