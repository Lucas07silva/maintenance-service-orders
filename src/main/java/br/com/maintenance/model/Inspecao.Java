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

@Document(collection = "inspecao")
public class Inspecao {
    @Id
    private String id;
    @DocumentReference
    private Peca equipment;
    @DocumentReference
    private Peca technician;
    private LocalDateTime inspectionDate;
    private String status;
    private List<String> findings;
    private String observations;

    public Inspecao() {}

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
    public Peca getTechnician() { 
        return technician; 
    }
    public void setTechnician(Peca technician) { 
        this.technician = technician; 
    }
    public LocalDateTime getInspectionDate() { 
        return inspectionDate; 
    }
    public void setInspectionDate(LocalDateTime inspectionDate) { 
        this.inspectionDate = inspectionDate; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public List<String> getFindings() { 
        return findings; 
    }
    public void setFindings(List<String> findings) { 
        this.findings = findings; 
    }
    public String getObservations() { 
        return observations; 
    }
    public void setObservations(String observations) { 
        this.observations = observations; 
    }
}
