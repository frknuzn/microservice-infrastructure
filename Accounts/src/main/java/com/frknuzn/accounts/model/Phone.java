package com.frknuzn.accounts.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;


@Data
@ToString
public class Phone {

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "phone_brand_name")
    private String phoneBrandName;

    @Column(name = "phone_serial_number")
    private String phoneSerialNumber;

    @CreatedDate
    @Column(name = "create_dt")
    private Date createDt;
}
