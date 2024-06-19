/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

/**
 *
 * @author varun
 */

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Task1{
    private static final int min = 10000;
    private static final int max = 99999;

    public static class user {
        private String uname;
        private String pwd;
        
        Scanner sc = new Scanner(System.in);
        
        public user () {} 

        public String getUname () {
            System.out.println("Enter Username: ");
            uname = sc.nextLine();
            return uname;
        }

        public String getpwd () {
            System.out.println("Enter Password: ");
            pwd = sc.nextLine();
            return pwd;
        }

        public static class PassengerRecord {
            private int passengerNumber;
            private String passengerName;
            private int tnumber;
            private String CT;
            private String StartDate;
            private String Source;
            private String Destination;

            Scanner sc = new Scanner(System.in);

            public int getpassengerNumber () {
                Random random = new Random ();
                passengerNumber = random.nextInt(max) + min;
                return passengerNumber;
            }

            public String getPassengerName () {
                System.out.println("Enter the passenger name: ");
                passengerName = sc.nextLine();
                return passengerName;
            }

            public int getTrainNumber () {
                System.out.println("Enter the train number: ");
                tnumber = sc.nextInt();
                return tnumber;
            }

            public String getType () {
                System.out.println("Enter the class type: ");
                CT = sc.nextLine();
                return CT;
            }

            public String getJourneyDate () {
                System.out.println("Enter the Journey Date as 'YYYY-MM-DD' format");
                StartDate  = sc.nextLine();
                return StartDate;
            }

            public String getSource () {
                System.out.println("Enter the place where you will board the train: ");
                Source = sc.nextLine();
                return Source;
            }

            public String getDestination () {
                System.out.println("Enter the place where you want to reach: ");
                Destination = sc.nextLine();
                return Destination;
            }
        }
    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            user ux = new user();

            String url = "jdbc:mysql://localhost:3306/train";

            try 
            { Class.forName("com.mysql.cj.jdbc.Driver");
                
                try (Connection connection = DriverManager.getConnection(url, "root", "")) {
                    String name = ux.getUname();
                    String pass = ux.getpwd();
                    PreparedStatement ps = connection.prepareStatement("Select password from customers where username = ?");
//                    ps.setString(1, name);
//                    ResultSet rs;
//                    rs = ps.executeQuery();
//                    
//                    rs.next();
//                    String check = rs.getString(1);
                    
                        System.out.println("User connection Granted. \n");

                        while (true) {
                            String InsertQuery = "insert into reservation values (?, ?, ?, ?, ?, ?, ?)";
                            String DeleteQuery = "delete from reservation where pnr_number = ?";
                            String ShowQuery = "select * from reservation";

                            System.out.println("Enter the choice: ");
                            System.out.println("1. Insert record\n");
                            System.out.println("2. Delete Record\n");
                            System.out.println("3. Show All Records\n");
                            System.out.println("4. Exit");
                            int choice =  sc.nextInt();

                            switch (choice) {
                                case 1:
                                    Task1.user.PassengerRecord p1 = new Task1.user.PassengerRecord();
                                    int pnr_number = p1.getpassengerNumber();
                                    String pName = p1.getPassengerName();
                                    int trainNumber = p1.getTrainNumber();
                                    String CT = p1.getType();
                                    String StartDate = p1.getJourneyDate();
                                    String getfrom = p1.getSource();
                                    String getto = p1.getDestination();

                                    try (PreparedStatement ps1 = connection.prepareStatement(InsertQuery)) {
                                        ps1.setInt (1, pnr_number);
                                        ps1.setString(2, pName);
                                        ps1.setInt(3, trainNumber);
                                        ps1.setString(4, CT);
                                        ps1.setString(5, StartDate);
                                        ps1.setString(6, getfrom);
                                        ps1.setString(7, getto);

                                        int rowsAfffected = ps1.executeUpdate();
                                        if (rowsAfffected >0) {
                                            System.out.println("Record Added Successfully.");
                                        }
                                        else {
                                            System.out.println("No records where added. ");
                                        }

                                    } catch (SQLException e) {
                                        System.err.println("SQLException" + e.getMessage());
                                    }
                                    continue;

                                
                                case 2:
                                    System.out.println("Enter the PNR number to delete the record: ");
                                    int pnrNumber = sc.nextInt();
                                    try (PreparedStatement ps1 = connection.prepareStatement(DeleteQuery)) {
                                        ps1.setInt(1, pnrNumber);
                                        int rowsAfffected = ps1.executeUpdate();

                                        if (rowsAfffected >0) {
                                            System.out.println("Record Deleted Successfully.");
                                        }

                                        else {
                                            System.out.println("No records were added.");
                                        }
                                    } catch (SQLException e) {
                                        System.err.println("SQLException: " + e.getMessage());
                                    }
                                    continue;

                                case 3: 
                                    try (PreparedStatement ps1 = connection.prepareStatement(ShowQuery);
                                        ResultSet rs1 = ps1.executeQuery()) {
                                        System.out.println("\n All records are printing. \n");
                                        while (rs1.next()) {
                                            String pnrnumber = rs1.getString("pnr_number");
                                            String passergername = rs1.getString("passenger_name");
                                            String trainnumber = rs1.getString("train_number");
                                            String classtype = rs1.getString("classtype");
                                            String journeydate = rs1.getString("journey_date");
                                            String fromLocation = rs1.getString("from_location");
                                            String toLocation = rs1.getString("to_location");
                                            
                                            System.out.println("PNR Number: " + pnrnumber);
                                            System.out.println("Passenger Name: " + passergername);
                                            System.out.println("Train Number: " + trainnumber);
                                            System.out.println("Class Type: " +classtype);
                                            System.out.println("Journey Date: " + journeydate);
                                            System.out.println("From Location: " + fromLocation);
                                            System.out.println("To Location: " + toLocation);
                                            System.out.println("---------------------------------------");
                                        }
                                    } catch (SQLException e) {
                                        System.err.println("SQLException: " + e.getMessage());
                                    }
                                    continue;

                                case 4: 
                                    System.out.println("Exiting the program \n");
                                    System.exit(0);
                            
                                default:
                                    System.out.println("Incorrec Choice, please try again. ");
                                    
                                }
                    
                        
                    }
                }
            } catch (SQLException e){
                System.err.println("SQLException: " + e.getMessage());
            }
            catch (ClassNotFoundException e) {
                System.err.println("Error Loading JDBC driver: " + e.getMessage());
            }
            sc.close();
        }
    
}