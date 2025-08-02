package application;

import event.lib.*;
import event.lib.Event;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.util.converter.IntegerStringConverter;

public class Controller implements Initializable {
    Pane root;
    Stage stage;
    Scene scene;

    //   Reya's code start
    public void customerHomeBtn(ActionEvent e) // customer home a niye jabe
    {
        try {
            root = FXMLLoader.load(getClass().getResource("CustomerHome.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();

            stage.setTitle("Home");

        } catch (Exception er) {
//            System.out.println("Error in customerHomeBtn");
        }
    }

    public void employeeHomeBtn(ActionEvent e) // emplyee home a niye jabe
    {
        try {
            root = FXMLLoader.load(getClass().getResource("EmployeeHome.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Home");
        } catch (Exception ex) {
//            System.out.println("Error in employeeHomeBtn");
        }
    }


    //    request for corporate event start

    public void requestForCorporateEventBtn(ActionEvent e)  // request for corporate event page a niye jabe
    {
        try {
            root = FXMLLoader.load(getClass().getResource("RequestForCorporateEvent.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Home");
        } catch (Exception ex) {
//            System.out.println("Error in requestForCorporateEventBtn");
        }
    }

    @FXML
    TextField eventTitleForRequestForCorporateEvent; // data receive korbe

    @FXML
    DatePicker eventDateForRequestForCorporateEvent; // data receive korbe , Lacal Date type

    @FXML
    TextField customerContactForRequestForCorporateEvent; // data receive korbe

    @FXML
    TextField durationDaysForRequestForCorporateEvent; // data receive korbe

    @FXML
    TextField numberOfParticipantsForRequestForCorporateEvent; // data receive korbe

    @FXML
    Button messageBoxForRequestForCorporateEvent;
    public void requestForCorporateEventSubmitBtn(ActionEvent e) {
        try {
//            requestedEvents Arraylist a jabe

////            System.out.println(eventTitleForRequestForCorporateEvent.getText() + eventDateForRequestForCorporateEvent.getValue() + customerContactForRequestForCorporateEvent.getText() + durationDaysForRequestForCorporateEvent.getText() + numberOfParticipantsForRequestForCorporateEvent.getText());
//            String title=eventTitleForRequestForCorporateEvent.getText()
//            if(eventTitleForRequestForCorporateEvent.getText().length()>0 && customerContactForRequestForCorporateEvent.getText().length()>0
//            && eventDateForRequestForCorporateEvent
//            ){
            String id=Main.evp1.requestEvent(eventTitleForRequestForCorporateEvent.getText(),
                    customerContactForRequestForCorporateEvent.getText(),
                    eventDateForRequestForCorporateEvent.getValue(),
                    Integer.parseInt(durationDaysForRequestForCorporateEvent.getText()),
                    Integer.parseInt(numberOfParticipantsForRequestForCorporateEvent.getText())
            );
            messageBoxForRequestForCorporateEvent.setText("Request done. Your request id: "+id+". Please remember this id.");
            messageBoxForRequestForCorporateEvent.setVisible(true);
            messageBoxForRequestForCorporateEvent.setStyle("-fx-background-color: #0af02d;");
////            System.out.println(eventDateForRequestForCorporateEvent.getValue().getClass().getName());
//            }
//            else{
//                messageBoxForRequestForCorporateEvent.setText("Please enter the corresponding event data properly.");
//                messageBoxForRequestForCorporateEvent.setVisible(true);
//                messageBoxForRequestForCorporateEvent.setStyle("-fx-background-color: #FF5733;");
//            }

        } catch (Exception er) {
//            System.out.println("Error in requestForCorporateEventSubmitBtn");
            messageBoxForRequestForCorporateEvent.setText("Please enter the corresponding event data properly. "+er.getMessage());
            messageBoxForRequestForCorporateEvent.setVisible(true);
            messageBoxForRequestForCorporateEvent.setStyle("-fx-background-color: #FF5733;");
        }
    }

//    request for corporate event end
//    Reya's code start


//    ====================================================================================================================================

    //    Lamia's code start
//    register for tour start
    public void registerForTourBtn(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("RegisterForTour.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
//            System.out.println("Error in registerForTourBtn");
        }
    }

    @FXML
    TextField tourIdForRegisterForTour;
    @FXML
    TextField participantForRegisterForTour;
    @FXML
    TextField contactForRegisterForTour;
    @FXML
    Button messageBoxForRegisterTour;
    public void registerTourSubmitBtn(ActionEvent e) {
        try {
            Main.evp1.registerForTour(tourIdForRegisterForTour.getText(), Integer.parseInt(participantForRegisterForTour.getText()), contactForRegisterForTour.getText());
//            System.out.println("Done");
            tableRefresh();
            messageBoxForRegisterTour.setText("Registered tour.");
            messageBoxForRegisterTour.setVisible(true);
//            #0af02d
            messageBoxForRegisterTour.setStyle("-fx-background-color: #0af02d");
        } catch (Exception ex) {
//            System.out.println("Error in registerTourSubmitBtn");
            messageBoxForRegisterTour.setText(ex.getMessage());
            messageBoxForRegisterTour.setVisible(true);
            messageBoxForRegisterTour.setStyle("-fx-background-color: #FF5733");

        }
    }

    //    register for tour end
//    pay bill start

    public void payBillBtn(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("PayBill.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
//            System.out.println("Error in payBillBtn");
        }
    }

    @FXML
    TextField eventIdForPayBill;
    @FXML
    Button totalBillForPayBill;
    @FXML
    Button billPaymentBtn;

    public void showTotalBillForPayBill(ActionEvent e) {
        try {
//            System.out.println(eventIdForPayBill.getText());
            double tmp = Main.evp1.payBill(eventIdForPayBill.getText());
//            System.out.println(tmp);
            if ((int) tmp > 0) {
                totalBillForPayBill.setText("Total bill: " + tmp);
                totalBillForPayBill.setVisible(true);
                billPaymentBtn.setVisible(true);
                totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
//                totalBillForPayBill.setDisable(true);
//                totalBillForPayBill.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            } else if ((int) tmp == 0) {
                totalBillForPayBill.setText("Bill not prepared yet. Please try after some time.");
                totalBillForPayBill.setVisible(true);
                totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
//                totalBillForPayBill.setDisable(true);
//                totalBillForPayBill.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            } else {
                totalBillForPayBill.setText("Bill not found.");
                totalBillForPayBill.setVisible(true);
                totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
            }
        } catch (Exception ex) {
            totalBillForPayBill.setVisible(true);
            totalBillForPayBill.setText(ex.getMessage());
            totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
//            totalBillForPayBill.setDisable(true);
//            totalBillForPayBill.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        }
    }

    public void payBillSubmitBtnPayBill(ActionEvent e) {
        try {
            Main.evp1.paymentDone(eventIdForPayBill.getText());
            totalBillForPayBill.setText("Payment Done.");
            totalBillForPayBill.setStyle("-fx-background-color: #0af02d");
            tableRefresh();
        } catch (Exception er) {
            totalBillForPayBill.setText(er.getMessage());
            totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
        }
    }
//    pay bill end
//    Lamia's code end


//    =========================================================================================================================

    //    Osman's code start
//    log out start
    public void logOutBtn(ActionEvent e) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Log Out");
            alert.setContentText("Are you sure you want to log out?");
            if (alert.showAndWait().get() == ButtonType.OK) {
                root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
                stage.setScene(scene);
                stage.show();

            }
        } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
        }
    }

    //    log out end
//    offer tour package start
    public void offerTourPackageBtn(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("OfferTourPackage.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            DataHandler.saveData(Main.evp1);

        } catch (Exception ex) {
//            System.out.println("Error in offerTourBtn");
        }
    }

    @FXML
    TextField eventTitleForOfferTourPackage;
    @FXML
    DatePicker eventDateForOfferTourPackage;
    @FXML
    TextField placesForOferTourPackage=new TextField();
    @FXML
    TextField durationDaysForOfferTourPackage;
    @FXML
    TextField perPersonForOfferTourPackage;
    @FXML
    TextField numberOfParticipantsForOfferTourPackage;
    @FXML
    Button offerTourPackageSubmitButton = new Button("OfferTourPackage");
    @FXML
    Button massageBoxOfferBtn = new Button();

    public void offerTourPackageSubmitBtn(ActionEvent e) {
        try {
            String tourId;
            if(eventTitleForOfferTourPackage.getText().length()<1 || !(eventDateForOfferTourPackage.getValue() instanceof LocalDate) ||
            durationDaysForOfferTourPackage.getText().length()<1 || numberOfParticipantsForOfferTourPackage.getText().length()<1 || perPersonForOfferTourPackage.getText().length()<1) {

                massageBoxOfferBtn.setText("Please correct enter data.");
                massageBoxOfferBtn.setStyle("-fx-background-color: #FF5733");
                massageBoxOfferBtn.setVisible(true);

            }
            else if(placesForOferTourPackage.getText()==null){
            tourId = Main.evp1.offerTourPackage(
                    eventTitleForOfferTourPackage.getText(),
                    eventDateForOfferTourPackage.getValue(),
                    Integer.parseInt(durationDaysForOfferTourPackage.getText()),
                    Integer.parseInt(numberOfParticipantsForOfferTourPackage.getText()),
                    Integer.parseInt(perPersonForOfferTourPackage.getText()));

                massageBoxOfferBtn.setText("Offered tour successfully.");
                massageBoxOfferBtn.setStyle("-fx-background-color: #13ea31 ");
                massageBoxOfferBtn.setVisible(true);
            }
            else{
                ArrayList<String> placesToVisit = new ArrayList<>(Arrays.asList(placesForOferTourPackage.getText().split(",")));
                tourId = Main.evp1.offerTourPackage
                        (
                        eventTitleForOfferTourPackage.getText(),
                        eventDateForOfferTourPackage.getValue(),
                        Integer.parseInt(durationDaysForOfferTourPackage.getText()),
                        Integer.parseInt(numberOfParticipantsForOfferTourPackage.getText()),
                        Integer.parseInt(perPersonForOfferTourPackage.getText()),
                        placesToVisit);

                massageBoxOfferBtn.setText("Offered tour successfully.");
                massageBoxOfferBtn.setStyle("-fx-background-color: #13ea31 ");
                massageBoxOfferBtn.setVisible(true);
            }
//            massageBoxOfferBtn.setDisable(true);
////            System.out.println(Main.evp1.getEvents());
        } catch (Exception er) {
            massageBoxOfferBtn.setText(er.getMessage());
            massageBoxOfferBtn.setStyle("-fx-background-color: #FF5733");
            massageBoxOfferBtn.setVisible(true);
//            massageBoxOfferBtn.setDisable(true);
//            System.out.println("Error in offerTourPackageSubmitBtn");
        }
    }


//    offer tour package end

//    Osman's code end


//    ====================================================================================================================================


    //    Aranna's code start
//    Manage Events start
    @FXML
    ListView eventStatus = new ListView();

    public void mangeEventsBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("ManageEvent.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("Manage Events");
        } catch (Exception e) {
//            System.out.println("Error in mangeEventsBtn");
        }
    }

    @FXML
    TextField eventIdAcceptEvent;
    @FXML
    Button messgaeBoxAcceptEvent = new Button();

    public void acceptEvent(ActionEvent event) {
        try {

            Main.evp1.acceptEvent(eventIdAcceptEvent.getText());
//            eventStatus.setText(Main.evp1.showRequestedEvents());
            eventStatus.setStyle("-fx-font-size:16;-fx-font-weight:bold;-fx-alignment: center");
            messgaeBoxAcceptEvent.setText("Accepted Event.");
            messgaeBoxAcceptEvent.setVisible(true);
            messgaeBoxAcceptEvent.setStyle("-fx-background-color: #13ea31;-fx-alignment: center;-fx-font-size: 16;-fx-font-weight: bold; ");
//            messgaeBoxAcceptEvent.setDisable(true);
            tableRefresh();
        } catch (Exception e) {
            messgaeBoxAcceptEvent.setText(e.getMessage());
            messgaeBoxAcceptEvent.setVisible(true);
            messgaeBoxAcceptEvent.setStyle("-fx-background-color: #FF5733 ;-fx-alignment: center;-fx-font-size: 16;-fx-font-weight: bold;");
//            messgaeBoxAcceptEvent.setDisable(true);
//            eventStatus.setText(Main.evp1.showRequestedEvents());
//            eventStatus.setStyle("-fx-font-size:16;-fx-font-weight:bold;-fx-alignment: center");
        }
    }

    //    Manage Events end
    //    Manage Tasks start
    public void manageTasksBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("ManageTask.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("Manage Tasks");
        } catch (Exception e) {
//            System.out.println("Error in manageTasksBtn");
        }
    }

