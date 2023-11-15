
import Packages.*;
import Payments.CreditCardStrategy;
import Payments.PayPalStrategy;
import Payments.PaymentStrategy;
import Services.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MainScreen extends JFrame {

    //Customization
    Font myFont=new Font("SansSerif",Font.BOLD,20);
    Font myFont2=new Font("SansSerif",Font.BOLD,16);
    Color myColor=Color.gray;

    //Variables
    public boolean isIndividualOrNot=false;
    public int packagePrice=0;


    //Panel 1
    JTextField cusName,cusPhone,cusAge,cusJob;
    JRadioButton isIndividual,isGroup;
    ButtonGroup Go;

    JComboBox<String> comboBox;

    //Panel 2
    JRadioButton package1RadioBTN;
    JRadioButton package2RadioBTN;
    JRadioButton package3RadioBTN;
    ButtonGroup G1;

    //Panel3
    JComboBox<String> comboBox1;
    JComboBox<String> comboBox2;
    JComboBox<String> comboBox3;

    JLabel transLBL,activityLBL,AccomLBL;
    JRadioButton payment1,payment2;
    JTextArea totalPriceLBL;

    ButtonGroup G2;

    PaymentStrategy paymentStrategy;

    //Panel 5
    JTextArea detailTransArea,detailActivityArea,detailAccomArea;

    //Panel 6
    JButton chatBtn,makeReservationBTN,makeSearch;
    JLabel searchLBL;
    JTextField searchField;
    JTextArea reservationDetailsArea;


    public MainScreen(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();

    }
    private void CustomizePanel1(){
        JPanel p1=new JPanel();
        TitledBorder titledBorder=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.blue,1),
                "Customer",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p1.setBorder(titledBorder);

        JLabel fNameLBL=new JLabel("Name");
        JLabel LNameLBL=new JLabel("Phone");
        JLabel CityLBL=new JLabel("Age");
        JLabel phoneLBL=new JLabel("Job");
        JLabel isIndividualLBL=new JLabel("Individual Trip?");

        cusName=new JTextField();
        cusName.setOpaque(false);
        cusPhone=new JTextField();
        cusPhone.setOpaque(false);
        cusAge=new JTextField();
        cusAge.setOpaque(false);
        cusJob=new JTextField();
        cusJob.setOpaque(false);

        isIndividual=new JRadioButton("Individual");
        isGroup=new JRadioButton("Group");

        //Adding Widgets to the panel
        p1.add(fNameLBL);
        p1.add(cusName);
        p1.add(LNameLBL);
        p1.add(cusPhone);
        p1.add(CityLBL);
        p1.add(cusAge);
        p1.add(phoneLBL);

        //Drop down menu
        String[] jobs={"Student","Business","Retired","Employee"};
        comboBox=new JComboBox<>(jobs);
        comboBox.setBounds(120,10,80,20);
        p1.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected=(String) comboBox.getSelectedItem();
                System.out.println("Selected: "+selected);
            }
        });

        p1.add(isIndividual);
        p1.add(isGroup);
        Go=new ButtonGroup();
        Go.add(isGroup);
        Go.add(isIndividual);

        isIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isIndividualOrNot=true;


                //Disable the offers
                package1RadioBTN.setEnabled(false);
                package2RadioBTN.setEnabled(false);
                package3RadioBTN.setEnabled(false);

                comboBox1.setEnabled(true);
                comboBox2.setEnabled(true);
                comboBox3.setEnabled(true);
            }
        });

        isGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isIndividualOrNot=true;


                //Enable the offers
                package1RadioBTN.setEnabled(true);
                package2RadioBTN.setEnabled(true);
                package3RadioBTN.setEnabled(true);

                comboBox1.setEnabled(false);
                comboBox2.setEnabled(false);
                comboBox3.setEnabled(false);
            }
        });

        p1.setBounds(15,15,300,200);
        p1.setLayout(new GridLayout(5,2));
        setLayout(null);
        add(p1);

    }
    private void CustomizePanel2(){
        JPanel p2=new JPanel();
        TitledBorder titledBorder2=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Special Offers",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p2.setBorder(titledBorder2);

        package1RadioBTN=new JRadioButton("Package 1");
        package2RadioBTN=new JRadioButton("Package 2");
        package3RadioBTN=new JRadioButton("Package 3");

        G1=new ButtonGroup();
        G1.add(package1RadioBTN);
        G1.add(package2RadioBTN);
        G1.add(package3RadioBTN);

        package1RadioBTN.setActionCommand("Pack 1");
        package2RadioBTN.setActionCommand("Pack 2");
        package3RadioBTN.setActionCommand("Pack 3");

        package1RadioBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailAccomArea.setText("Accommodation: 5 Stars Hotel \nAll Inclusive");
                detailActivityArea.setText("Activities: Gorgeous \nSky Diving \nExperience");
                detailTransArea.setText("Transportation: Uber Taxi");

                PackageBuilder offer1=new Offer1();
                offer1.createPackage();
                totalPriceLBL.setText("Total Price: "+offer1.getP().getTotalPrice()+" $");
            }
        });
        package2RadioBTN.addActionListener(e ->{
            detailAccomArea.setText("Accommodation: 4 Stars Hotel \nAll Inclusive");
            detailActivityArea.setText("Activities: Unforgettable \nSea Cruise ");
            detailTransArea.setText("Transportation: Bus");

            PackageBuilder offer2=new Offer2();
            offer2.createPackage();
            totalPriceLBL.setText("Total Price: "+offer2.getP().getTotalPrice()+" $");
        });
        package3RadioBTN.addActionListener(e ->{
            detailAccomArea.setText("Accommodation: 4 Stars Hotel \nAll Inclusive");
            detailActivityArea.setText("Activities: Unforgettable \nSky Diving ");
            detailTransArea.setText("Transportation: Bus");

            PackageBuilder offer3=new Offer1();
            offer3.createPackage();
            totalPriceLBL.setText("Total Price: "+offer3.getP().getTotalPrice()+" $");
        });
        p2.add(package1RadioBTN);
        p2.add(package2RadioBTN);
        p2.add(package3RadioBTN);

        p2.setBounds(15,250,300,200);
        p2.setLayout(new GridLayout(3,1));
        setLayout(null);
        add(p2);
    }
    private void CustomizePanel3(){
        JPanel p3=new JPanel();
        TitledBorder titledBorder3=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Individual Trip",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p3.setBorder(titledBorder3);
        transLBL=new JLabel("Transportation");
        AccomLBL=new JLabel("Accommodation");
        activityLBL=new JLabel("Activity");
        p3.add(transLBL);

        //Transportation
        String[] transportations={"Taxi","Bus"};
        comboBox1=new JComboBox<>(transportations);
        comboBox1.setBounds(120,10,80,20);
        p3.add(comboBox1);
        comboBox1.addActionListener(e ->{
            String selected=(String) comboBox1.getSelectedItem();
            if(selected.equals("Taxi")){
                //User selected Taxi
                System.out.println("Trans: Taxi");
            }
        });
        p3.add(activityLBL);
        String[] activities={"Sea Cruise","Sky Diving"};
        comboBox2=new JComboBox<>(activities);
        comboBox2.setBounds(120,10,80,20);
        p3.add(comboBox2);
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //Accommodations
        p3.add(AccomLBL);
        String[] accommodations={"Hotel","Motel"};
        comboBox3=new JComboBox<>(accommodations);
        comboBox3.setBounds(120,10,80,20);
        p3.add(comboBox3);
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        p3.setBounds(15,500,300,150);
        p3.setLayout(new GridLayout(3,2));
        setLayout(null);
        add(p3);

    }
    private void CustomizePanel4(){
        JPanel p4=new JPanel();
        TitledBorder titledBorder4=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Payment Methods",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p4.setBorder(titledBorder4);

        totalPriceLBL=new JTextArea("Total Price: Rs_____");
        totalPriceLBL.setOpaque(false);
        totalPriceLBL.setFont(myFont2);
        payment1=new JRadioButton("UPI");
        payment2=new JRadioButton("Credit Card");
        G2=new ButtonGroup();
        G2.add(payment1);
        G2.add(payment2);

        payment1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentStrategy=new PayPalStrategy(
                        cusName.getText()+"@gmail.com","12345"
                );
            }
        });
        payment2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentStrategy =new CreditCardStrategy(
                        cusName.getText(),
                        "1234 5678 9123 4567",
                        "999",
                        "12/25"
                );
            }
        });
        p4.add(payment1);
        p4.add(payment2);
        p4.add(totalPriceLBL);
        p4.setBounds(330,15,300,400);
        p4.setLayout(new GridLayout(3,1));
        setLayout(null);
        add(p4);

    }
    private void CustomizePanel5(){
        JPanel p5=new JPanel();
        TitledBorder titledBorder5=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Service Details",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p5.setBorder(titledBorder5);
        detailTransArea=new JTextArea();
        detailActivityArea=new JTextArea();
        detailAccomArea=new JTextArea();

        detailTransArea.setOpaque(false);
        detailAccomArea.setOpaque(false);
        detailActivityArea.setOpaque(false);

        detailTransArea.setEnabled(false);
        detailAccomArea.setEnabled(false);
        detailActivityArea.setEnabled(false);

        detailTransArea.setFont(myFont);
        detailAccomArea.setFont(myFont);
        detailActivityArea.setFont(myFont);

        p5.add(detailTransArea);
        p5.add(detailAccomArea);
        p5.add(detailActivityArea);

        p5.setBounds(330,450,300,300);
        p5.setLayout(new GridLayout(3,1));
        setLayout(null);
        add(p5);

    }
    private void CustomizePanel6(){
        JPanel p6=new JPanel();
        TitledBorder titledBorder6=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Agency Control",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p6.setBorder(titledBorder6);

        chatBtn=new JButton("Start Live Chat");
        makeReservationBTN=new JButton("Make Reservation");
        searchLBL=new JLabel("Search Customer by Phone");
        searchField=new JTextField();
        makeSearch=new JButton("Search Customer");

        p6.add(chatBtn);
        p6.add(makeReservationBTN);
        p6.add(searchLBL);
        p6.add(searchField);
        p6.add(makeSearch);

        makeReservationBTN.addActionListener(e ->{
            try {
                MakeReservation();
            } catch (IOException ex){
                throw new RuntimeException(ex);
            }

        });
        makeSearch.addActionListener(e->{
            SearchCustomerByMobileNumber();
        });

        p6.setBounds(660,15,300,300);
        p6.setLayout(new GridLayout(10,1));
        setLayout(null);
        add(p6);
    }
    private void CustomizePanel7(){
        JPanel p7=new JPanel();
        TitledBorder titledBorder7=BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,1),
                "Reservation Details",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        p7.setBorder(titledBorder7);

        reservationDetailsArea=new JTextArea();
        reservationDetailsArea.setOpaque(false);
        reservationDetailsArea.setEnabled(false);
        reservationDetailsArea.setFont(myFont2);

        JScrollPane scrollableTextArea=new JScrollPane(reservationDetailsArea);
        p7.add(scrollableTextArea);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        p7.setBounds(660,330,300,300);
        p7.setLayout(new GridLayout(1,1));
        setLayout(null);
        add(p7);
    }
    private Customer createCustomer(){
        Customer c=new Customer(
                cusName.getText(),
                cusPhone.getText(),
                cusAge.getText(),
                comboBox.getSelectedItem().toString(),
                isIndividualOrNot
        );
        System.out.println(""+c.toString());
        return c;
    }

    /**********************  Methods  *******************/
    private void MakeReservation() throws IOException {
        Customer c=createCustomer();
        ArrayList<Service>serviceArrayList=getChoosenServices();
        SaveReservationToDisk();
    }
    private void SearchCustomerByMobile(){

    }
    private ArrayList<Service> getChoosenServices(){
         ArrayList<Service> servicesArrayList=new ArrayList<>();
         if(isIndividualOrNot){
             //Case: Individual trips
             Transportation t;
             Activities act;
             Accommodation a;
             String selected1=(String) comboBox1.getSelectedItem();
             String selected2=(String) comboBox2.getSelectedItem();
             String selected3=(String) comboBox3.getSelectedItem();
             if(selected1.equals("Taxi")){
                 t=new Taxi();
             }else {
                 t=new Bus();
             }

             if(selected2.equals("Sea Cruise")){
                 act=new SeaCruise();
             }else{
                 act=new SkyDiving();
             }
             if(selected3.equals("Hotel")){
                 a=new Hotel();
             }else {
                 a=new Motel();
             }

             packagePrice=t.getPrice()+act.getPrice()+a.getPrice();
             //Adding the chosen services
             servicesArrayList.clear();
             servicesArrayList.add(t);
             servicesArrayList.add(act);
             servicesArrayList.add(a);
             DisplayTotalPrice(packagePrice);


         }else {
             //Group Trip
             if(package1RadioBTN.isSelected()){
                 //PackageOffer offer1=new Offer1();
                 PackageBuilder offer1=new Offer1();
                 offer1.createPackage();
                 DisplayTotalPrice(offer1.getP().getTotalPrice());

                 //Adding the chosen services
                 servicesArrayList.clear();
                 servicesArrayList.add(offer1.getP().getT());
                 servicesArrayList.add(offer1.getP().getAct());
                 servicesArrayList.add(offer1.getP().getA());
             } else if (package2RadioBTN.isSelected()) {
                 if(package1RadioBTN.isSelected()) {
                     //PackageOffer offer2 = new Offer2();
                     PackageBuilder offer2=new Offer2();
                     DisplayTotalPrice(offer2.getP().getTotalPrice());

                     //Adding the chosen services
                     servicesArrayList.clear();
                     servicesArrayList.add(offer2.getP().getT());
                     servicesArrayList.add(offer2.getP().getAct());
                     servicesArrayList.add(offer2.getP().getA());
                 }
                 
             }else if(package3RadioBTN.isSelected()){
                 if(package1RadioBTN.isSelected()) {
                     //PackageOffer offer3 = new Offer3();
                     PackageBuilder offer3=new Offer3();
                     DisplayTotalPrice(offer3.getP().getTotalPrice());

                     //Adding the chosen services
                     servicesArrayList.clear();
                     servicesArrayList.add(offer3.getP().getT());
                     servicesArrayList.add(offer3.getP().getT());
                     servicesArrayList.add(offer3.getP().getA());
                 }
             }
         }
         return servicesArrayList;
    }

    private void DisplayTotalPrice(int packagePrice) {
        int beforeDiscount=packagePrice;
        if(comboBox.getSelectedItem().equals("Student")){
            packagePrice=(int) (packagePrice * 0.9);
        } else if (comboBox.getSelectedItem().equals("Business")) {
            packagePrice=(int) (packagePrice * 0.5);
        } else if (comboBox.getSelectedItem().equals("Retired")) {
            packagePrice=(int) (packagePrice * 0.8);
        } else if (comboBox.getSelectedItem().equals("Employee")) {
            packagePrice=(int) (packagePrice * 0.7);
        }
        totalPriceLBL.setText("Total Price Before\n Discount: "+beforeDiscount + "\nTotal Price \n After Discount: \n " + packagePrice +"$");

    }
    public void SaveReservationToDisk() throws IOException {
        File file=new File("D:/myfile.dat");
        String phoneNumber=cusPhone.getText();
        if(!file.exists()){
            file.createNewFile();
            SaveCurrentReservationToNewFile(phoneNumber,file);
        }else {
            try{
                TreeMap<String,Reservation> newMapToSave=new TreeMap<>();
                InputStream is=new FileInputStream(file);
                ObjectInputStream ois =new ObjectInputStream(is);
                Reservation r=new Reservation(createCustomer(),getChoosenServices(),paymentStrategy);
                TreeMap<String ,Reservation>mapinFile=(TreeMap<String, Reservation>) ois.readObject();
                ois.close();
                is.close();

                for(Map.Entry<String,Reservation>m:mapinFile.entrySet()){
                    newMapToSave.put(m.getKey(),m.getValue());
                }

                newMapToSave.put(phoneNumber,r);

                OutputStream os=new FileOutputStream(file);
                ObjectOutputStream oos=new ObjectOutputStream(os);
                oos.writeObject(newMapToSave);
                oos.flush();
                oos.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void SaveCurrentReservationToNewFile(String phoneNumber, File file) throws IOException {
        Originator originator=new Originator(
                createCustomer(),
                getChoosenServices(),
                new CareTaker(),
                paymentStrategy
        );
        originator.createReservation(phoneNumber);

    }
    public void SearchCustomerByMobileNumber(){
        File file=new File("D:/myfile.dat");
        try{
            InputStream is=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(is);
            TreeMap<String,Reservation>mapInFile=(TreeMap<String, Reservation>) ois.readObject();
            ois.close();
            is.close();
            Reservation reservation_found=mapInFile.get(searchField.getText());
            reservationDetailsArea.setText(reservation_found.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MainScreen mainFrame=new MainScreen();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Tourist Agency System");
        mainFrame.setBounds(150,150,1200,800);
    }
}

