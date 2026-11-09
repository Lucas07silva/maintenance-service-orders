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

public class Falha {
    @Id
    private String id;
    private String categoria;
    private String sintoma;
    private String gravidade;

    public Falha() {}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) { 
        this.categoria = categoria; 
    }
    public String getSintoma() { 
        return sintoma; 
    }
    public void setSintoma(String sintoma) { 
        this.sintoma = sintoma; 
    }
    public String getGravidade() { 
        return gravidade; 
    }
    public void setGravidade(String gravidade) { 
        this.gravidade = gravidade; 
    }
}