    @FXML
    RadioButton addTaskRadioBtn;
    @FXML
    RadioButton startTaskRadioBtn;
    @FXML
    RadioButton endTaskRadioBtn;
    @FXML
    TextField eventIdTaskManage;
    @FXML
    TextField taskTitleTaskManage;
    @FXML
    TextField taskDescriptionTaskManage;

    @FXML
    Button messgaeBoxTaskManage;

    public void manageTasks(ActionEvent event) {
        try {
            if (addTaskRadioBtn.isSelected()) {
//                try {
                if(eventIdTaskManage.getText().length()>0 && taskTitleTaskManage.getText().length()>0 && taskDescriptionTaskManage.getText().length()>0) {
                    Main.evp1.addEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText(), taskDescriptionTaskManage.getText());
//                    System.out.println(Main.evp1.getEvents());
                    messgaeBoxTaskManage.setText("Task added successfully.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#13ea31; -fx-font-weight: bold; -fx-font-size: 16;");
                    messgaeBoxTaskManage.setVisible(true);
                    tableRefresh();
                }
                else{
                    messgaeBoxTaskManage.setText("Please enter data correctly.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733; -fx-font-weight: bold; -fx-font-size: 16;");
                    messgaeBoxTaskManage.setVisible(true);
                }
//                } catch (Exception e) {
////                    System.out.println(eventIdTaskManage.getText() + " " + taskTitleTaskManage.getText() + " " + taskDescriptionTaskManage.getText());
//                    messgaeBoxTaskManage.setText(e.getMessage().toString());
//                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
//                    messgaeBoxTaskManage.setVisible(true);
//                }

            } else if (startTaskRadioBtn.isSelected()) {
////                System.out.println("Star Task");
//                try {
//                    System.out.println("Task title manage:"+taskTitleTaskManage.getText());
                    if(taskTitleTaskManage.getText().length()>0)
                    {
                    Main.evp1.startEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task start successfully.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#13ea31; -fx-font-weight: bold; -fx-font-size: 16;");
                    messgaeBoxTaskManage.setVisible(true);
                    }
                    else{
                        messgaeBoxTaskManage.setText("Please enter data correctly.");
                        messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733; -fx-font-weight: bold; -fx-font-size: 16;");
                        messgaeBoxTaskManage.setVisible(true);
                    }
//                } catch (Exception e) {
////                    messgaeBoxTaskManage.setText(e.toString());
//                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
//                    messgaeBoxTaskManage.setVisible(true);
//                }
                tableRefresh();
            } else if (endTaskRadioBtn.isSelected()) {
////                System.out.println("End Btn");
//                try {
                    if(taskTitleTaskManage.getText().length()>0){
                    Main.evp1.completeEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task completed successfully.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#13ea31; -fx-font-weight: bold; -fx-font-size: 16;");
                    messgaeBoxTaskManage.setVisible(true);}
                    else{
//                        messgaeBoxTaskManage.setText("Please enter data correctly.");
                        messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                        messgaeBoxTaskManage.setVisible(true);
                    }
//                } catch (Exception e) {
////                    System.out.println(e.toString());
////                    messgaeBoxTaskManage.setText(e.getMessage());
//                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
//                    messgaeBoxTaskManage.setVisible(true);
//                }
                tableRefresh();
            } else {
                messgaeBoxTaskManage.setText("Please select one of the following actions: Add task, Start task, End task.");
                messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                messgaeBoxTaskManage.setVisible(true);
            }
        } catch (Exception e) {
            messgaeBoxTaskManage.setText(e.getMessage());
            messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16;");
            messgaeBoxTaskManage.setVisible(true);
        }
    }

    public void disableTaskDescription(ActionEvent event) {
        try {
            if (startTaskRadioBtn.isSelected() || endTaskRadioBtn.isSelected()) {
                taskDescriptionTaskManage.setDisable(true);
                messgaeBoxTaskManage.setText("Please enter correct event id and task title.");
                messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                messgaeBoxTaskManage.setVisible(true);
            } else {
                taskDescriptionTaskManage.setDisable(false);
                messgaeBoxTaskManage.setText("Please enter correct event id.");
                messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                messgaeBoxTaskManage.setVisible(true);
            }
        } catch (Exception e) {
            messgaeBoxTaskManage.setText("Please enter correct event id and task title.");
            messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
            messgaeBoxTaskManage.setVisible(true);
        }
    }

    //    Manage Tasks end

    //    Assign Event manager start
    public void assignEventManagerBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("AssignEventManager.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("Assign Event Manager");
        } catch (Exception e) {
//            System.out.println("Error in assignEventManagerBtn");
        }
    }

    @FXML
    TextField eventIdAssignEventManager;
    @FXML
    TextField managerNameAssignEventManager;
    @FXML
    Button messageBoxForAssignEventManager;

    public void assignEventManager(ActionEvent event) {
        try {
            Main.evp1.assignEventManager(eventIdAssignEventManager.getText(), managerNameAssignEventManager.getText());
            messageBoxForAssignEventManager.setText("Assign Event Manager");
            messageBoxForAssignEventManager.setStyle("-fx-background-color:#13ea31 ;-fx-font-weight: bold;-fx-font-size: 16");
//            messageBoxForAssignEventManager.setDisable(true);
            messageBoxForAssignEventManager.setVisible(true);
            tableRefresh();

        } catch (Exception e) {
            messageBoxForAssignEventManager.setText(e.getMessage());
            messageBoxForAssignEventManager.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
//            messageBoxForAssignEventManager.setDisable(true);
            messageBoxForAssignEventManager.setVisible(true);
        }
    }

    //    Assign Event manager end


    // Table view for customer start
    @FXML
    TableView<Event> eventTableViewForCustomer = new TableView<>();
    @FXML
    TableView<Event> eventTableViewForCustomerRegisterTour = new TableView<>();

    @FXML
    TableColumn<Event, String> eventIdTableViewForCustomer = new TableColumn<>();

    @FXML
    TableColumn<Event, String> eventTitleTableViewForCustomer = new TableColumn<>();

    @FXML
    TableColumn<Event, LocalDate> eventDateTableViewForCustomer = new TableColumn<>();

    @FXML
    TableColumn<Event, Integer> eventDurationDaysForCustomer = new TableColumn<>();

    @FXML
    TableColumn<Event, Integer> perPersonPriceForCustomer = new TableColumn<>();

    @FXML
    TableColumn<Event, Integer> eventNumOfParticipantsForCustomer = new TableColumn<>();

    @FXML
    TableColumn<Event, String> totalRegisteredForCustomer = new TableColumn<>();

    // Table view for customer end


    //  Table view for employee start
