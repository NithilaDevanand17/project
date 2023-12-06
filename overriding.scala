////Scala objects
//object overriding extends App {
//  class Animal {
//    val creatureType = "Wild"
//
//    protected def eat = println("eating")
//  }
//
//  //single class inheritance
//  class Cat extends Animal {
//    def crunch = {
//      eat
//      println("Crunch")
//    }
//  }
//
//  val cat = new Cat
//  cat.crunch
//
//
//
//  //  //counstructor
//  //  class Person(name: String, age:Int){
//  //    def this(name:String)=this(name,0)
//  //  }
//  //  class Adult(name:String, age:Int,idCard:String) extends Person(name)
//
//  //overriding - runtime
//  class Dog extends Animal {
//    override val creatureType = "Domestic"
//
//    override def eat = println("Crunch crunch")
//  }
//
//  val dog = new Dog
//  dog.eat
//  println(dog.creatureType)
//
//}
