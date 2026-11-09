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

@Document(collection = "setor")
public class Setor {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalizacaoSetor location;
    @DocumentReference
    private Peca company;

    public Setor() {}

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
    public LocalizacaoSetor getLocation() { 
        return location; 
    }
    public void setLocation(LocalizacaoSetor location) { 
        this.location = location; 
    }
    public Peca getCompany() { 
        return company; 
    }
    public void setCompany(Peca company) { 
        this.company = company; 
    }
}