//    Accepted event table view start
    @FXML
    TableView<Event> eventTableViewForEmployee = new TableView<>();

    @FXML
    TableColumn<Event, String> eventIdTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, String> eventTitleTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, LocalDate> eventDateTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> eventDurationDaysForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> perPersonPriceForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> eventNumOfParticipantsForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, ArrayList<Task>> allTaskListForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, String> eventManagerForEmployee = new TableColumn<>();

//    Accepted event for table view end

//    Requested event for table view start

    @FXML
    TableView<Event> requestedEventTableViewForEmployee = new TableView<>();

    @FXML
    TableColumn<Event, String> requestedEventIdTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, String> requestedEventTitleTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, LocalDate> requestedEventDateTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> requestedEventDurationDaysForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> requestedEventNumOfParticipantsForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, String> requestedEventManagerForEmployee = new TableColumn<>();


    @FXML
    TableColumn<Event, String> paymentStatusCol = new TableColumn<>();


//    Requested event for table view end

    //  Table view for employee end

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            tableRefresh();
            meid.setText(meidStr);
            meTitle.setText(meTitleStr);
            meDate.setText(meDateStr);
            meDuration.setText(meDurationStr);
            meNumOfParticipants.setText(meNumOfParticipantsStr);
            mePlaces.setText(mePlacesStr);
