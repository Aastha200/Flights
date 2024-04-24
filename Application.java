import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Predicate;

class Flight {
    String flightId;
    String airline;
    int airplaneId;
    int economyPrice;
    String departureDate;
    String departureFrom;
    String destination;
    String departureTime;

    public Flight(String flightId, String airline, int airplaneId, int economyPrice, String departureDate,
            String departureFrom, String destination, String departureTime) {
        this.flightId = flightId;
        this.airline = airline;
        this.airplaneId = airplaneId;
        this.economyPrice = economyPrice;
        this.departureDate = departureDate;
        this.departureFrom = departureFrom;
        this.destination = destination;
        this.departureTime = departureTime;
    }
}

class User {
    String username;
    String email;
    String gender;

    public User(String username, String email, String gender) {

        this.username = username;
        this.email = email;
        this.gender = gender;
    }
}

public class Application {
    public static ArrayList<Flight> searchFlights(ArrayList<Flight> flights, String keyword) {
        String keywordLower = keyword.toLowerCase();

        Predicate<Flight> searchPredicate = flight -> flight.destination.toLowerCase().contains(keywordLower) ||
                flight.departureFrom.toLowerCase().contains(keywordLower) ||
                flight.airline.toLowerCase().contains(keywordLower);

        ArrayList<Flight> searchResults = new ArrayList<>();
        for (Flight flight : flights) {
            if (searchPredicate.test(flight)) {
                searchResults.add(flight);
            }
        }
        return searchResults;
    }

    static ArrayList<Flight> getFlightList() {
        ArrayList<Flight> flights = new ArrayList<>();

        flights.add(new Flight("FL001", "Emirates", 1234, 500, "2024-04-25", "Dubai", "London", "09:00"));
        flights.add(new Flight("FL002", "Lufthansa", 5678, 450, "2024-04-26", "Berlin", "New York", "10:30"));
        flights.add(new Flight("FL003", "British Airways", 91011, 600, "2024-04-27", "London", "Paris", "11:45"));
        flights.add(
                new Flight("FL004", "Delta Airlines", 121314, 400, "2024-04-28", "New York", "Los Angeles", "13:15"));
        flights.add(
                new Flight("FL005", "Singapore Airlines", 151617, 700, "2024-04-29", "Singapore", "Tokyo", "14:45"));
        flights.add(new Flight("FL006", "Qatar Airways", 181920, 550, "2024-04-30", "Doha", "Sydney", "15:30"));
        flights.add(new Flight("FL007", "Air France", 212223, 480, "2024-05-01", "Paris", "Rome", "16:20"));
        flights.add(
                new Flight("FL008", "American Airlines", 242526, 620, "2024-05-02", "Los Angeles", "Chicago", "17:10"));
        flights.add(new Flight("FL009", "Cathay Pacific", 272829, 530, "2024-05-03", "Hong Kong", "Bangkok", "18:00"));
        flights.add(new Flight("FL010", "KLM Royal Dutch Airlines", 303132, 680, "2024-05-04", "Amsterdam", "Dubai",
                "19:15"));
        flights.add(new Flight("FL011", "Qantas", 333435, 590, "2024-05-05", "Sydney", "Auckland", "20:30"));
        flights.add(new Flight("FL012", "Turkish Airlines", 363738, 510, "2024-05-06", "Istanbul", "Moscow", "21:45"));
        flights.add(
                new Flight("FL013", "Etihad Airways", 394041, 750, "2024-05-07", "Abu Dhabi", "New Delhi", "22:40"));
        flights.add(new Flight("FL014", "Japan Airlines", 424344, 640, "2024-05-08", "Tokyo", "Shanghai", "23:55"));
        flights.add(
                new Flight("FL015", "Southwest Airlines", 454647, 430, "2024-05-09", "Dallas", "Las Vegas", "00:45"));
        flights.add(new Flight("FL016", "Ryanair", 484950, 370, "2024-05-10", "Dublin", "Barcelona", "01:30"));
        flights.add(new Flight("FL017", "Air Canada", 515253, 590, "2024-05-11", "Toronto", "Vancouver", "02:15"));
        flights.add(
                new Flight("FL018", "Alaska Airlines", 545556, 480, "2024-05-12", "Seattle", "San Francisco", "03:00"));
        flights.add(new Flight("FL019", "Thai Airways", 575859, 710, "2024-05-13", "Bangkok", "Seoul", "03:45"));
        flights.add(new Flight("FL020", "Virgin Atlantic", 606162, 620, "2024-05-14", "London", "Newark", "04:30"));
        return flights;

    }

