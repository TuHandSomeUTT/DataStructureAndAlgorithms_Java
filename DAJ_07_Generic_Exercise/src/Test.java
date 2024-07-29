public class Test {
    public static void main(String[] args) {
        System.out.println("DICTIONARY\n");
        Dictionary<String, String> stringDictionary = new Dictionary<>("Hola", "Hello");
        System.out.println(stringDictionary.toString());

        // Ví dụ 1: Create dictionary from Spanish to English and English to VietNamse
        Dictionary <String, String> dictionary[] = new Dictionary[6];
        dictionary[0] = new Dictionary<>("Uno", "One");
        dictionary[1] = new Dictionary<>("Siete", "Seven");
        dictionary[2] = new Dictionary<>("Mucho Gusto", "Nice to meet you");
        dictionary[3] = new Dictionary<>("Gracias", "Thanks");
        dictionary[4] = new Dictionary<>("ForeCast", "Dự Báo");
        dictionary[5] = new Dictionary<>("Dictionary", "Từ Điển");

        for (int i = 0; i < dictionary.length; i++) {
            System.out.println(dictionary[i].toString());
        }

        // EXAMPLE 2: Ascii Code Conversion
        Dictionary <Integer, Character> asciiCode[] = new Dictionary[256];
        asciiCode[0] = new Dictionary<>(32, ' ');
        asciiCode[1] = new Dictionary<>(33, '!');
        asciiCode[2] = new Dictionary<>(34, '"');
        asciiCode[3] = new Dictionary<>(35, '#');

        System.out.println("\nASCII CODE\n");
        for (int i = 0; i < 4; i++) {
            System.out.println(asciiCode[i].toString());
        }

        // EXAMPLE 3: BALLON D'OR RANKING - July 2024
        System.out.println("\nBALLON D'OR RANKING - JULY 2024\n");
        Dictionary<String, Double> ballonGold[] = new Dictionary[6];
        ballonGold[0] = new Dictionary<>("Nguyen Van Tu", 9.35);
        ballonGold[1] = new Dictionary<>("Nguyen Tuan Anh", 9.30);
        ballonGold[2] = new Dictionary<>("Nguyen Viet Hung", 9.28);
        ballonGold[3] = new Dictionary<>("Nguyen Van Khai", 9.25);
        ballonGold[4] = new Dictionary<>("Hoang Trung Son", 9.23);
        ballonGold[5] = new Dictionary<>("Nguyen Van Duoc", 8.90);

        System.out.println("   Name " + " : " + " Point");
        for (int i = 0; i < ballonGold.length; i++) {
            System.out.println(ballonGold[i].toString() + " PROBABILITY TOP " + i);
        }
    }
}
