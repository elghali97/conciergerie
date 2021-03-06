package Model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Offer extends Service{
    
    private Integer nbPointMin;
    
    public Offer() {
        
    }
    
    
    public Offer(Person personOffering, String category, String pictures, String nameObject, Date availabilityDate,
            String localisation, String type, int nbPointMin, String description, String priceUnit, String durationUnit, int duration) {
        super(personOffering, null, category, pictures, nameObject, availabilityDate, localisation, type, description, priceUnit, durationUnit, duration);
        this.nbPointMin = nbPointMin;
    }
    
    public int getNbPoint(){
        return nbPointMin;
    }
    
    public void setNbPoint(int nbPointMin) {
        this.nbPointMin = nbPointMin;
    }
    
    public int getNbPointPerDay() {
        if(this.getPriceUnit().equals("minutes")){
            return nbPointMin*60*24;
        }
        else if(this.getPriceUnit().equals("heures")){
            return nbPointMin*24;
        }
        else{
            return nbPointMin;
        }
    
    }
    
}