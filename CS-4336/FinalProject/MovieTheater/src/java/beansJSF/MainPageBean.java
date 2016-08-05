/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beansJSF;

import GEntities.Movie;
import GEntities.Purchase;
import GEntities.Theater;
import GEntities.Times;
import TheaterEJB.TheaterEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Garry_12
 */
@Named(value = "mainPageBean")
@SessionScoped
public class MainPageBean implements Serializable {

    @EJB
    private TheaterEJB theaterEJB;

    private Movie movieObj;
    private Theater theaterObj;
    private Times timesObj;
    private Purchase purchaseObj;
    private String tzip;

    private String Error = "";

    private String fName;
    private String lName;
    private String email;

    private String nameOnCard;
    private String cardType;
    private String cardNumber;
    private String expireDate;
    
    private String expireDateMon;
    private String expireDateYr;
    
    private String cardSecurityCode;

    private int numTickets = 1;
    private int numTotal = 10;

    private String SeatsStr;
    private String confNumber;

    public Movie getMovieObj() {
        return movieObj;
    }

    public void setMovieObj(Movie movieObj) {
        this.movieObj = movieObj;
    }

    public Theater getTheaterObj() {
        return theaterObj;
    }

    public void setTheaterObj(Theater theaterObj) {
        this.theaterObj = theaterObj;
    }

    public Times getTimesObj() {
        return timesObj;
    }

    public void setTimesObj(Times timesObj) {
        this.timesObj = timesObj;
    }

    public Purchase getPurchaseObj() {
        return purchaseObj;
    }

    public void setPurchaseObj(Purchase purchaseObj) {
        this.purchaseObj = purchaseObj;
    }

    public String getTzip() {
        return tzip;
    }

    public void setTzip(String tzip) {
        this.tzip = tzip;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public int getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }

    public String getSeatsStr() {
        return SeatsStr;
    }

    public void setSeatsStr(String SeatsStr) {
        this.SeatsStr = SeatsStr;
    }

    public String getConfNumber() {
        return confNumber;
    }

    public void setConfNumber(String confNumber) {
        this.confNumber = confNumber;
    }

    public String getExpireDateMon() {
        return expireDateMon;
    }

    public void setExpireDateMon(String expireDateMon) {
        this.expireDateMon = expireDateMon;
    }

    public String getExpireDateYr() {
        return expireDateYr;
    }

    public void setExpireDateYr(String expireDateYr) {
        this.expireDateYr = expireDateYr;
    }

    /*
     * Creates a new instance of MainPageBean
     */
    public MainPageBean() {
    }


    /*
      Getting listings
     */
    public List<Theater> getTheaterLst() {
        return theaterEJB.findAllTheatersByZip(this.tzip);
    }

    public List<Movie> getMoviesList() {
        return theaterEJB.findAllMoviesByTid(this.theaterObj);
    }

    public List<Times> getMovieTimesList() {
        return theaterEJB.findAllMovieTimes(this.theaterObj.getTid(), this.movieObj.getMId());
    }

    public void OnChangeTickets() {

        this.numTotal = this.numTickets * 10;
    }

    public void selectOneMenuListener(ValueChangeEvent event) {
        //This will return you the newly selected
        //value as an object. You'll have to cast it.
        Object newValue = event.getNewValue();
        //The rest of your processing logic goes here...
        this.numTotal = ((int) newValue) * 10;
    }

    /*
      Changing Pages
     */
    public String GoToTheatersPage() {

        this.movieObj = new Movie();
        this.theaterObj = new Theater();
        this.timesObj = new Times();

        //String s = "123456";
        String regex = "\\d{5}";
        if (this.tzip.matches(regex)) {
            Error = "";
            return "theaterListings.xhtml";
        } else {
            Error = "error: Zipcode must be five digits.";
            return "index.xhtml";
        }
    }

    public String GoToMoviesPage(Theater t) {
        this.theaterObj = t;
        return "movieListings.xhtml";
    }

    public String GoToMoviesDescriptionPage(Movie m) {
        this.movieObj = m;
        return "movieDesc.xhtml";
    }

    public String GoToTimeListings() {
        return "movieTimes.xhtml";
    }
//
//    public String GoToOrder(TIMES t) {
//
//        this.timesObj = t;
//        purchaseObj = new PURCHASE();
//        return "purchase.xhtml";
//    }

    public void GoToOrder(Times t) {

        this.timesObj = t;
        purchaseObj = new Purchase();
        //return "purchase.xhtml";
    }

    public String GoToOrderButton(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy");
        this.purchaseObj.setPmoviedate(java.sql.Date.valueOf(date));

        return "purchase.xhtml";
    }

    public String GoToDone() {

        this.purchaseObj.setPid(1);
        this.purchaseObj.setMId(this.movieObj);
        this.purchaseObj.setTid(this.theaterObj);
        this.purchaseObj.setPnumTickets(this.numTickets);
        this.purchaseObj.setPdatecur(new java.sql.Timestamp(new java.util.Date().getTime()));
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        this.purchaseObj.setPmoviedate(sqlDate);

        String regex = "\\d{16}";
        if (this.cardNumber.matches(regex)) {
            Error = "";
            theaterEJB.insertCheckOut(purchaseObj);

            switch (this.numTickets) {
                case 1:
                    this.SeatsStr = "G1";
                    break;
                case 2:
                    this.SeatsStr = "G1, G2";
                    break;
                case 3:
                    this.SeatsStr = "G1, G2, G3";
                    break;
                case 4:
                    this.SeatsStr = "G1, G2, G3, G4";
                    break;
                case 5:
                    this.SeatsStr = "G1, G2, G3, G4, H1";
                    break;
                case 6:
                    this.SeatsStr = "G1, G2, G3, G4, H1, H3";
                    break;
                case 7:
                    this.SeatsStr = "G1, G2, G3, G4, H1, H3, J4";
                    break;
                case 8:
                    this.SeatsStr = "G1, G2, G3, G4, H1, H3, J4, J6";
                    break;
                default:
                    this.SeatsStr = "";
                    break;
            }

            long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            this.confNumber = "" + number;
            return "done.xhtml";
        } else {
            Error = "error: Card Number Must be 16 digits.";
            return "purchase.xhtml";
        }

    }

    public String GoToIndex() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }

    public void handleEvent(AjaxBehaviorEvent event) {
        this.numTotal = this.numTickets * 10;
    }

}
