package com.nttdata.banco.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Client document.
 */
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Document (collection = "clients")
public class Client {
    @Id
    public String id;

    //Full name of the client
    private String name;
    //Email of the client
    private String email;
    //Phone of the client
    private String phone;
    //Document (DNI or RUC) of the client
    private String document;
    //Client's type: Person or Business
    private String type;
}
