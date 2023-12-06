import java.sql.{Connection, DriverManager, PreparedStatement, SQLException}

object dbaccess extends App {
  var connection: Connection = _

  def connect(): Unit = {
    val url = "jdbc:mysql://localhost/testdb"
    val driver = "com.mysql.cj.jdbc.Driver"
    val username = "root"
    val password = "nithi17DEV$"
    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
    } catch {
      case e: Exception => e.printStackTrace
    }
  }
  def closeConnection(): Unit = {
    try {
      if (connection != null) {
        connection.close()
      }
    } catch {
      case e: SQLException => e.printStackTrace
    }
  }
  def getConnection: Connection = {
    connect()
    connection
  }
}
