package com.genai.demo1.customer.valueobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformation {

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
    @NotBlank
    @Size(min = 2, max = 50)
    private String surname;

    @JsonInclude(NON_NULL)
    private String secondSurname;

    @NotBlank
    private String address;
    @NotBlank
    private String identificationNumber;

}
