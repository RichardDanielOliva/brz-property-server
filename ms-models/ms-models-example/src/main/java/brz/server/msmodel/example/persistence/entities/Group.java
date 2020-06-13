package brz.server.msmodel.example.persistence.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "group")
public class Group extends CommunityEntity implements Serializable{
	
}
