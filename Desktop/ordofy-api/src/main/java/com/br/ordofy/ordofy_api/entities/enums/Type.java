package com.br.ordofy.ordofy_api.entities.enums;

public enum Type {
    BARBERSHOP(1),
    BEAUTY_SALONS(2),
    AESTHETIC_CLINICS(3);

    private int code;

    private Type(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static Type valueOf(int code){
        for( Type value : Type.values()){
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Type code");
    }
}
