package george.cw4.junittests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Cloud on 11/01/2015.
 */
public class TempSQL {

    public static void main(String[] args)
    {
        boolean done = false;
        String sName = null;
        while (!done)
        {
            sName = request.getParameter("studentName");
            if (isValidName(sName))
            {
                done = true;
            }
        }
        String query = "SELECT TITLE, SUPERVISOR FROM PROJ_DETAILS WHERE STUDENT = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try
        {
            preparedStatement.setString(1, sName);
            ResultSet results = preparedStatement.executeQuery( );
        }
        catch (SQLException sqe)
        {
            sqe.printStackTrace();
        }
    }
}
