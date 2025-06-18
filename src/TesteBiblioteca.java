public class TesteBiblioteca {
    public static void main(String[] args) {
        // Teste CPF
        System.out.println("CPF válido: " + Validacoes.validarCPF("11144477735"));
        System.out.println("CPF inválido: " + Validacoes.validarCPF("11111111111"));

        System.out.println("CPF formatado: " + Validacoes.imprimeCPF("11144477735"));

        // Teste Email
        System.out.println("Teste Válido:");
        testarEmail("usuario@dominio.com", true);
        testarEmail("contato.123@meu-servidor.co.uk", true);
        testarEmail("nome_sobrenome@email.org", true);

        System.out.println("\nTeste Inválido:");
        testarEmail("emailsemarroba.com", false);
        testarEmail("usuario@", false);
        testarEmail("@dominio.com", false);
        testarEmail("usuario@dominio.com", false);
        testarEmail("usuario @dominio.com", false);
        testarEmail("usuario@dominio.c", false);
        testarEmail("", false);
        testarEmail(null, false);


        System.out.println("TESTE VÁLIDO:");
        testarCNPJ("11.444.777/0001-61", true);
        testarCNPJ("11444777000161", true);
        testarCNPJ("33.683.111/0002-80", true);

        System.out.println("\nTESTE INVÁLIDO:");
        testarCNPJ("11.111.111/1111-11", false);
        testarCNPJ("11.444.777/0001-00", false);
        testarCNPJ("123456", false);
        testarCNPJ("abcdefghijklmn", false);
        testarCNPJ(null, false);

        System.out.println("TESTE VÁLIDO:");
        testarTelefone("(18) 99999-8888", true);
        testarTelefone("1833334444", true);
        testarTelefone("(11) 2222-3333", true);
        testarTelefone("11987654321", true);


        System.out.println("\nTESTE INVÁLIDO:");
        testarTelefone("12345", false);
        testarTelefone("(18) 1234-567", false);
        testarTelefone("998887766", false);
        testarTelefone("telefone", false);
        testarTelefone(null, false);

        System.out.println("TESTE VÁLIDO (CEP da Av. Paulista):");
        Endereco enderecoValido = Validacoes.consultarCEP("01310-930");
        if (enderecoValido != null) {
            System.out.println("  Endereço encontrado: " + enderecoValido.logradouro() + ", " + enderecoValido.localidade() + " - " + enderecoValido.uf());
            System.out.println("  Status: OK");
        } else {
            System.out.println("  Endereço não encontrado. Status: FALHOU!");
        }

        System.out.println("\nTESTE INVÁLIDO (CEP que não existe):");
        Endereco enderecoInvalido = Validacoes.consultarCEP("99999999");
        if (enderecoInvalido == null) {
            System.out.println("  Endereço corretamente não encontrado.");
            System.out.println("  Status: OK");
        } else {
            System.out.println("  Endereço encontrado indevidamente. Status: FALHOU!");
        }
    }

    public static void testarEmail(String email, boolean resultadoEsperado) {
        boolean resultadoReal = Validacoes.validarEmail(email);
        String status = (resultadoReal == resultadoEsperado) ? "OK" : "FALHOU!";

        System.out.println("  Email: '" + email + "' | Esperado: " + resultadoEsperado + " | Recebido: " + resultadoReal + " | Status: " + status);
    }

    public static void testarCNPJ(String cnpj, boolean resultadoEsperado) {
        // Remove a formatação para exibir um log mais limpo se quiser
        String cnpjLimpo = (cnpj != null) ? cnpj.replaceAll("[^0-9]", "") : "null";

        boolean resultadoReal = Validacoes.validarCnpj(cnpj);
        String status = (resultadoReal == resultadoEsperado) ? "OK" : "FALHOU!";

        System.out.println("  CNPJ: '" + cnpjLimpo + "' | Esperado: " + resultadoEsperado + " | Recebido: " + resultadoReal + " | Status: " + status);
    }

    public static void testarTelefone(String telefone, boolean resultadoEsperado) {
        boolean resultadoReal = Validacoes.validarTelefone(telefone);
        String status = (resultadoReal == resultadoEsperado) ? "OK" : "FALHOU!";
        System.out.println("  Telefone: '" + telefone + "' | Esperado: " + resultadoEsperado + " | Recebido: " + resultadoReal + " | Status: " + status);
    }




}
