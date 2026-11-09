package br.com.maintenance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "plano_manutencao")
public class PlanoManutencao {
    @Id
    private String id;
    private String name;
    private String description;
    @DocumentReference
    private Peca equipment;
    private Integer frequencyDays;
    private LocalDate nextMaintenance;
    private List<String> activities;
    private String status;

    public PlanoManutencao() {}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    public Peca getEquipment() { 
        return equipment; 
    }
    public void setEquipment(Peca equipment) { 
        this.equipment = equipment; 
    }
    public Integer getFrequencyDays() { 
        return frequencyDays; 
    }
    public void setFrequencyDays(Integer frequencyDays) { 
        this.frequencyDays = frequencyDays; 
    }
    public LocalDate getNextMaintenance() { 
        return nextMaintenance; 
    }
    public void setNextMaintenance(LocalDate nextMaintenance) { 
        this.nextMaintenance = nextMaintenance; 
    }
    public List<String> getActivities() { 
        return activities; 
    }
    public void setActivities(List<String> activities) { 
        this.activities = activities; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
}
