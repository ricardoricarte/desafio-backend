
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.josericardo.seasolutions.models.Cargo;
import com.josericardo.seasolutions.models.Setor;
import com.josericardo.seasolutions.models.Trabalhador;
import com.josericardo.seasolutions.services.TrabalhadorService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TrabalhadorServiceTest {

    @Autowired
    private TrabalhadorService service;

    @Test
    void adicionarTrabalhadorComNomeCpfSetorCargo() {
        // Crie um setor
        Setor setor = new Setor();
        setor.setId(1L);
        setor.setNome("Setor de TI");

        // Crie um cargo
        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setNome("Desenvolvedor");

        // Crie um trabalhador com nome, CPF, setor e cargo
        Trabalhador trabalhador = new Trabalhador();
        trabalhador.setId(1L);
        trabalhador.setNome("Jose Ricardo");
        trabalhador.setCpf("12345678900");
        trabalhador.setSetor(setor);
        trabalhador.setCargo(cargo);

        // Chame o método que você deseja testar
        service.adicionarTrabalhador(trabalhador);

        // Verifique se o trabalhador foi adicionado com sucesso
        List<Trabalhador> listaTrabalhadores = service.procurarTodosTrabalhadores();
        
        // Verifique se a lista de trabalhadores não está vazia
        assertEquals(1, listaTrabalhadores.size());
        
        // Verifique se o trabalhador adicionado é igual ao que foi criado
        Trabalhador trabalhadorAdicionado = listaTrabalhadores.get(0);
        assertEquals("Jose Ricardo", trabalhadorAdicionado.getNome());
        assertEquals("12345678900", trabalhadorAdicionado.getCpf());
        assertEquals("Setor de TI", trabalhadorAdicionado.getSetor().getNome());
        assertEquals("Desenvolvedor Java", trabalhadorAdicionado.getCargo().getNome());
    }
}
