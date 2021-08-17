package com.frknuzn.accounts.repository;


import com.frknuzn.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer> {

}
