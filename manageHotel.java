// package prog_mco2;
import java.util.ArrayList;
import java.util.Scanner;

/**manageHotel class that allows the user to change the hotel name, add rooms, remove rooms, change room price, remove hotel, and remove 
 * reservations.
 */
public class manageHotel {

    private Scanner sc;


    /** Constructor for manageHotel
     * Preconditions: none
     * Postconditions: Scanner object is initialized
     */
    public manageHotel() {
        sc = new Scanner(System.in);
    }

    /** Finds the index of the hotel in the ArrayList of hotels
     * Preconditions: h is an ArrayList of Hotels and name is a String
     * Postconditions: returns an integer
     * @param h - ArrayList of Hotels which contains all the hotels
     * @param name - The name of the hotel
     * @return i (The index of the hotel) or -1 if the hotel does not exist
     */
    public int findHotel(ArrayList<Hotel> h, String name) {
        for (int i = 0; i < h.size(); i++) {
            System.out.println("Checking hotel: " + h.get(i).getName());
            if (h.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /** Changes the name of the hotel
     * Preconditions: hotels is an ArrayList of hotels and the instance hotels is initialized
     * Postconditions: The name of the hotel is changed
     * @param hotels - ArrayList of Hotels which contains all the hotels
     */
    public void setNameHotel(ArrayList<Hotel> hotels) {

        Display display = new Display();
        int i = display.enterHotelName(hotels);

        if (i >= 0) {
            System.out.print("Enter new hotel name: ");
            String newName = sc.nextLine();
            int input;

            input = display.confirm();

            while(input == 2){
                System.out.print("Enter new hotel name: ");
                newName = sc.nextLine();
                input = display.confirm();
            }

            int j = findHotel(hotels, newName);

            if (j < 0)
                hotels.get(i).setName(newName);
            else    
                System.out.println("Cannot change hotel name, hotel already exists.");
        }
        
    }

    /** Adds a number of a specific type of room to the the hotel
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: The number of rooms in the hotel is increased
     * @param h - Instance of Hotel
     */
    public void addRooms(Hotel h) { // changed this to make them choose a specific room type to add instead of all 3
        Display display = new Display();
        int rooms, type, input;
        do {
            do {
                System.out.println("Enter type of room to remove:");
                System.out.println("[1] Standard");
                System.out.println("[2] Deluxe");
                System.out.println("[3] Executive");
                type = sc.nextInt();
                sc.nextLine(); // input buffer
            } while (type < 1 || type > 3);

            do {
                System.out.print("Enter amount of rooms to add: ");
                rooms = sc.nextInt();
                sc.nextLine(); // input buffer
            } while (rooms < 1 || rooms > h.getRooms().getTotal());
            input = display.confirm();
        } while (input == 2);
        
        int ctr = 0;
        
        while (h.getRooms().getTotal() < 50 && rooms > 0) {
            switch (type) {
                case 1:
                    h.getRooms().setStandard(h.getRooms().getStandard() + 1);
                    break;
                case 2:
                    h.getRooms().setDeluxe(h.getRooms().getDeluxe() + 1);
                    break;
                case 3:
                    h.getRooms().setExecutive(h.getRooms().getExecutive() + 1);
                    break;
            }
            rooms--;
            ctr++;
            h.getRooms().addRoomNames();
        }
        
        if (h.getRooms().getTotal() >= 50 && rooms > 0) 
            System.out.printf("Cannot add more rooms. Maximum capacity reached.\n");
        System.out.printf("%d rooms successfully added.\n\n", ctr);
    }

    
    /** Removes a number of a specific type of room from the hotel
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: The number of rooms in the hotel is decreased
    * @param h - Instance of Hotel
     */
    public void removeRoom(Hotel h) {
        Display display = new Display();
        int type, amt, input;
        do {
        System.out.println("Enter type of room to remove:");
        System.out.println("[1] Standard");
        System.out.println("[2] Deluxe");
        System.out.println("[3] Executive");
        type = sc.nextInt();
        sc.nextLine(); // input buffer

        System.out.print("Enter amount of rooms to remove: ");
        amt = sc.nextInt();
        
        input = display.confirm();
        } while (input == 2 || type < 1 || type > 3);
        
        int ctr = 0;
        boolean found;
        int x = h.getRooms().getTotal();
        while (x > 1 && amt > 0) { 
            found = false;
            for (int i = 0; i < h.getNumOfReservations() && !found; i++) { // If a room has a reservation, skip the room
                if (h.getReservations().get(i).getRoomNumber() == x) {
                    found = true;
                    x--;
                }
            }
            if (!found) {
                h.removeRoom(x);
                amt--;
                ctr++;
                x--;
            }
        }
        switch(type) {
            case 1:
                h.getRooms().setStandard(-ctr);
                break;
            case 2:
                h.getRooms().setDeluxe(-ctr);
                break;
            case 3:
                h.getRooms().setExecutive(-ctr);
        }
        if (amt > 0)
            System.out.println("Not enough rooms available to remove.");
        System.out.printf("%d rooms successfully removed\n\n", ctr);

    }
    

    /** Changes the price of the room
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: The price of the room is changed
     * @param h - Instance of Hotel
     */
    public void newPrice(Hotel h) {
        Display display = new Display();
        System.out.print("Enter new price: ");
        float newPrice = sc.nextFloat();
        sc.nextLine(); // input buffer

        int input = display.confirm();
        while(input == 2){
            System.out.print("Enter new price: ");
            newPrice = sc.nextFloat();
            sc.nextLine(); // input buffer
            input = display.confirm();
        }


        if(h.getNumOfReservations() == 0 && newPrice >= 100)
            h.setRoomPrice(newPrice);
        else if (h.getNumOfReservations() != 0)
            System.out.println("Hotel currently has reservations, cannot change room price.\n");
        else
            System.out.println("New room price too small.\n");
    }

    /** Removes a reservation from the hotel
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: The reservation is removed from the hotel
     * @param h - Instance of Hotel
     */ 
    public void removeReservation(Hotel h) { 
        Display display = new Display();
        int input;
        int input2;
        if (h.getNumOfReservations() > 0) {
            for (int i = 0; i < h.getNumOfReservations(); i++) {
                System.out.printf("[%d]\tCustomer name: %s\n", i + 1, h.getReservations().get(i).getGuestName());
                System.out.printf("\tCheck-in day: %d\n", h.getReservations().get(i).getCheckInDate());
                System.out.printf("\tCheck-out day: %d\n", h.getReservations().get(i).getCheckOutDate());
                System.out.printf("\tRoom number: %d\n", h.getReservations().get(i).getRoomNumber());
            }
            do {
                System.out.print("Enter reservation to remove: ");
                input = sc.nextInt();
                sc.nextLine(); // input buffer

                input2 = display.confirm();
                while(input2 == 2){
                    System.out.print("Enter reservation to remove: ");
                    input = sc.nextInt();
                    sc.nextLine(); // input buffer
                    input2 = display.confirm();
                }




            } while (input < 1 || input > h.getNumOfReservations());
            h.removeReservation(input-1);
            System.out.println("Reservation successfully removed.\n");
        }
        else {
            System.out.println("No current reservations.\n");
        }
    }

    /** Removes a hotel from the list of hotels
     * Preconditions: h is an ArrayList of hotels and the instance h is initialized
     * Postconditions: The hotel is removed from the list of hotels
     * @param h - The ArrayList of Hotels
     */
    public void removeHotel(ArrayList<Hotel> h) {
        Display display = new Display();
        int i, input;
        i = display.enterHotelName(h);
        
        if (i >= 0) {
            input = display.confirm();
            while (input == 2) {
                i = display.enterHotelName(h);
                input = display.confirm();
            }
            h.remove(i);
            System.out.println("Hotel successfully removed.\n");
        }


    }


    /*
     * This will be used to change price rate of each night 
     * I haven't done total calculations yet only implementation of the feature palang
     */
    public void setDateModifier(Hotel h){
        int input, input2;
        float percentage = 0;
        Display display = new Display();


        System.out.printf("Which day would you like to change price rate of(0 to QUIT): ");
        input = sc.nextInt();
        sc.nextLine(); // input buffer
        while(input < 0 || input > 31){
            System.out.printf("Which day would you like to change price rate of(0 to QUIT): ");
            input = sc.nextInt();
            sc.nextLine(); // input buffer
        }

        if(input != 0){
            System.out.printf("Enter percent you would like to change the price rate to: ");
            percentage = sc.nextInt();
            sc.nextLine(); // input buffer
            while(percentage < 50 || percentage > 150){
                System.out.printf("Enter percent you would like to change the price rate to: ");
                percentage = sc.nextInt();
                sc.nextLine(); // input buffer
            }

            input2 = display.confirm();
            while(input2 == 2){
                System.out.printf("Which day would you like to change price rate of(0 to QUIT): ");
                input = sc.nextInt();
                sc.nextLine(); // input buffer

                while(input < 0 || input > 31){
                    System.out.printf("Which day would you like to change price rate of(0 to QUIT): ");
                    input = sc.nextInt();
                    sc.nextLine(); // input buffer
                }

                System.out.printf("Enter percent you would like to change the price rate to: ");
                percentage = sc.nextInt();
                sc.nextLine(); // input buffer

                while(percentage < 50 || percentage > 150){
                    System.out.printf("Enter percent you would like to change the price rate to: ");
                    percentage = sc.nextInt();
                    sc.nextLine(); // input buffer
                }

                input2 = display.confirm();
            }
            
            h.setDatePriceModifier(input, percentage/100);
        } 
        

        while(input != 0) {
            System.out.printf("Which day would you like to change price rate of(0 to QUIT): ");
            input = sc.nextInt();
            sc.nextLine(); // input buffer

            if(input != 0){
                System.out.printf("Enter percent you would like to change the price rate to: ");
                percentage = sc.nextInt();
                sc.nextLine(); // input buffer

                input2 = display.confirm();
                while(input2 == 2) {
                    System.out.printf("Which day would you like to change price rate of(0 to QUIT): ");
                    input = sc.nextInt();
                    sc.nextLine(); // input buffer
                    System.out.printf("Enter percent you would like to change the price rate to: ");
                    percentage = sc.nextInt();
                    sc.nextLine(); // input buffer
                    input2 = display.confirm();
                }

                h.setDatePriceModifier(input, percentage/100);
            }

        }

        System.out.println();
        
    }


}
