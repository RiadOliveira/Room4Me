package model.VO;

import errors.ValidationException;
import utils.AllowedGender;

public class AspectsVO extends Entity {
    private int bedroomsQuantity;
    private boolean availableToDivide;
    private String description;
    private AllowedGender allowedGender;
    private int capacity;

    public int getBedroomsQuantity() {
        return bedroomsQuantity;
    }
    public String obtainBedroomsQuantityString() {
        String BedroomsQuantityString = String.valueOf(bedroomsQuantity);
        return BedroomsQuantityString;
    }

    public void setBedroomsQuantity(int bedroomsQuantity) throws ValidationException {
        int parsedQuantity = Math.abs(bedroomsQuantity);
        this.bedroomsQuantity = parsedQuantity;
    }

    public boolean getAvailableToDivide() {
        return availableToDivide;
    }

    public String obtainAvailableToDivideText() {
        String availableToDivideString = (availableToDivide) ? "Sim" : "Não";
        return availableToDivideString;
    }

    public void setAvailableToDivide(boolean availableToDivide) {
        this.availableToDivide = availableToDivide;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws ValidationException {
        String propertyName = "description";
        verifyNull(description, propertyName);
        verifyStringLength(description, propertyName);

        this.description = description;
    }

    public AllowedGender getAllowedGender() {
        return allowedGender;
    }

    public void setAllowedGender(AllowedGender allowedGender) {
        this.allowedGender = allowedGender;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public String obtainCapacityString() {
        String CapacityString = String.valueOf(capacity);
        return CapacityString;
    }

    public void setCapacity(int capacity) throws ValidationException {
        int parsedCapacity = Math.abs(capacity);
        this.capacity = parsedCapacity;
    }

    public String dataToText() {
        String textData = "";

        textData += "- Quantidade de quartos: " + bedroomsQuantity + '\n';
		textData += "- Disponível para dividir: " + obtainAvailableToDivideText() + '\n';
		textData += "- Descrição: " + description + '\n';
		textData += "- Gênero permitido: " + allowedGender.toString() + '\n';
		textData += "- Capacidade: " + capacity + '\n';

        return textData;
    }
}
