
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DevCoffee {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Informe o número de devs: ");
        int numberOfDevs = Integer.parseInt(reader.readLine());

        int[] cupsPerDay = new int[numberOfDevs];

        String[] inputs;
        while (true) {
            System.out.print("Quantas xícaras por dia cada um toma (separado por espaço): ");
            inputs = reader.readLine().split(" ");

            if (inputs.length == numberOfDevs) {
                break;
            } else {
                System.out.println("Erro: você deve informar exatamente " + numberOfDevs + " números, um para cada dev.");
            }
        }

        for (int i = 0; i < numberOfDevs; i++) {
            cupsPerDay[i] = Integer.parseInt(inputs[i]);
        }

        int weeklyTotal = 0;
        for (int cups : cupsPerDay) {
            weeklyTotal += cups * 5;
        }

        int stock = 100;

        System.out.println("Total da semana: " + weeklyTotal + " xícaras");
        if (weeklyTotal <= stock) {
            System.out.println("Estoque suficiente!");
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}
