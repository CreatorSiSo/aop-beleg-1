import java.util.Scanner;

public class Hash {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("String to be hashed:");
        String line = in.nextLine();
        int hashCode = 0;
        for (int i = 0; i < line.length(); i += 1) {
            hashCode ^= line.charAt(line.length() - 1 - i) << i;
        }
        System.out.println("Hash code: " + hashCode);
    }
}
