import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class Validacoes {

    public static final String VERSAO = "1.3";

    private Validacoes() {
    }


    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)) {
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }


            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validarEmail(String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile((emailRegex));
        return pattern.matcher(email).matches();

    }


    public static String imprimeCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return "CPF inválido";
        }
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    public static boolean validarCnpj(String cnpj) {
        if (cnpj == null) {
            return false;
        }

        cnpj = cnpj.replaceAll("[^0-9]", "");
        if (cnpj.length() != 14) {
            return false;
        }
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        try {
            int soma = 0;
            int peso = 2;
            for (int i = 11; i >= 0; i--) {
                int num = (int) (cnpj.charAt(i) - 48);
                soma += num * peso;
                peso++;
                if (peso == 10) {
                    peso = 2;
                }
            }
            int resto = soma % 11;
            char dig13 = (resto < 2) ? '0' : (char) ((11 - resto) + 48);

            soma = 0;
            peso = 2;
            for (int i = 12; i >= 0; i--) {
                int num = (int) (cnpj.charAt(i) - 48);
                soma += num * peso;
                peso++;
                if (peso == 10) {
                    peso = 2;
                }
            }

            resto = soma % 11;
            char dig14 = (resto < 2) ? '0' : (char) ((11 - resto) + 48);

            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));

        } catch (Exception e) {
            return false;
        }

    }

    public static boolean validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            return false;
        }

            String digitos = telefone.replaceAll("[^0-9]", "");

            return digitos.length() == 10 || digitos.length() == 11;
        }

    public static Endereco consultarCEP(String cep){
        if (cep == null || cep.replaceAll("[^0-9]", "").length() != 8) {
            return null;
        }
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.err.println("Erro na consulta do CEP: Código de status" + response.statusCode());
                return  null;
            }

            JSONObject jsonResponse = new JSONObject(response.body());

            if (jsonResponse.has("erro") && jsonResponse.getBoolean("erro")) {
                return null;
            }

            return new Endereco(
                    jsonResponse.optString("cep", ""),
                    jsonResponse.optString("logradouro", ""),
                    jsonResponse.optString("complemento", ""),
                    jsonResponse.optString("bairro", ""),
                    jsonResponse.optString("localidade", ""),
                    jsonResponse.optString("uf", ""),
                    jsonResponse.optString("ibge", ""),
                    jsonResponse.optString("gia", ""),
                    jsonResponse.optString("ddd", ""),
                    jsonResponse.optString("siafi", "")
            );

        }catch (Exception e) {
            System.err.println("Ocorreu um erro ao consultar o CEP: " + e.getMessage());
            return null;
        }

    }
    }



