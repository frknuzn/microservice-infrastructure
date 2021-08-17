package com.frknuzn.phones.repository;

import com.frknuzn.phones.model.PhoneEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<PhoneEvent, Integer> {

}
