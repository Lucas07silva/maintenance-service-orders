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

public class Atividade {
    @Id
    private String id;
    private String descricao;
    private Boolean concluida;

    public Atividade() {}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public String getDescricao() { 
        return descricao; 
    }
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    public Boolean getConcluida() { 
        return concluida; 
    }
    public void setConcluida(Boolean concluida) { 
        this.concluida = concluida; 
    }
}
