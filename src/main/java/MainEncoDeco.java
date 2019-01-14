public class MainEncoDeco {

    public static void main(String[] args) {
        MainEncoDeco mainEncoDeco = new MainEncoDeco();
        mainEncoDeco.entrypoint();
    }

    private void entrypoint() {
        final String fileToBeEncoded = "data.jpg";
        final String fileToBeDecoded = "EncodedFile.txt";
        FileEncoder encoder = new FileEncoder();
        FileDecoder decoder = new FileDecoder();
        boolean status = encoder.fileToBase64StringConversion(fileToBeEncoded);
        if (status) {
            System.out.println("Encoding Completed Successfully");
            System.out.println("Starting Decoding");
            boolean decoderStatus = decoder.fileToBase64Decoder(fileToBeDecoded);
            if (decoderStatus) {
                System.out.println("File Decoded");

            }
        }
    }
}
