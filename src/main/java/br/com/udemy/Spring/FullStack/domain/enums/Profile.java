package br.com.udemy.Spring.FullStack.domain.enums;

public enum Profile {

    ADMIN(1,"ROLE_ADMIN"),
    CLIENT(2,"ROLE_CLIENT");

    private int value;
    private String description;

    Profile(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Profile toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Profile profile : Profile.values()){
            if(cod.equals(profile.getValue())){
                return profile;
            }
        }
        throw new IllegalArgumentException("ID Inválido: " + cod);
    }

    @Override
    public String toString() {
        return "StatePayment{" +
                "value=" + value +
                '}';
    }
}
