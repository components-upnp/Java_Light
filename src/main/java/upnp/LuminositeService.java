/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upnp;

import java.beans.PropertyChangeSupport;

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
    private final PropertyChangeSupport propertyChangeSupport;
    
    public LuminositeService(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public PropertyChangeSupport getPropertyChangeSupport(){
        return propertyChangeSupport;
    }
    
    @UpnpStateVariable(defaultValue = "100", sendEvents = false)
    private String valeur = "100";
	
    @UpnpStateVariable(defaultValue = "100")
    private String valueStatus = "100";
    
    @UpnpAction(
            name = "SetValeur"
    )
    public void setValeur(@UpnpInputArgument(name = "NewValeur") String newValeur){
        String oldValeur = valeur;
        String oldStatus = valueStatus;
        valeur = newValeur;
        valueStatus = newValeur;
        getPropertyChangeSupport().firePropertyChange("valeur", oldValeur, valeur);
    }

    @UpnpAction(
            name = "GetValeur",
            out = @UpnpOutputArgument(name = "RetValeur")
    )
    public String getValeur(){
       return this.valeur;
    }
}
