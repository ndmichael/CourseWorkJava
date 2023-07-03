import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class Test {
    public static void menu(ArrayList<Tweet> tweets){
        boolean flag = true;
        while (flag){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter 1 for input data \n"+ "Enter 2 for search data \n" + "Enter 3 to print all data \n" + "press -1 to terminate.");
            int choice = scan.nextInt();
//            if (choice == -1){
//                break;
//            }
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

    }

    public static void inputData(ArrayList<Tweet> tweet){
        int id, count;
        String text = "";
        String username = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your data to be stored."); // newline before typing1
        System.out.println("------------------------------");
        System.out.print("enter id: ");
        id = s.nextInt();
        System.out.print("enter likes: ");
        count = s.nextInt();
        System.out.print("enter username: ");
        username = s.next();
        System.out.print("enter tweet: ");
        text = s.next();

        Tweet obj = new Tweet(id, text, username, count);
        tweet.add(obj);

        obj.print_data();

    }

    public static void searchData(ArrayList<Tweet> tweet){
        System.out.println("Search database(array) by username.");
        System.out.println("Enter username: ");
        Scanner s = new Scanner(System.in);
        String search = s.next().toLowerCase();
        for (int i=0; i < tweet.size(); i++) {
            if (search.equals(tweet.get(i).username)) {
                tweet.get(i).print_data();
            }
        }
    }

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
