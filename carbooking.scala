import java.sql.PreparedStatement

// Driver class with showroom details
// functionality
class Driver extends App{
  var name: String = "Tata Motors"
  var branch: Int = 10
  var location: String = "Coimbatore"

//  def drive(): Unit = { //method of the function
//    println("Have a nice day!")
//  }

  def profile(name: String): Unit = {  //overloading
    this.name=name // to refer current instance of class
  }

  def profile(name: String, branch: Int): Unit = {
    this.name = name
    this.branch = branch
  }

  def profile(name: String, branch: Int, location: String): Unit = {
    this.name = name
    this.branch = branch
    this.location = location
  }

  def getName: String = name // method that returns name of showroom
}
// Car class aggregated with driver and
// composed with in-built feature customer info
// EMI - yes or no.
class Car(var carChoice: String = "Nano", var driver: Driver = new Driver()) {
  var b: customerinfo = _ // abstract class _ default initial value Place holder

  def this(carChoice: String) {
    this(carChoice, new Driver())
  }

  def TheCar(): Unit = {
    println(s"$carChoice was a great choice!")
   // driver.drive()
  }

  def emi(): Unit = { //abstract method
    println("You can also book the car in EMI ?? Enter 1 for yes and 2 for No...")

    val choice: Int = scala.io.StdIn.readInt()
    if (choice == 1) {
      b = new yes()
    }
    if (choice == 2) {
      b = new no()
    }
    b.payment()
  }
}

// customerinfo abstract class and
// 2 subclasses yes and No.
abstract class customerinfo {
  var a: String =_
  var b: String =_
  var c: String =_
  private def addname(): Unit = {
    println("Enter the name : ")
    a = scala.io.StdIn.readLine()
  }

  private def addphonenumber(): Unit = {
    println("Enter the phone number : ")
    b = scala.io.StdIn.readLine()
  }

  private def addmail(): Unit = {
    println("Enter the Email-id : ")
    c = scala.io.StdIn.readLine()
  }

//  private def addsalary(): Unit = {
//    println("Enter the salary : ")
//    val c: String = scala.io.StdIn.readLine()
//  }
private def insert(): Unit = {
  val connection = dbaccess.getConnection
  val insertQuery = "INSERT INTO register (name,phone,email) VALUES (?, ?, ?)"
  val preparedStatement: PreparedStatement = connection.prepareStatement(insertQuery)
//reference to a prepared SQL statement.
  preparedStatement.setString(1,a)
  preparedStatement.setString(2, b)
  preparedStatement.setString(3, c)

  preparedStatement.executeUpdate()
}
////////////////////////////////////

  def getinformation(): Unit = {
    addname()
    addphonenumber()
    addmail()
    insert()
    //addsalary()
  }


  def payment(): Unit //abstract method

  def fullpay(): Unit
}

// Inheritance.
trait Clean {
  def emiEligibility(): Unit
}

class yes extends customerinfo with Clean {
  override def fullpay(): Unit = {
    println("Enter the Salary : ")
    val addsalary = scala.io.StdIn.readInt()
    if(addsalary >= 50000) {
      println("You are eligible for EMI Payments")
      println("Monthly payments has to be viewed in the website ")
    }
    else{
      println("You are not eligible for the EMI payments,Kindly make full Payment")
    }
  }

  override def payment(): Unit = {
    emiEligibility()
    getinformation()
    fullpay()
    println("Thank you , Have a nice day ")
  }

  override def emiEligibility(): Unit = {
    println("EMI Eligibility must be checked Properly")
    println("Please fill the Customer Details")
  }
}

class no extends customerinfo with Clean {
  override def fullpay(): Unit = {
    println("Final Payment has to be done in the website .  ")
  }

  override def payment(): Unit = {
    emiEligibility()
    getinformation()
    fullpay()
    println("Thank you. Have a nice day ")
  }

  override def emiEligibility(): Unit = {
    println("Please fill the User Details")
  }
}

// main function
object Carbooking {
  def main(args: Array[String]): Unit = {
    println("Welcome to our Showroom! ")
    println("These are the models Available in our Showroom.")
    println("Safari \nNexon \nNano \nIndigo \nAltroz")
    val name = new Driver()
    name.profile("TATA Showroom")
      //println(name)

    var c: Car = null
    println("Want to Book the Car? Press 0 for NO and 1 for YES")

    val carType: Int = scala.io.StdIn.readInt()
    if (carType == 1) {
      println("Enter Car name")
      val carName: String = scala.io.StdIn.readLine()
      if (carName=="Safari") {
        println("Mileage: 14.5 to 16.3 kmpl\nSeating Capacity: 6 & 7 Seater\nEngine: 1956 cc\nTransmission: Manual & Automatic" +
          "\nprice:27.34 Lakh")
      }
        else if(carName=="Nexon"){
        println("Price: Rs. 8.10 Lakh onwards\nFuel Type: Petrol & Diesel\nMileage: 17.01 to 24.08 kmpl\nSeating capacity: 5 seater")
      }
      else if (carName == "Nano") {
        println("Mileage: 21.9 - 33.0 kmpl\nPower: 37.48 bhp\nEngine: 624 cc\nFuel: Diesel / Petrol / Electric / CNG\nprice: 2.05 Lakh\n")
      }
      else if (carName == "Indigo") {
        println("Fuel: Petrol / Diesel / CNG\nEngine: 1193 cc - 1405 cc\nprice: 6.28 Lakh\nSeating capacity: 5 seater.")
      }
      else if (carName == "Altroz") {
        println("Body style: Hatchback\nNumber of doors: 5\nCargo volume: 210 to 345 L\nmileage: 18.05 kmpl to 26.2 km/kg\nprice: 8.5 Lakh")
      }
      else {
        println(s"Sorry !!...$carName is not available")
        System.exit(0)
      }
      c = new Car(carName)
    } else {
      println("Thank you!")
      System.exit(0)
    }
    c.TheCar() //methods of car
    c.emi() //method for EMI option
  }
}





