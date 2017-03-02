/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upnp;

import java.beans.PropertyChangeSupport;
import org.fourthline.cling.binding.annotations.UpnpAction;
import org.fourthline.cling.binding.annotations.UpnpInputArgument;
import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;
import org.fourthline.cling.binding.annotations.UpnpStateVariable;

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
    private int valeur = 100;
	
    @UpnpStateVariable(defaultValue = "100")
    private int status = 100;
    
    @UpnpAction
    public void setValeur(@UpnpInputArgument(name = "NewValeur") int newValeur){
        int oldValeur = valeur;
        int oldStatus = status;
        valeur = newValeur;
        status = newValeur;
        
        getPropertyChangeSupport().firePropertyChange("valeur", oldValeur, valeur);
        getPropertyChangeSupport().firePropertyChange("status", oldStatus, status);
            
        //getPropertyChangeSupport().firePropertyChange("Status", oldStatus, status);
    }
}
