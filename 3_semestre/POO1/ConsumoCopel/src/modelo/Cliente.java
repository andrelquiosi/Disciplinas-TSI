package modelo;

import java.util.Objects;

public class Cliente {


    private String nome;
    private String sexo;
    private String endereco;
    private String cep;
    private String bairro;
    private String cpf;
    private String nascimento;
    private String data_vencimento;
    private String unidade_consumidora;
    private String email;
    private String kwh;
    private String valor_total;
    private int id_cliente;

    public Cliente() {
    }

    public Cliente(String nome, String sexo, String endereco, String cep, String bairro, String cpf, String nascimento, String data_vencimento, String unidade_consumidora, String email, String kwh, String valor_total) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.data_vencimento = data_vencimento;
        this.unidade_consumidora = unidade_consumidora;
        this.email = email;
        this.kwh = kwh;
        this.valor_total = valor_total;
    }

    public Cliente(String nome, String cpf, String data_vencimento, String unidade_consumidora, String kwh, String valor_total, int id_cliente) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_vencimento = data_vencimento;
        this.unidade_consumidora = unidade_consumidora;
        this.kwh = kwh;
        this.valor_total = valor_total;
        this.id_cliente = id_cliente;
    }


//GETHERS
    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public String getUnidade_consumidora() {
        return unidade_consumidora;
    }
    
    public String getEmail() {
        return email;
    }

    public String getKwh() {
        return kwh;
    }

    public String getValor_total() {
        return valor_total;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    
    //SETTERS

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public void setUnidade_consumidora(String unidade_consumidora) {
        this.unidade_consumidora = unidade_consumidora;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKwh(String kwh) {
        this.kwh = kwh;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.sexo);
        hash = 37 * hash + Objects.hashCode(this.endereco);
        hash = 37 * hash + Objects.hashCode(this.cep);
        hash = 37 * hash + Objects.hashCode(this.bairro);
        hash = 37 * hash + Objects.hashCode(this.cpf);
        hash = 37 * hash + Objects.hashCode(this.nascimento);
        hash = 37 * hash + Objects.hashCode(this.data_vencimento);
        hash = 37 * hash + Objects.hashCode(this.unidade_consumidora);
        hash = 37 * hash + Objects.hashCode(this.kwh);
        hash = 37 * hash + Objects.hashCode(this.valor_total);
        hash = 37 * hash + this.id_cliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.data_vencimento, other.data_vencimento)) {
            return false;
        }
        if (!Objects.equals(this.unidade_consumidora, other.unidade_consumidora)) {
            return false;
        }
        if (!Objects.equals(this.kwh, other.kwh)) {
            return false;
        }
        return Objects.equals(this.valor_total, other.valor_total);
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", sexo=" + sexo + ", endereco=" + endereco + ", cep=" + cep + ", bairro=" + bairro + ", cpf=" + cpf + ", nascimento=" + nascimento + ", data_vencimento=" + data_vencimento + ", unidade_consumidora=" + unidade_consumidora + ", kwh=" + kwh + ", valor_total=" + valor_total + ", id_cliente=" + id_cliente + '}';
    }



}
