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

public class LocalizacaoSetor {
    @Id
    private String id;
    private String galpao;
    private String andar;
    private String area;

    public LocalizacaoSetor() {}

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    public String getGalpao() { 
        return galpao; 
    }
    public void setGalpao(String galpao) { 
        this.galpao = galpao; 
    }
    public String getAndar() { 
        return andar; 
    }
    public void setAndar(String andar) { 
        this.andar = andar; 
    }
    public String getArea() { 
        return area; 
    }
    public void setArea(String area) { 
        this.area = area; 
    }
}
