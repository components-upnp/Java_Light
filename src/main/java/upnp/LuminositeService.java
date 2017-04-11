/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upnp;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;

import org.fourthline.cling.binding.annotations.*;

/**
 *
 * @author telly
 */
@UpnpService(
        serviceId = @UpnpServiceId("LuminositeService"),
        serviceType = @UpnpServiceType(value = "LuminositeService", version = 1)
)
public class LuminositeService {

    private ArrayList<String> valeurAutorisee = new ArrayList(Arrays.asList(new AllowedValues().getValues()));
    private final PropertyChangeSupport propertyChangeSupport;
    
    public LuminositeService(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public PropertyChangeSupport getPropertyChangeSupport(){
        return propertyChangeSupport;
    }
    
    @UpnpStateVariable(name ="Valeur" ,defaultValue = "100", sendEvents = false, allowedValueProvider = AllowedValues.class)
    private String valeur = "100";
	
    @UpnpStateVariable(defaultValue = "100", allowedValueProvider = AllowedValues.class)
    private String valueStatus = "100";
    
    @UpnpAction(
            name = "SetValeur"
    )
    public void setValeur(@UpnpInputArgument(name = "NewValeur", stateVariable = "Valeur") String newValeur){
        if (valeurAutorisee.contains(newValeur)) {
            String oldValeur = valeur;
            String oldStatus = valueStatus;
            valeur = newValeur;
            valueStatus = newValeur;
            getPropertyChangeSupport().firePropertyChange("valeur", oldValeur, valeur);
        }
    }

    //Fonction utilisée par l'interface afin de passer au service le véritable état de la lampe
    //Cela permet d'eviter le probleme d'avoir une valeur differente de l'intensite reelle
    //(arrive lorsque l'on change la luminostite alors que la lampe est verouillee)
    public void setTarget(String newValeurTarget) {
        this.valeur = newValeurTarget;
    }

    @UpnpAction(
            name = "GetValeur",
            out = @UpnpOutputArgument(name = "RetValeur")
    )
    public String getValeur(){
       return this.valeur;
    }
}
