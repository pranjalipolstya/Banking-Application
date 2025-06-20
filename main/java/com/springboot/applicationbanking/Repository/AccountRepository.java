package com.springboot.applicationbanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.applicationbanking.Entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