//            if(meTasksStr!=null)meTasks.setText(meTasksStr.replaceAll("\n","\n"));
//            else meTasks.setText(meTasksStr);
            mePrice.setText(mePriceStr);
            meTasks.setVisible(false);
//            if(meTasksStr!=null)System.out.println(meTasksStr.replaceAll("\n"," "));
//            System.out.println("Init str: "+str);
            str="";
        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }
    }


    public void tableRefresh() {
        try {
//            System.out.println("table refresh called");
            if (Main.evp1.getEvents().size() < 1) {
                eventTableViewForCustomer.getItems().clear();
                eventTableViewForEmployee.getItems().clear();
                requestedEventTableViewForEmployee.getItems().clear();
            } else {
                eventTableViewForCustomer.getItems().clear();
                eventTableViewForEmployee.getItems().clear();
                eventTableViewForCustomerRegisterTour.getItems().clear();
                for (Event e : Main.evp1.getEvents()) {
                    if (e instanceof TourPackage) {
                        eventTableViewForCustomerRegisterTour.getItems().add(e);
                        eventTableViewForCustomer.getItems().add(e);
//                        System.out.println(((TourPackage) e).getNumOfRegisteredParticipants());
                    } else {
                        eventTableViewForCustomer.getItems().add(e);
                    }
                    eventTableViewForEmployee.getItems().add(e);
                }
            }

//            if (Main.evp1.getRequestedEvents().size() < 1) {
//                requestedEventTableViewForEmployee.getItems().clear();
//                requestedEventTableViewForEmployee.setVisible(false);
//            } else {
                requestedEventTableViewForEmployee.getItems().clear();
                for (Event e : Main.evp1.getRequestedEvents()) {
                    requestedEventTableViewForEmployee.getItems().add(e);
                }
//            }
// Table view for customer start
            eventIdTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventId"));
            eventTitleTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
            eventDateTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
            eventDurationDaysForCustomer.setCellValueFactory(new PropertyValueFactory<>("durationInDays"));
            perPersonPriceForCustomer.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            totalRegisteredForCustomer.setCellValueFactory(new PropertyValueFactory<>("numOfRegisteredParticipants"));
            eventNumOfParticipantsForCustomer.setCellValueFactory(new PropertyValueFactory<>("numOfParticipants"));

            paymentStatusCol.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
//            eventTableViewForCustomer.setItems(eventListForCustomer);
//  Table view for customer end

//  Table view for employee accepted event start
            eventTableViewForEmployee.setEditable(true);
            eventIdTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventId"));
            eventIdTableViewForEmployee.setEditable(false);

            eventTitleTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
            eventTitleTableViewForEmployee.setCellFactory(TextFieldTableCell.forTableColumn());
            eventTitleTableViewForEmployee.setEditable(true);

            eventDateTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
            eventDurationDaysForEmployee.setCellValueFactory(new PropertyValueFactory<>("durationInDays"));

            perPersonPriceForEmployee.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            perPersonPriceForEmployee.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            perPersonPriceForEmployee.setEditable(true);

            eventNumOfParticipantsForEmployee.setCellValueFactory(new PropertyValueFactory<>("numOfParticipants"));
            eventNumOfParticipantsForEmployee.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            eventNumOfParticipantsForEmployee.setEditable(true);


            eventManagerForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventManager"));
            eventManagerForEmployee.setCellFactory(TextFieldTableCell.forTableColumn());
            eventManagerForEmployee.setEditable(true);

            allTaskListForEmployee.setCellValueFactory(new PropertyValueFactory<>("tasks"));
//            eventListForEmployee.addAll(Main.evp1.getEvents());

            eventTitleTableViewForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, String> event) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        event.getRowValue().setEventTitle(event.getNewValue());
                    }
                } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
                }

            });

            perPersonPriceForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, Integer> event) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        event.getRowValue().setUnitPrice(event.getNewValue());
                    }
                } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
                }
            });

            eventManagerForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, String> event) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        event.getRowValue().setEventManager(event.getNewValue());
                    }
                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
                }
            });

            eventNumOfParticipantsForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, Integer> event) -> {

                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
//                        System.out.println(event.getNewValue());
                        event.getRowValue().setNumOfParticipants(event.getNewValue());
                    }
                } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
                }
            });


