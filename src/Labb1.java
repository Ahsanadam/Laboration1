import java.util.Scanner;

public class Labb1 {
    public static void main(String[] args) {
        System.out.println("1.Upp och Ner");
        System.out.println("2.Min Max");
        System.out.println("3.Sten Sax Påse");
        System.out.println("4.Ordning och reda");
        System.out.println("e.Avsluta");
        Scanner readUserInput = new Scanner(System.in);
        String choice = readUserInput.nextLine();
        switch (choice) {
            case "1":
                uppOchNer();
                break;
            case "2":
                minMax();
                break;
            case "3":
                stenSaxPase();
                break;
            case "4":
                ordningOchReda();
                break;
            case "e":
                System.out.println("Goodbye!");
                return;

            default:
                System.out.println("Goodbye");
                return;
        }
        while (choice != "E") ;

    }

    private static void ordningOchReda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv 5 heltal, separera med mellanslag.");
        int[] intArray = new int[5];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int index = 0;
        while (index < 5) {
            String next = scanner.next();
            int n = 0;
            try {
                n = Integer.parseInt(next);
            } catch (NumberFormatException e) {
                System.out.println("Inte int");
            }
            if (n > max1) {
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
            intArray[index] = n;
            index++;
        }
        System.out.println("Min value: " + min1);
        System.out.println("2Min value: " + min2);

        System.out.println("Max value: " + max1);
        System.out.println("2Max value: " + max2);

        System.out.println("I ordning: " + sorterad(intArray));
        System.out.println("Summa: " + adderaArray(intArray));
        scanner.close();

    }

    public static int adderaArray(int[] array)
    {
        int sum = 0;
        for (int n : array)
        {
            sum += n;
        }
        return sum;
    }

    public static boolean sorterad(int[] newArray) {
        for (int i = 0; i < newArray.length - 1; i++) {
            if (newArray[i] > newArray[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void stenSaxPase()
    {
        Scanner input = new Scanner(System.in);
        int förluster = 0;
        int vinster = 0;

        while(true) {
            System.out.println("Välkommen till att spela sten, sax eller påse mot datorn!(Bäst till 3)");
            System.out.println("Om du däremot inte vill delta så skriver du avsluta.");
            System.out.print("Dags för att göra ett val. Skriv in sten, sax eller påse:" );
            String userInput = input.nextLine().toLowerCase();
            if(userInput.equals("avsluta"))
            {
                break;
            }
            if (!userInput.equals("sten") && !userInput.equals("sax") && !userInput.equals("påse"))
            {
                System.out.println("Ditt val är inte godkänt, försök igen");
            }
            else
            {
                int random = (int) (Math.random() * 3);
                String computerChoice = "";
                if (random == 0) {
                    computerChoice = "sten";
                }
                else if (random == 1)
                {
                    computerChoice = "sax";
                }
                else {
                    computerChoice = "påse";
                    }
                System.out.println("Datorn valde " + computerChoice);
                if (userInput.equals(computerChoice))
                {
                    System.out.println("Det blev oavgjort :) ");
                }
                else if (userInput.equals("sten") && computerChoice.equals("sax") || userInput.equals("sax")
                        && computerChoice.equals("påse") || userInput.equals("påse") && computerChoice.equals("sten"))
                {
                    System.out.println("Du vann ! :)");
                    vinster++;
                }
                else {
                    System.out.println("Du förlorade :(");
                    förluster++;
                    }
                System.out.println("Du har vunnit " + vinster + " omgång(ar)");
                System.out.println("Datorn har vunnit " + förluster + " omgång(ar)");

                if(vinster==3)
                {
                    System.out.println("Du vann fler omgångar än datorn, Grattis!");
                    break;
                }
                else if(förluster==3)
                {
                    System.out.println("Datorn vann fler omgångar än dig, better luck next time :(");
                    break;
                }
            }
            }
            System.out.println("Tack för att du deltog :)");
            System.exit(0);
    }

    public static void minMax()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in fem heltal efter varandra, tryck på enter efter varje:");
        int[] vektor = new int[5];
        for (int i = 0; i < 5; i++) {
            vektor[i] = scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i < vektor.length; i++)
        {

        }
        int smallest = vektor[0];
        int largest = vektor[0];

        for (int i = 0; i < 5; i++) {
            if (vektor[i] < smallest) {
                smallest = vektor[i];
            } else if (vektor[i] > largest) {
                largest = vektor[i];
            }
        }
        System.out.println("Minsta talet är: " + smallest);
        System.out.println("Största talet är: " + largest);
    }

    public static void uppOchNer()
    {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Skriv in max fem saker efter varandra. Sluta processen med att skriva 'END'");
        String[] inputs = new String[5];
        int counter = 0;

        while (counter != 5) {
            input = scanner.nextLine().toUpperCase();
            if (input.equals("END")) {
                break;
            }
            inputs[counter] = input;
            counter++;
        }
        for (int i = counter - 1; i >= 0; i--) {
            System.out.println(inputs[i]);
        }
    }

    }



