package com.frknuzn.phones.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Phone extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_id")
    private int id;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "phone_brand_name")
    private String phoneBrandName;

    @Column(name = "phone_serial_number")
    private String phoneSerialNumber;

    @OneToOne
    @JoinColumn(name = "phoneEventId")
    private PhoneEvent phoneEvent;
}
