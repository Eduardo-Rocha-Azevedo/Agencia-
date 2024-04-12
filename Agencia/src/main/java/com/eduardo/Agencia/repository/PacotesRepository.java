import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.eduardo.Agencia.models.Pacotes;

public interface PacotesRepository extends CrudRepository<Pacotes, String>{
    List<Pacotes> findByNome(String nome);
    Pacotes findByCodigo(String codigo);
} 
