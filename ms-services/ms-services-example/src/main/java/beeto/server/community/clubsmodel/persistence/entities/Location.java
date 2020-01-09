package beeto.server.community.clubsmodel.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    private String id;
	private String number;
    private String street; //via
    private String postalCode; //codigopostal
   
    @Column(nullable=false)
    private String poblacion; //poblcacion
   
    @Column(nullable=false)
    private String provincia; //provincia
    
    private String comunidadAutonoma;
	
}