//  Table view for employee accepted event end


//  Table view for employee requested event start
            requestedEventTableViewForEmployee.setEditable(true);
            requestedEventIdTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventId"));
            requestedEventIdTableViewForEmployee.setEditable(false);
            requestedEventTitleTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
            requestedEventTitleTableViewForEmployee.setEditable(false);
            requestedEventDateTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
            requestedEventDateTableViewForEmployee.setEditable(false);
            requestedEventDurationDaysForEmployee.setCellValueFactory(new PropertyValueFactory<>("durationInDays"));
            requestedEventDurationDaysForEmployee.setEditable(false);
            requestedEventNumOfParticipantsForEmployee.setCellValueFactory(new PropertyValueFactory<>("numOfParticipants"));
            requestedEventNumOfParticipantsForEmployee.setEditable(false);
            requestedEventManagerForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventManager"));
            requestedEventManagerForEmployee.setCellFactory(TextFieldTableCell.forTableColumn());
            requestedEventManagerForEmployee.setEditable(true);
//  Table view for employee requested event end

        } catch (Exception e) {
//            System.out.println("Error in initialize");
        }
    }


    //    Not required for this project start
    public void resetData(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation.");
        alert.setContentText("Are you want to change the information?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Main.evp1.deleteData();
        }
    }
