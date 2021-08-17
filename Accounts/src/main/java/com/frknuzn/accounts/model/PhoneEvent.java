package com.frknuzn.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneEvent {

    private Integer phoneEventId;

    @NotNull
    @Valid
    private Phone phone;
}
