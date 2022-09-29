package misiontic2022.com.laplaza.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import misiontic2022.com.laplaza.Entity.Producer;
import java.util.List;


public interface IProducerRepository extends JpaRepository<Producer, Long> {
    
    @Query("FROM Producer r WHERE r.name LIKE :title")
    public List<Producer> findByNameContaining(@Param("title") String title);

    @Query("FROM Producer r WHERE r.celular LIKE :celular")
    public List<Producer> findByCelular(@Param("celular") Integer celular);

    @Query("FROM Producer r ORDER BY name ASC")
    public List<Producer> findAllSortByName();
    
}
