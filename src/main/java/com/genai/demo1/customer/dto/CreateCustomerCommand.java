package com.genai.demo1.customer.dto;

import com.genai.demo1.customer.valueobject.PersonalInformation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCustomerCommand {

    @NotNull
    @Valid
    private PersonalInformation personalInformation;
}
