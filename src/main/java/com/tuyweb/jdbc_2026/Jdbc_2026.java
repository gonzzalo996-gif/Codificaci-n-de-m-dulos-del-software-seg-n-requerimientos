package com.tuyweb.jdbc_2026;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_2026 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_2026";
        String user = "root";
        String password = "";
        try {

            // Se crea la conexión a la base de datos
            Connection conn = DriverManager.getConnection(url, user, password);

            // Se crea la tenendencia para ejecutar hacia la base de datos
            Statement stmt = conn.createStatement();

            // Consulta de usuarios
            Consultar(stmt);

            // Inserción de usuarios
            stmt.execute("INSERT INTO `user` (`id`, `nombre`, `correo`, `clave`)"
                    + " VALUES (NULL, 'Daniela', 'daniela@gmail.com', 'daniela123');");

            System.out.println("Insercion de usuario");

            Consultar(stmt);

            // Actualizar a usuario
            System.out.println("Actualizacion de usuario");

            stmt.execute("UPDATE `user` SET `clave` = 'Dani123' WHERE "
                    + " `user`.`correo` = 'daniela@gmail.com';");

            Consultar(stmt);

            //Eliminación de usuario
            System.out.println("Eliminacion de usuario");

            stmt.execute("DELETE FROM user WHERE `user`.`correo` = 'daniela@gmail.com';");

            Consultar(stmt);

        } catch (SQLException ex) {
            System.getLogger(Jdbc_2026.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private static void Consultar(Statement stmt) throws SQLException {
        //Consulta de usuarios
        ResultSet rs = stmt.executeQuery("Select * from user");

        while (rs.next()) {

            System.out.println("id: " + rs.getInt("id") + " - "
                    + "Nombre: " + rs.getString("nombre") + " - "
                    + "Correo: " + rs.getString("correo") + " - " + "Clave: "
                    + rs.getString("clave"));
        }
    }
}
