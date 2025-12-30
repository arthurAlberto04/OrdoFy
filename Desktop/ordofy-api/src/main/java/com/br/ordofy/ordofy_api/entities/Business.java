package com.br.ordofy.ordofy_api.entities;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private Integer id;
    private String name;
    private Address address;
    private Phone phone;

    private List<Professional> professionals = new ArrayList<>();
    private LegalEntity cnpj;
}
