package com.genai.demo1.customer.aggregate;

import com.genai.demo1.customer.valueobject.CustomerStatus;
import com.genai.demo1.customer.valueobject.PersonalInformation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Customer {


    @Id
    @GeneratedValue
    private UUID id;

    @Embedded
    private PersonalInformation personalInformation;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;


    public Customer(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
        this.status = CustomerStatus.VALID;
    }

}
