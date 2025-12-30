package com.br.ordofy.ordofy_api.entities;

import java.util.ArrayList;
import java.util.List;

public class Professional {
    private Integer id;
    private String name;

    private Business business;
    private List<ProfessionalService> serviceList = new ArrayList<>();

}
