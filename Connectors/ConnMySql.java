package Connectors;

import java.sql.*;
import java.util.ArrayList;

public class ConnMySql
{
    public ConnMySql(String ip, String base, String username, String passwd)
    {
        try {
            m_connection = DriverManager.getConnection( "jdbc:mysql://" + ip + "/" + base, username, passwd );
            m_statement = m_connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ConnMySql(String base)
    {
        this("localhost", base, "root", "22agx22a");
    }

    public ResultSet select(String query)
    {
        try {
            return m_statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<String> nomChamps(ResultSet set)
    {
        try {
            ResultSetMetaData metaData = set.getMetaData();
            ArrayList<String> result = new ArrayList<String>();
            for (int colNum = 1; colNum < metaData.getColumnCount() + 1; ++colNum)
                result.add(metaData.getColumnLabel(colNum) + " ");
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public int execute(String query)
    {
        try {
            PreparedStatement s = m_connection.prepareStatement(query);
            return s.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public Connection getConnection() { return m_connection; }

    private Connection m_connection;
    private Statement m_statement;
}
