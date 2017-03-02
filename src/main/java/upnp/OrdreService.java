/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upnp;

import display.Etat;
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
        serviceId = @UpnpServiceId("OrdreService"),
        serviceType = @UpnpServiceType(value = "OrdreService", version = 1)
)
public class OrdreService {
    private final PropertyChangeSupport propertyChangeSupport;
    
    public OrdreService(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public PropertyChangeSupport getPropertyChangeSupport(){
        return propertyChangeSupport;
    }
    
    @UpnpStateVariable(defaultValue = "Deverouille", sendEvents = false)
    private Etat target = Etat.Deverouille;
	
    @UpnpStateVariable(defaultValue = "Deverouille")
    private Etat status = Etat.Deverouille;
    
    @UpnpAction
    public void setTarget(@UpnpInputArgument(name = "NewTargetValue") String newTargetValue){
        Etat targetOldValue = target;
        Etat statusOldValue = status;
        Etat newActionValue = null;
        if(newTargetValue.compareTo("CENTRE") == 0){
            if(statusOldValue == Etat.Deverouille)
                newActionValue = Etat.Verouille;
            else if(statusOldValue == Etat.Verouille)
                newActionValue = Etat.Deverouille;
            status = newActionValue;
            target = status;
            getPropertyChangeSupport().firePropertyChange("target", targetOldValue, target);
            getPropertyChangeSupport().firePropertyChange("status", statusOldValue, status);
            
            getPropertyChangeSupport().firePropertyChange("Status", statusOldValue, status);
        }
    }
}
