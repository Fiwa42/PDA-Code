public class Library {
    public static void main(String[] args) {
        Book hamster = new Book();
        hamster.setTitle("Programmieren spielend gelernt");
        hamster.setAuthor("D. Boles");
        hamster.publish("3-5190-2297-4", 39.90); // isbn , price

        Book dune = new Book();
        dune.setTitle("Dune");
        dune.setAuthor("F. Herbert");
        dune.publish("0-3409-6019-1", 9.75);

        Book westen = new Book();
        westen.setTitle("Im Westen nichts Neues");
        westen.setAuthor("E.M. Remarque");
        westen.publish("3-4620-4633-0", 13.00);
    }
}
