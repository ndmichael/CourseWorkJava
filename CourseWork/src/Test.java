import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class Test {
    public static void menu(ArrayList<Tweet> tweets){
        boolean flag = true;
        int choice;
        while (flag){
            String str = JOptionPane.showInputDialog("Enter 1 for input data \n"+ "Enter 2 for search data \n" + "Enter 3 to print all data \n" + "press -1 to terminate.");
            if(str.length() > 0){
                choice = Integer.parseInt(str);
                switch (choice){
                    case 1:
                        inputData(tweets);
                        break;
                    case 2:
                        searchData(tweets);
                        break;
                    case 3:
                        printData(tweets);
                        break;
                    case -1:
                        System.out.println("Program terminated...");
                        flag = false;
                        break;

                    default:
                        System.out.println("Wrong input.");
                }
            }
            else{
                System.out.println("Enter your name: ");
            }
        }

    }

    /*
     * @return void;
     * allows users to input data to be stored in the array
     */
    public static void inputData(ArrayList<Tweet> tweet){
        // declared variables
        int id, count;

        // using JOptionPane to collect inputs from the users.
        JOptionPane.showMessageDialog(null, "Enter your data to be stored.");
        String inp1 = JOptionPane.showInputDialog("Enter tweetID: ");
        String inp2 = JOptionPane.showInputDialog("Enter Likes: ");
        String username = JOptionPane.showInputDialog("Enter Username: ");
        String text = JOptionPane.showInputDialog("Enter Tweet: ");

        // convert inputs from string to int since JOptionPane default to string
        id = Integer.parseInt(inp1);
        count = Integer.parseInt(inp2);

        Tweet obj = new Tweet(id, text, username, count);
        tweet.add(obj);

        obj.print_data();

    }

    /*
     * @return void;
     * Allows users to search for data by username
     */
    public static void searchData(ArrayList<Tweet> tweet){
        System.out.println("Search database(array) by username.");
        System.out.println("Enter username: ");
        Scanner scan = new Scanner(System.in);
        String search = scan.next().toLowerCase();
        for (int i=0; i < tweet.size(); i++) {
            if (search.equals(tweet.get(i).username)) {
                tweet.get(i).print_data();
            }
        }
    }

    /*
     * @return void;
     * print all data in stored in the array.
     */
    public static void printData(ArrayList<Tweet> tweet){
        System.out.println("All data stored in the Array DB.");
        System.out.println("---------------------------------");
        for (int i=0; i < tweet.size(); i++) {
                tweet.get(i).print_data();
        }
        System.out.println();
    }

    public static void main(String args []){
        // set up the arrays of objects here
        ArrayList<Tweet> tweets = new ArrayList<Tweet>(100);
        menu(tweets);
    }
}
