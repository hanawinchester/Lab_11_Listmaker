import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";
        displayList();

        do {
            String listAddition = "";
            //int listDeletion;
            //display the list
            //display the menu options
            //get a menu choice
            cmd = SafeInput.getRegExString(console, "\n" + menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            //execute the choice
            switch(cmd)
            {
                case "A":
                    Scanner in1 = new Scanner(System.in);
                    System.out.print("Enter item to add: ");
                    listAddition = in1.nextLine();
                    list.add(listAddition);
                    break;
                case "D":
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Which item index do you want to delete? ");
                    int deletion = SafeInput.getRangedInt(in2, "Which item index do you want to delete?", 1, list.size());
                    //listDeletion = in2.nextInt();
                    //String var = list.get(listDeletion);
                    list.remove(deletion-1);
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    Scanner in3 = new Scanner(System.in);
                    SafeInput.getYNConfirm(in3, "Are you sure you want to quit?");
                    System.exit(0);
                    done = true;
                    break;
            }
            //System.out.println("cmd is " + cmd);
        }
        while (!done);
    }
    private static void displayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println("");
                System.out.printf("%3d%35s", i + 1, list.get(i) );
            }
        }
        else
        {
            System.out.println("+++                          List is empty                           +++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
}