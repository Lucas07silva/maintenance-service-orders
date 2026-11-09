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

@Document(collection = "equipamento")
public class Equipamento {
    @Id
    private String id;
    private String name;
    private String assetCode;
    private String model;
    private String manufacturer;
    private String serialNumber;
    private LocalDate installationDate;
    private String status;
    @DocumentReference
    private Peca sector;
    private String notes;

    public Equipamento() {}

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
    public String getAssetCode() { 
        return assetCode; 
    }
    public void setAssetCode(String assetCode) { 
        this.assetCode = assetCode; 
    }
    public String getModel() { 
        return model; 
    }
    public void setModel(String model) { 
        this.model = model; 
    }
    public String getManufacturer() { 
        return manufacturer; 
    }
    public void setManufacturer(String manufacturer) { 
        this.manufacturer = manufacturer; 
    }
    public String getSerialNumber() { 
        return serialNumber; 
    }
    public void setSerialNumber(String serialNumber) { 
        this.serialNumber = serialNumber; 
    }
    public LocalDate getInstallationDate() { 
        return installationDate; 
    }
    public void setInstallationDate(LocalDate installationDate) { 
        this.installationDate = installationDate; 
    }
    public String getStatus() { 
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public Peca getSector() { 
        return sector; 
    }
    public void setSector(Peca sector) { 
        this.sector = sector; 
    }
    public String getNotes() { 
        return notes; 
    }
    public void setNotes(String notes) { 
        this.notes = notes; 
    }
}
