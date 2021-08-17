package com.frknuzn.phones.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class PhoneEvent {

    @Id
    @GeneratedValue
    private Integer phoneEventId;

    @OneToOne(mappedBy = "phoneEvent", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private Phone phone;
}