//    Not required for this project end
//    Aranna's code end

    //    search tour start
    public void searchForTourBtnForCustomer(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("SearchEventForCustomer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Search Event");

        } catch (Exception e) {
//            System.out.println("Something went wrong");
        }
    }
    public void searchForTourBtnForEmployee(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("SearchEventForEmployee.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Search Event");

        } catch (Exception e) {
//            System.out.println("Something went wrong");
        }
    }
    @FXML
    TextField searchTourId=new TextField();

    public void searchForTourForCustomer(ActionEvent event) {
        eventTableViewForCustomerRegisterTour.getItems().clear();
        ArrayList<TourPackage>tourList=new ArrayList<>();
        for(Event it:Main.evp1.searchForTourPackages(searchTourId.getText())) {
            if(it instanceof TourPackage)eventTableViewForCustomerRegisterTour.getItems().add((TourPackage)it);
        }
    }

    @FXML
    TextArea displayArea=new TextArea();
    @FXML
    Button meid=new Button("Event id");
    @FXML
    Button meTitle=new Button("Event Title");
    @FXML
    Button meDate=new Button("Event Date");
    @FXML
    Button meDuration=new Button("Duration");
    @FXML
    Button mePrice=new Button("Unit Price");
    @FXML
    Button meNumOfParticipants=new Button("Number of Participants");
    @FXML
    Button meTasks= new Button("Tasks");
    @FXML
    Button mePlaces= new Button("Places");

    public void showModal(Stage ownerStage) {
        try{

            Stage modalStage = new Stage();
            modalStage.initOwner(ownerStage);
            modalStage.initModality(Modality.APPLICATION_MODAL);
            Timeline timeline = new Timeline(
                    new KeyFrame(javafx.util.Duration.seconds(5),
                            event -> modalStage.close())
            );
            timeline.setCycleCount(1); // Run only once
            timeline.play();
            Pane modalRoot =FXMLLoader.load(getClass().getResource("Modal1.fxml"));
//            closeButton.setOnAction(e -> modalStage.close());  // Close the modal on button click
//            closeButton.setStyle("-fx-background-color: #FF5733; -fx-font-size: 16; -fx-font-weight: bold;-fx-pref-width: 250;-fx-pref-height: 250;text: \"Close\";");
//            closeButton.setText("Close");
            Scene modalScene = new Scene(modalRoot);
            modalStage.setTitle("Result");
            modalStage.setMaximized(true);
            modalStage.setScene(modalScene);
            modalStage.showAndWait();


        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }

    }


