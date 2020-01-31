package brz.server.msmodel.home.persistence.repositories;

import java.util.List;

import brz.server.msmodel.home.persistence.entities.Home;

public interface HomeAvancedRepository {
	List<Home> query(String attributte, int value);
}
