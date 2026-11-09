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

@Document(collection = "ordem_servico")
public class OrdemServico {
    @Id
    private String id;
    private String code;
    @DocumentReference
    private Peca equipment;
    @DocumentReference
    private Peca technician;
    private String type;
    private String priority;
    private String status;
    private LocalDateTime openedAt;
    private LocalDateTime scheduledAt;
    private LocalDateTime closedAt;
    private Falha failure;
    private List<Atividade> activities;
    private List<ItemPeca> parts;

    public OrdemServico() {}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public String getCode() { 
        return code; 
    }
    public void setCode(String code) { 
        this.code = code; 
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
    public String getType() { 
        return type; 
    }
    public void setType(String type) { 
        this.type = type; 
    }
    public String getPriority() { 
        return priority; 
    }
    public void setPriority(String priority) { 
        this.priority = priority; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public LocalDateTime getOpenedAt() { 
        return openedAt; 
    }
    public void setOpenedAt(LocalDateTime openedAt) { 
        this.openedAt = openedAt; 
    }
    public LocalDateTime getScheduledAt() { 
        return scheduledAt; 
    }
    public void setScheduledAt(LocalDateTime scheduledAt) { 
        this.scheduledAt = scheduledAt; 
    }
    public LocalDateTime getClosedAt() { 
        return closedAt; 
    }
    public void setClosedAt(LocalDateTime closedAt) { 
        this.closedAt = closedAt; 
    }
    public Falha getFailure() { 
        return failure; 
    }
    public void setFailure(Falha failure) { 
        this.failure = failure; 
    }
    public List<Atividade> getActivities() { 
        return activities; 
    }
    public void setActivities(List<Atividade> activities) { 
        this.activities = activities; 
    }
    public List<ItemPeca> getParts() { 
        return parts; 
    }
    public void setParts(List<ItemPeca> parts) { 
        this.parts = parts; 
    }
}
