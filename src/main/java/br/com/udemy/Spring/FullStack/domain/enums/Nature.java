package br.com.udemy.Spring.FullStack.domain.enums;

public enum Nature {
    PESSOA_FISICA(0),
    PESSOA_JURIDICA(1);
    
    private int value;

    Nature(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
    
    public static Nature toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Nature natureza : Nature.values()){
             if(cod.equals(natureza.getValue())){
                return natureza;    
             }
        }
        
        throw new IllegalArgumentException("ID Inválido: " + cod);
    }
}
