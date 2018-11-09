// The Hospital class has member variable and a method.
// The processAndDisplay method uses object of classes Doctor and Patient.
// Thus the class Hospital and each of the classes Doctor and Patient has the
// USES-A relation.
class Hospital
{
    public String hospitalName;                     // name of the hospital
    final int numOfDoctors = 1;                     // number of doctors at the hospital
    final int numOfPatients = 2;                    // number of patients at the hospital

    // This method has been written in order to depict various relations
    // among classes. It creates objects of other classes, initializes them
    // and then displays the content of each object.
    public void processAndDisplay()
    {
        //---Instantiation Section---
        // creating arrays of objects of type Patient and Doctor
        Patient[] patientArray = new Patient[numOfPatients];
        Doctor[] doctorArray = new Doctor[numOfDoctors];

        // creating array element-objects for patientArray
        for (int i = 0; i < numOfPatients; i++)
        {
            patientArray[i] = new Patient();
            patientArray[i].drugPrescribed = new Drug();
        }
        // creating array element-objects for doctorArray
        for (int i = 0; i < numOfDoctors; i++)
        {
            doctorArray[i] = new Doctor();
        }

        //---Initialization Section---
        // initializing data for hospital name;
        hospitalName = "UC Davis Medical Center";

        // initializing data for patient 1
        patientArray[0].name = "John";
        patientArray[0].age = 18;
        patientArray[0].illness = "Cough";
        patientArray[0].drugPrescribed.drugName = "Benzonatate";
        patientArray[0].drugPrescribed.drugPrice = 15;

        // initializing data for patient 2
        patientArray[1].name = "Jack";
        patientArray[1].age = 20;
        patientArray[1].illness = "Hepatitis A";
        patientArray[1].drugPrescribed.drugName = "BayGam";
        patientArray[1].drugPrescribed.drugPrice = 100;

        // initializing data for doctor 1
        doctorArray[0].name = "Jill";
        doctorArray[0].age = 35;
        doctorArray[0].department = "Gastroenterology";

        // ---Content Display Section---
        // display hospital name
        System.out.println("Hospital Name: " + this.hospitalName);

        // display data for patient(s)
        System.out.println("---Patient(s)---");
        for (int i = 0; i < numOfPatients; i++)
        {
            System.out.println("Patient " + (i + 1));
            System.out.println("Name       : " + patientArray[i].name);
            System.out.println("Age        : " + patientArray[i].age);
            System.out.println("Illness    : " + patientArray[i].illness);
            System.out.println("Drug Name  : " + patientArray[i].drugPrescribed.drugName);
            System.out.println("Drug Price : " + patientArray[i].drugPrescribed.drugPrice);
            System.out.println();
        }

        // display data for doctor(s)
        System.out.println("\n---Doctor(s)---");
        for (int i = 0; i < numOfDoctors; i++)
        {
            System.out.println("Doctor " + (i + 1));
            System.out.println("Name       : " + doctorArray[i].name);
            System.out.println("Age        : " + doctorArray[i].age);
            System.out.println("Department : " + doctorArray[i].department);
        }
    }
}

// This class is a base class which uses has two member variables.
// The classes Patient and Doctors extends this class.
class Person
{
    public String name;                 // name of the person
    public int age;                     // age of the person
}

// This class is a child class of Person. The classes Person and Patient have the
// IS-A relation since Patient extends Person. The class Patient has an object of
// class Drug thus the classes have the HAS-A relation.
class Patient extends Person
{
    public String illness;              // illness name
    public Drug drugPrescribed;         // object containing the info for the drug prescribed
}

// This class is a child class of Person. The classes Person and Doctor have the
// IS-A relation since Doctor extends Person.
class Doctor extends Person
{
    String department;
}

// This class contains the data related to the drug prescribed.
class Drug
{
    String drugName;                    // name of the drug prescribed
    int drugPrice;                      // price of the drug prescribed
}

// The class driver which runs other classes by creating object of type Hospital
class Driver
{
    public static void main(String[] args)
    {
        // creating Hospital object
        Hospital obj = new Hospital();

        // call to the processAndDisplay() method
        obj.processAndDisplay();
    }
}