ValidacoesUteis

Validações Essenciais para Seus Projetos Java


Sobre o Projeto

A biblioteca ValidacoesUteis foi desenvolvida para otimizar e simplificar o processo de validação de dados em projetos Java. Com um conjunto de métodos estáticos prontos para uso, ela oferece uma solução centralizada e eficiente para as validações mais comuns no desenvolvimento de software, como CPF, CNPJ, e-mail, telefone e CEP. O objetivo é facilitar o trabalho do desenvolvedor, tornando o código mais limpo e seguro.


Funcionalidades

Validação de CPF: Verifica a validade de um CPF com base nos dígitos verificadores.
Validação de CNPJ: Faz a validação de um CNPJ de acordo com as regras oficiais.
Validação de E-mail: Garante que o formato de um endereço de e-mail está correto.
Validação de Telefone: Checa se a quantidade de dígitos de um número de telefone é válida.
Validação de CEP: Consulta a API do ViaCEP para buscar e validar um endereço.

Tecnologias

Java
java.net.http` (para requisições HTTP)
org.json` (para manipulação de JSON)

Como Usar

A utilização da biblioteca é simples, pois todos os métodos são estáticos. Basta importar a classe e chamar o método desejado.

Exemplo de Código:
import static Validacoes.validarCPF;
import static Validacoes.validarCnpj;
import static Validacoes.validarEmail;
import static Validacoes.validarTelefone;
import static Validacoes.consultarCEP;

public class ExemploDeUso {
    public static void main(String[] args) {
        // Validação de CPF
        String cpf = "123.456.789-00";
        boolean isValidCpf = validarCPF(cpf);
        System.out.println("CPF " + cpf + " é válido? " + isValidCpf); // Exemplo: false

        // Validação de CNPJ
        String cnpj = "11.222.333/0001-44";
        boolean isValidCnpj = validarCnpj(cnpj);
        System.out.println("CNPJ " + cnpj + " é válido? " + isValidCnpj); // Exemplo: false

        // Validação de E-mail
        String email = "contato@exemplo.com";
        boolean isValidEmail = validarEmail(email);
        System.out.println("E-mail " + email + " é válido? " + isValidEmail); // Exemplo: true

        // Validação de Telefone
        String telefone = "(11) 98765-4321";
        boolean isValidTelefone = validarTelefone(telefone);
        System.out.println("Telefone " + telefone + " é válido? " + isValidTelefone); // Exemplo: true

        // Consulta e Validação de CEP
        String cep = "01001-000";
        Endereco endereco = consultarCEP(cep);
        if (endereco != null) {
            System.out.println("\nEndereço encontrado para o CEP " + cep + ":");
            System.out.println("Rua: " + endereco.getLogradouro());
            System.out.println("Cidade: " + endereco.getLocalidade() + " - " + endereco.getUf());
        } else {
            System.out.println("\nNenhum endereço encontrado para o CEP " + cep);
        }
    }
}

Licença

Este projeto está licenciado sob a Licença MIT.
