///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//package Services;
//
//import DAO.JpaUtil;
//import DAO.PersonDAO;
//import Model.Demand;
//import Model.Offer;
//import Model.Person;
//import Model.Service;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.RollbackException;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author X
// */
//public class ServicesTest {
//    
//    public ServicesTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//        JpaUtil.init();
//        Person person = new Person("fifi", "12345", "+12345", "fifi@gmail.com",
//                "fifi", "img.png", "Residence A");
//        PersonDAO personDAO = new PersonDAO();
//        
//        JpaUtil.createEntityManager();
//        JpaUtil.openTransaction();
//        
//        personDAO.persist(person);
//        
//        try {
//            JpaUtil.validateTransaction();
//        } catch (RollbackException e) {
//            JpaUtil.cancelTransaction();
//        }
//        
//        JpaUtil.closeEntityManager();
//        
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//        JpaUtil.destroy();
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//    
//    /**
//     * Test of connexion method, of class Services.
//     */
//    @org.junit.Test
//    public void testConnexion() {
//        System.out.println("connexion");
//        String mail = "";
//        String mdp = "";
//        Services instance = new Services();
//        Person expResult = null;
//        Person result = instance.connexion(mail, mdp);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to //fail.
//        ////fail("The test case is a prototype.");
//    }
//    
//    /**
//     * Test of createDemand method, of class Services.
//     */
//    @org.junit.Test
//    public void testCreateDemandOK() throws ParseException {
//        System.out.println("createDemandOK");
//        Services instance = new Services();
//        Person person  = instance.getPersonById(1L);
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        
//        Demand demand = new Demand(person, "Bricolage", null, "marteau", formatDate.parse("12/05/2019 19:00")
//                ,"Résidence M", "prêt", 2, "Recherche marteau classique","heures", "heures", 2);
//        boolean expResult = true;
//        boolean result = instance.createDemand(demand);
//        System.out.println(result);
//        assertEquals(expResult, result);
//    }
//    
//    /**
//     * Fail car la date n'est pas renseignée
//     *
//     * Test of createDemand method, of class Services.
//     */
//    @org.junit.Test
//    public void testCreateDemandFail() throws ParseException {
//        System.out.println("createDemandFail");
//        
//        Person person = new Person("fifi", "12345", "+12345", "fifi@gmail.com",
//                "fifi", "img.png", "Residence A");
//        
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        
//        Demand demand = new Demand(person, "Bricolage",null, "marteau", formatDate.parse("09/05/2019 20:00")
//                ,"Résidence M", "prêt", 2, "Recherche marteau classique", "heures", "heures", 2);
//        
//        Services instance = new Services();
//        boolean expResult = false;
//        boolean result = instance.createDemand(demand);
//        assertEquals(expResult, result);
//    }
//    
//    /**
//     * Test of createOffer method, of class Services.
//     */
//    @org.junit.Test
//    public void testCreateOfferOK() throws ParseException {
//        System.out.println("createOfferOK");
//        Services instance = new Services();
//        Person person  = instance.getPersonById(1L);
//        
//
////        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
////        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
////        
////        Offer offer = new Offer(person, "Bricolage", "marteau", formatDate.parse("12/05/2019"), formatTime.parse("19:00")
////                ,"Résidence M", "prêt", 2, "Propose un marteau classique", "heures", 2);
////        
//
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Offer offer = new Offer(person, "Bricolage",null, "marteau", formatDate.parse("09/05/2019 20:00")
//                ,"Résidence M", "prêt", 2, "Propose un marteau classique", "heures","heures", 2);
//        
//
//        boolean expResult = true;
//        boolean result = instance.createOffer(offer);
//        assertEquals(expResult, result);
//    }
//    
//    /**
//     * Test of createOffer method, of class Services.
//     */
//    @org.junit.Test
//    public void testCreateOfferFail() throws ParseException {
//        System.out.println("createOfferFail");
//        Services instance = new Services();
//        Person person  = instance.getPersonById(1L);
//        
//        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        
//        Offer offer = new Offer(person, "Bricolage", null, "marteau", formatDate.parse("09/05/2019 20:00")
//                ,"Résidence M", "prêt", 2, "Propose un marteau classique","heures", "heures", 2);
//        
//        boolean expResult = true;
//        boolean result = instance.createOffer(offer);
//        assertEquals(expResult, result);
//    }
//    
//    /**
//     * Test of findAllDemands method, of class Services.
//     */
//    @org.junit.Test
//    public void testFindAllDemands() {
//        System.out.println("findAllDemands");
//        Services instance = new Services();
//        List<Demand> expResult = new ArrayList<Demand>();
//        List<Demand> result = instance.findAllDemands();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to //fail.
//        //fail("The test case is a prototype.");
//    }
//    
//    /**
//     * Test of findAllDemandsWithFilter method, of class Services.
//     */
//    
//   
//    @org.junit.Test
//    public void testFindAllServicesWithFilterOK() throws ParseException {
//        System.out.println("findAllServicesWithFilter");
//        Services instance = new Services();
////        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
////        Person person = instance.getPersonById(1L);
////        Offer offer = new Offer(person, "Bricolage", "010010100110", "marteau",  formatDate.parse("10/04/2019 19:00")
////                ,"Residence M", "prêt", 2, "Propose un marteau classique", "heures", "heures", 2);
////        Offer offer2 = new Offer(person, "Bricolage", "010010100110", "four",  formatDate.parse("10/04/2019 19:00")
////                ,"Residence M", "prêt", 2, "Propose un marteau classique", "heures", "heures", 2);
//        
//        List<Service> expResult = new ArrayList<Service>();
//        Service s = instance.getServiceById(2L);
//        expResult.add(s);
//         
//        //List<Service> result = instance.findAllServicesWithFilter("marteau","Bricolage", "Residence M", "10/05/2019", "19:30", "1", "heures", "3", "Offer");
//       // System.out.println("list : " + result.size());
//        
//       // assertEquals(s, result.get(0));
//        // TODO review the generated test code and remove the default call to //fail.
//    }
//    
//     @org.junit.Test
//    public void testFindAllServicesWithFilterFail() throws ParseException {
//        System.out.println("findAllServicesWithFilter");
//        Services instance = new Services();
//        List<Service> expResult = new ArrayList<Service>();
//        Service s = instance.getServiceById(3L);
//        System.out.println("serv" + s.toString());
//                
//       // List<Service> result = instance.findAllServicesWithFilter("marteau","Bricolage", "Residence M", "", "", "5","minutes","2" ,"Offer");
//       
//        /* System.out.println("list : " + result.size());
//        System.out.println("serv" + result.get(0).toString());
//        assertEquals(expResult, result.get(0));*/
//        
//        // TODO review the generated test code and remove the default call to //fail.
//
//    }
//      
//    
//    /**
//     * Test of findAllOffers method, of class Services.
//     */
//    @org.junit.Test
//    public void testFindAllOffers() {
//        System.out.println("findAllOffers");
//        Services instance = new Services();
//        List<Offer> expResult = new ArrayList<Offer>();
//        List<Offer> result = instance.findAllOffers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to //fail.
//        //fail("The test case is a prototype.");
//    }
//    
//    /**
//     * Test of findAllOffersWithFilters method, of class Services.
//     */
//    @org.junit.Test
//    public void testFindAllOffersWithFilters() {
//        System.out.println("findAllOffersWithFilters");
//        Services instance = new Services();
//        List<Offer> expResult = new ArrayList<Offer>();
//        List<Offer> result = instance.findAllOffersWithFilters();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to //fail.
//        //fail("The test case is a prototype.");
//    }
//    
//    /**
//     * Test of getPersonById method, of class Services.
//     */
//    @org.junit.Test
//    public void testGetPersonById() {
//        System.out.println("getPersonById");
//        Long idPerson = 0L;
//        Services instance = new Services();
//        Person expResult = null;
//        Person result = instance.getPersonById(idPerson);
//        assertEquals(expResult, result);
//    }
//    
//}
