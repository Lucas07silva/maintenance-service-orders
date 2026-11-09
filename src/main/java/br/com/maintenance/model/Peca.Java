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

@Document(collection = "peca")
public class Peca {
    @Id
    private String id;
    private String name;
    private String code;
    private String manufacturer;
    private String unit;
    private Integer stockQuantity;
    private Integer minimumStock;
    @DocumentReference
    private Peca supplier;

    public Peca() {}

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
    public String getCode() { 
        return code; 
    }
    public void setCode(String code) { 
        this.code = code; 
    }
    public String getManufacturer() { 
        return manufacturer; 
    }
    public void setManufacturer(String manufacturer) { 
        this.manufacturer = manufacturer; 
    }
    public String getUnit() { 
        return unit; 
    }
    public void setUnit(String unit) { 
        this.unit = unit; 
    }
    public Integer getStockQuantity() { 
        return stockQuantity; 
    }
    public void setStockQuantity(Integer stockQuantity) { 
        this.stockQuantity = stockQuantity; 
    }
    public Integer getMinimumStock() { 
        return minimumStock; 
    }
    public void setMinimumStock(Integer minimumStock) { 
        this.minimumStock = minimumStock; 
    }
    public Peca getSupplier() { 
        return supplier; 
    }
    public void setSupplier(Peca supplier) { 
        this.supplier = supplier; 
    }
}
