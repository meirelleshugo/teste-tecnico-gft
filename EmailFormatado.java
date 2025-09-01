
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EmailFormatado {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> emailCounts = new HashMap<>();
        String input;

        while (true) {
            System.out.print("Digite o nome completo (ou 'sair' para encerrar): ");
            input = reader.readLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            String[] nameParts = input.trim().split(" ");
            if (nameParts.length < 2) {
                System.out.println("Erro: digite pelo menos nome e sobrenome.");
                continue;
            }

            String firstName = nameParts[0].toLowerCase();
            String lastName = nameParts[nameParts.length - 1].toLowerCase();

            String emailBase = firstName + "." + lastName;
            int count = emailCounts.getOrDefault(emailBase, 0) + 1;
            emailCounts.put(emailBase, count);

            String email;
            if (count == 1) {
                email = emailBase + "@empresa.com";
            } else {
                email = emailBase + count + "@empresa.com";
            }

            System.out.println("Email gerado: " + email);
        }
    }
}
