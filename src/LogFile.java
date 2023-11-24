public class LogFile {
    

    public static void main(String[] args) {
        String line = "uni - - [aa] \"GET // \" http\" 200 3985";
        String[] array = line.split(" ");

        for (String string : array) {
            System.out.println(string);
        }

        

        

    }


}
