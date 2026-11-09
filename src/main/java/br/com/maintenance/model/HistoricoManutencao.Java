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

@Document(collection = "historico_manutencao")
public class HistoricoManutencao {
    @Id
    private String id;
    @DocumentReference
    private Peca equipment;
    @DocumentReference
    private Peca serviceOrder;
    private LocalDateTime maintenanceDate;
    private String maintenanceType;
    private String description;
    @DocumentReference
    private Peca technician;
    private String observations;

    public HistoricoManutencao() {}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public Peca getEquipment() { 
        return equipment; 
    }
    public void setEquipment(Peca equipment) { 
        this.equipment = equipment; 
    }
    public Peca getServiceOrder() { 
        return serviceOrder; 
    }
    public void setServiceOrder(Peca serviceOrder) { 
        this.serviceOrder = serviceOrder; 
    }
    public LocalDateTime getMaintenanceDate() { 
        return maintenanceDate; 
    }
    public void setMaintenanceDate(LocalDateTime maintenanceDate) { 
        this.maintenanceDate = maintenanceDate; 
    }
    public String getMaintenanceType() { 
        return maintenanceType; 
    }
    public void setMaintenanceType(String maintenanceType) { 
        this.maintenanceType = maintenanceType; 
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    public Peca getTechnician() { 
        return technician; 
    }
    public void setTechnician(Peca technician) { 
        this.technician = technician; 
    }
    public String getObservations() { 
        return observations; 
    }
    public void setObservations(String observations) { 
        this.observations = observations; 
    }
}
