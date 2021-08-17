package com.frknuzn.accounts.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_address")
    private String accountAddress;

    @Column(name = "account_phone_number")
    private String accountPhoneNumber;

    @CreatedDate
    @Column(name = "create_dt")
    private LocalDate createDt;

}
