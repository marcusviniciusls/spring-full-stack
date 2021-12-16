package br.com.udemy.Spring.FullStack.domain.enums;

public enum Natureza {    
    PESSOA_FISICA(1),
    PESSOA_JURIDICA(2);
    
    private int valor;

    Natureza(int i) {
        this.valor = i;    
    }

    public int getValor() {
        return valor;
    }
    
    public static Natureza toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Natureza natureza : Natureza.values()){
             if(cod.equals(natureza.getValor())){
                return natureza;    
             }
        }
        
        throw new IllegalArgumentException("ID Inválido: " + cod);
    }
}