// search tour end
//    get data from table start
    public static String meidStr,meTitleStr,meDateStr,meDurationStr,mePriceStr,meNumOfParticipantsStr,meTasksStr,mePlacesStr,str;
    public void getData(MouseEvent event) {
            try {
                int selectedIndex = event.getSource() instanceof TableView ? ((TableView) event.getSource()).getSelectionModel().getSelectedIndex() : -1;
                if(selectedIndex<=-1){
                    return;
                }
                Event event1= eventTableViewForCustomer.getItems().get(selectedIndex);
                meidStr="Event id: "+eventTableViewForCustomer.getItems().get(selectedIndex).getEventId();
                meTitleStr="Event title: "+eventTableViewForCustomer.getItems().get(selectedIndex).getEventTitle();
                meDateStr="Event date: "+eventTableViewForCustomer.getItems().get(selectedIndex).getEventDate().toString();
                meDurationStr="Duration days of event: "+String.valueOf((Integer) eventTableViewForCustomer.getItems().get(selectedIndex).getDurationInDays());
                mePriceStr="Per person fee: "+ String.valueOf((Integer) eventTableViewForCustomer.getItems().get(selectedIndex).getUnitPrice());
                meNumOfParticipantsStr="Maximum number of participants: " +String.valueOf((Integer) eventTableViewForCustomer.getItems().get(selectedIndex).getNumOfParticipants());
                if(event1.getTasks().size()>0)meTasksStr="Tasks of event: "+eventTableViewForCustomer.getItems().get(selectedIndex).getTasks().toString();
                else meTasksStr="No tasks selected yet.";
                TourPackage tp=(TourPackage)eventTableViewForCustomer.getItems().get(selectedIndex);
                if(tp.getPlacesToVisit().size()>0)mePlacesStr="Visting places: "+tp.getPlacesToVisit().toString();
                else mePlacesStr="No place selected yet.";
                str=meidStr+meTitleStr+meDateStr+meDurationStr+mePriceStr+meNumOfParticipantsStr+mePlacesStr;
//                System.out.println(event1.toString());
//                System.out.println("Str2024 :"+str);
//                System.out.println("tasks: "+meTasksStr);
                showModal(stage);
            }
            catch (Exception e) {
//                System.out.println(e.getMessage());
            }
    }

    public String displayData(){
        return str;
    }
//    get data from table end
}
