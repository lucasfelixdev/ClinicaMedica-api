package medclinic.api.controller;

import jakarta.validation.Valid;
import medclinic.api.models.medico.DadosCadastroMedico;
import medclinic.api.models.medico.Medico;
import medclinic.api.models.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     //  Indicar que a classe se trata de um controller API
@RequestMapping("/medico")       // URL a qual esse controller irá responder (mapeamento)
public class MedicoController {

    // Instância da interface que contém os métodos JPA para acessar o BD
    @Autowired // Injeção de dependências
    private MedicoRepository repository;
    @PostMapping          //  Para requisições do tipo Post Método
    @Transactional          // Transação ativa com o banco de dados
    // RequestBody para puxar os dados Json do corpo da requisição.
    // Como parâmetro foi passado uma classe Record contendo todos os dados dos requisitos da classe Médico
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
