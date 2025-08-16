# Java Validation BR

**Validações Essenciais para Seus Projetos Java**


## Sobre o Projeto

A biblioteca ValidacoesUteis foi desenvolvida para otimizar e simplificar o processo de validação de dados em projetos Java. Com um conjunto de métodos estáticos prontos para uso, ela oferece uma solução centralizada e eficiente para as validações mais comuns no desenvolvimento de software, como CPF, CNPJ, e-mail, telefone e CEP. O objetivo é facilitar o trabalho do desenvolvedor, tornando o código mais limpo e seguro.


### Funcionalidades

1. [Validação de CPF](#Validação-de-CPF)
2. [Validação de CNPJ](#Validação-de-CNPJ)
3. [Validação de E-mail](#Validação-de-Email)
4. [Validação de Telefone](#validação-de-telefone)
5. [Validação de CEP](#validação-de-cep)


### Tecnologias

Java
java.net.http` (para requisições HTTP)
org.json` (para manipulação de JSON)


## Como Usar

A utilização da biblioteca é simples, pois todos os métodos são estáticos. Basta importar a classe e chamar o método desejado.

### Validação de CPF

Verifica a validade de um CPF com base nos dígitos verificadores.

```java
import static Validacoes.validarCPF;

public class CPFExample {
    public static void main(String[] args) {
        // Validação de CPF
        String cpf = "123.456.789-00";
        boolean isValidCpf = validarCPF(cpf);
        System.out.println("CPF " + cpf + " é válido? " + isValidCpf); // Exemplo: false
    }
}
```
### Validação de CNPJ

Faz a validação de um CNPJ de acordo com as regras oficiais.


```java
import static Validacoes.validarCnpj;

public class CNPJExample {
    public static void main(String[] args) {
        //Validação de CNPJ
        String cnpj = "11.222.333/0001-44";
        boolean isValidCnpj = validarCnpj(cnpj);
        System.out.println("CNPJ " + cnpj + " é válido? " + isValidCnpj);
    }
}
                        
```

### Validação de Email

Garante que o formato de um endereço de e-mail está correto.


```java
import static Validacoes.validarEmail;

public class EmailExample {
    public static void main(String[] args) {
        // Validação de E-mail
        String email = "contato@exemplo.com";
        boolean isValidEmail = validarEmail(email);
        System.out.println("E-mail " + email + " é válido? " + isValidEmail); // Exemplo: true
        }
    }

```
### Validação de Telefone

Checa se a quantidade de dígitos de um número de telefone é válida.


````java
import static Validacoes.validarTelefone;

public class TelefoneExample {
    public static void main(String[] args) {
        // Validação de Telefone
        String telefone = "(11) 98765-4321";
        boolean isValidTelefone = validarTelefone(telefone);
        System.out.println("Telefone " + telefone + " é válido? " + isValidTelefone); // Exemplo: true

    }

}

````
### Validação de CEP

Consulta a API do ViaCEP para buscar e validar um endereço.


````java
import static Validacoes.consultarCEP;
public class CEPExample {
    public static void main(String[] args) {
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

````




## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