    private static void showFlight(ArrayList<Flight> flights, JPanel jPanel2) {
        for (Flight flight : flights) {
            JPanel jPanel4 = new JPanel();
            JLabel jLabel2 = new JLabel();
            JLabel jLabel3 = new JLabel();
            JLabel jLabel4 = new JLabel();
            JLabel jLabel5 = new JLabel();
            JLabel jLabel6 = new JLabel();
            JLabel jLabel7 = new JLabel();
            JButton jButton4 = new JButton();

            jPanel4.setBackground(new Color(255, 255, 255));

            jLabel2.setIcon(new ImageIcon(Application.class.getResource("airplane.png")));

            jLabel3.setText(flight.airline);

            jLabel4.setText(flight.departureFrom);

            jLabel5.setText(flight.departureTime);

            jLabel6.setText(flight.destination);

            jLabel7.setText("$" + flight.economyPrice);

            jButton4.setBackground(new Color(0, 102, 102));
            jButton4.setForeground(new Color(255, 255, 255));
            jButton4.setText("Book Now");

            jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(flight.flightId + " button is pressed");

                    String flightDetails = "Flight Name: " + flight.airline + ",\nDeparture : " + flight.departureFrom
                            + ",\nDestination: " + flight.destination;
                    String userName = user.username;
                    String userEmail = user.email;
                    String userGender = user.gender;

                    String message = "You have successfully completed the flight booking.\n\n"
                            + "Flight Details:\n" + flightDetails + "\n\n"
                            + "User Information:\n"
                            + "Name: " + userName + "\n"
                            + "Email: " + userEmail + "\n"
                            + "Gender: " + userGender;

                    JOptionPane.showMessageDialog(app, message, "Flight Booking Confirmation",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });

            GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                    jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 85,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3)
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 45,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 42,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 64,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22,
                                            Short.MAX_VALUE)
                                    .addComponent(jButton4)
                                    .addGap(22, 22, 22)));
            jPanel4Layout.setVerticalGroup(
                    jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 83,
                                            GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 4, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel4Layout
                                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5)
                                            .addComponent(jButton4))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

            jPanel2.add(jPanel4);
        }
    }

    public enum Page {
        HOME, REGISTER
    }

    public static String BOOK_FLIGHT_ID = null;
    public static User user = new User("", "", "");
    public static Page currentPage = Page.REGISTER;
    static JFrame app;

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu homeMenu = new JMenu("Page");
        JMenuItem registerMenuItem = new JMenuItem("Register");
        registerMenuItem.addActionListener(e -> {
            currentPage = Page.REGISTER;
            JPanel panel = createComponents();
            setContentPaneAndRefresh(app, panel);
        });
        JMenuItem homeMenuItem = new JMenuItem("Home");
        homeMenuItem.addActionListener(e -> {
            currentPage = Page.HOME;
            JPanel panel = createComponents();
            setContentPaneAndRefresh(app, panel);
        });
        homeMenu.add(registerMenuItem);
        homeMenu.add(homeMenuItem);
        menuBar.add(homeMenu);
        return menuBar;
    }

    public static JPanel createComponents() {
        JPanel component = new JPanel();
        JLabel label = null;

        switch (currentPage) {
            case HOME:
                component = createHomePage();
                break;

            case REGISTER:
                component = createRegisterForm();
                break;
            default:
                label = new JLabel("Error");
                break;
        }

        if (label != null) {
            component.add(label);
        }
        return component;
    }

    private static JPanel createHomePage() {
        ArrayList<Flight> flights = getFlightList();
        JPanel panel = new JPanel();
        JButton jButton1;
        JButton jButton2;
        JButton jButton3;
        JLabel jLabel1;

        JPanel jPanel1;
        JPanel jPanel2 = new JPanel(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(jPanel2);
        scrollPane.setPreferredSize(new Dimension(750, 300));

        jPanel1 = new JPanel();
        JTextField jTextField1;

        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setPreferredSize(new Dimension(800, 500));

        jLabel1.setText("Search");

        jButton1.setBackground(new Color(0, 102, 102));
        jButton1.setFont(new Font("Segoe UI", 1, 12));
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("search");

        jButton2.setBackground(new Color(0, 102, 102));
        jButton2.setFont(new Font("Segoe UI", 1, 12));
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setText("Low to High");

        jButton3.setBackground(new Color(0, 102, 102));
        jButton3.setFont(new Font("Segoe UI", 1, 12));
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("High to Low");

        showFlight(flights, jPanel2);
        jPanel2.revalidate();
        jPanel2.repaint();
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 282,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(34, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(31, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addGap(31, 31, 31)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(71, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        // TODO: search
        final JPanel finalPanel2 = jPanel2;
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        String searchQuery = jTextField1.getText();
                        if (searchQuery.length() != 0) {
                            ArrayList<Flight> searchResult = searchFlights(getFlightList(), searchQuery);
                            flights.clear();
                            flights.addAll(searchResult);
                            finalPanel2.removeAll();
                            showFlight(searchResult, finalPanel2);
                            finalPanel2.revalidate();
                            finalPanel2.repaint();
                        } else {
                            ArrayList<Flight> flights = getFlightList();
                            finalPanel2.removeAll();
                            showFlight(flights, finalPanel2);
                            finalPanel2.revalidate();
                            finalPanel2.repaint();
                        }
                    }
                });
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        flights.sort((a, b) -> Double.compare(a.economyPrice, b.economyPrice));
                        finalPanel2.removeAll();
                        showFlight(flights, finalPanel2);
                        finalPanel2.revalidate();
                        finalPanel2.repaint();
                    }
                });
            }
        });

        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        flights.sort((a, b) -> Double.compare(b.economyPrice, a.economyPrice));
                        finalPanel2.removeAll();
                        showFlight(flights, finalPanel2);
                        finalPanel2.revalidate();
                        finalPanel2.repaint();
                    }
                });
            }
        });
        return panel;

    }

    private static JPanel createRegisterForm() {
        JPanel panel = new JPanel();
        javax.swing.JButton signup;
        javax.swing.JLabel jLabel1;
        javax.swing.JLabel jLabel2;
        javax.swing.JLabel jLabel3;
        javax.swing.JLabel jLabel4;
        javax.swing.JLabel jLabel5;
        javax.swing.JLabel jLabel7;
        javax.swing.JLabel jLabel8;
        javax.swing.JLabel jLabel9;
        javax.swing.JPanel jPanel1;
        javax.swing.JPanel jPanel2;
        javax.swing.JRadioButton jRadioButton1;
        javax.swing.JRadioButton jRadioButton2;
        javax.swing.JTextField userName;
        javax.swing.JTextField emailField;
        javax.swing.JTextField passwordFiled;
        javax.swing.JTextField confirmPasswordFiled;
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        signup = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        passwordFiled = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        confirmPasswordFiled = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        ButtonGroup role = new ButtonGroup();
        role.add(jRadioButton1);
        role.add(jRadioButton2);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Flight Booking Sysytem");

        jLabel2.setIcon(new javax.swing.ImageIcon(Application.class.getResource("airplane.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Sign Up");

        jLabel4.setText("Email");

        jLabel5.setText("Password");

        signup.setBackground(new java.awt.Color(0, 0, 0));
        signup.setForeground(new java.awt.Color(255, 255, 255));
        signup.setText("Sign up");

        jLabel7.setText("User name");

        jLabel8.setText("Confirm Password");

        jLabel9.setText("Gender");

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Female");

        jRadioButton2.setText("Male");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(jLabel7)
                                                                .addComponent(userName)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel4)
                                                                .addComponent(emailField)
                                                                .addComponent(passwordFiled)
                                                                .addComponent(jLabel8)
                                                                .addComponent(confirmPasswordFiled)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel2Layout.createSequentialGroup()
                                                                                .addGroup(jPanel2Layout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(signup)
                                                                                        .addGroup(jPanel2Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        jRadioButton2)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(
                                                                                                        jRadioButton1)))
                                                                                .addGap(67, 67, 67)))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel3)))
                                .addContainerGap(168, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(49, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordFiled, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmPasswordFiled, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton1))
                                .addGap(18, 18, 18)
                                .addComponent(signup)
                                .addGap(75, 75, 75)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(197, 197, 197))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE));

        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userName.getText();
                String email = emailField.getText();
                String password = new String(passwordFiled.getText());
                String confirmPassword = new String(confirmPasswordFiled.getText());

                String gender = "Male";
                if (jRadioButton1.isSelected()) {
                    gender = "Female";
                }

                System.out.println("Username: " + username);
                System.out.println("email: " + email);
                System.out.println("password: " + password);
                System.out.println("confirmPassword: " + confirmPassword);
                System.out.println("gender: " + gender);

                if (username.length() == 0 || email.length() == 0 || password.length() == 0
                        || confirmPassword.length() == 0) {
                    JOptionPane.showMessageDialog(panel, "Please fill all required fields!",
                            "Missing Information", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(panel, "Passwords do not match!",
                            "Password Mismatch", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                user.email = email;
                user.username = username;
                user.gender = gender;
                currentPage = Page.HOME;
                JPanel panel = createComponents();
                setContentPaneAndRefresh(app, panel);
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        app = new JFrame("Airline Reservation System");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setJMenuBar(createMenuBar());
        JPanel panel = createComponents();
        app.add(panel);
        app.setSize(800, 500);
        app.setResizable(false);
        app.setVisible(true);
    }

    private static void setContentPaneAndRefresh(JFrame frame, JPanel panel) {
        frame.setContentPane(panel);
        frame.setJMenuBar(createMenuBar());
        frame.revalidate();
        frame.repaint();
    }
}
