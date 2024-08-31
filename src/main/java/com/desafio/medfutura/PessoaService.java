package com.desafio.medfutura;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }
    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public Optional<Pessoa> buscarPessoaPorId(Long id){
        return pessoaRepository.findById(id);
    }
    public List<Pessoa> buscarPessoasPorTermo(String termo){
        return pessoaRepository.findByTermo(termo);
    }
    public Pessoa atualizarPessoa(Long id,Pessoa pessoaAtualizada) throws Exception {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setApelido(pessoaAtualizada.getApelido());
                    pessoa.setNome(pessoaAtualizada.getNome());
                    pessoa.setNascimento(pessoaAtualizada.getNascimento());
                    pessoa.setStack(pessoaAtualizada.getStack());
                    return pessoaRepository.save(pessoa);
                })
                .orElseThrow(() -> new Exception("Pessoa não encontrada com o id " + id));
    }

    public void excluirPessoa(Long id){
        pessoaRepository.deleteById(id);
    }
}

