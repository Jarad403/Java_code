public class CaesarCipher {

    public CaesarCipher() {
    }

    public String codeCipher(String text) {
        char[] result = new char[text.length()];
        int sign = 0;
        for (char c : text.toCharArray()) {
            result[sign] = (char) ((int) c + text.length());
            sign++;
        }
        return String.valueOf(result);
    }

    public String decodeCipher(String text) {
        char[] result = new char[text.length()];
        int sign = 0;
        for (char c : text.toCharArray()) {
            result[sign] = (char) ((int) c - text.length());
            sign++;
        }
        return String.valueOf(result);
    }
}
