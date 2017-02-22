package sqlmanager;

import sqlmanager.connection.SingletonConnection;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by E. Svetozarov on 16.02.2017.
 */
public class HandlerSQL<T> {
    private final String db = "example";

    private String[] objectsType = {"student", "group", "lection", "journal"};

    public HandlerSQL() {

    }

    public ArrayList<T> selectFromTable(Class obj, int id, String name) throws SQLException, IllegalAccessException {
        Connection conn = SingletonConnection.getConnection();
        Field fields[] = obj.getDeclaredFields();
        String str = "Select * from " + db + "." + obj.getSimpleName().toLowerCase();
        str = lineFormationForSelect(str, id, name);

        ArrayList<T> list = new ArrayList<T>();
        System.out.println(str);
        PreparedStatement preparedStatement = conn.prepareStatement(str);
        setFiledSqlForSelect(str, id, name, preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            try {
                T ob = (T) obj.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    setFieldObject(rs, fields[i], i, ob);
                }
                list.add(ob);
            } catch (InstantiationException e) {
                System.out.println("error create object");
            }

        }
        return list;
    }

    private void setFieldObject(ResultSet resultSet, Field field, int index, T object)
            throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        switch (field.getType().getSimpleName().toLowerCase()) {
            case "string":
                field.set(object, resultSet.getString(++index));
                break;
            case "int":
                field.set(object, resultSet.getInt(++index));
                break;
            case "date":
                field.set(object, resultSet.getDate(++index));
                break;
            case "char":
                field.set(object, resultSet.getString(++index).charAt(0));
                break;
        }
    }


    private void setFiledSqlForSelect(String str, int id, String name, PreparedStatement preparedStatement) throws SQLException {
        boolean flag = false;
        if (id != 0) {
            flag = true;
            preparedStatement.setInt(1, id);
        }
        if (!name.trim().equals("")) {
            if (flag) {
                preparedStatement.setString(2, name);
            } else {
                preparedStatement.setString(1, name);
            }
        }
    }

    private String lineFormationForSelect(String str, int id, String name) {
        boolean flag = false;
        if (id != 0) {
            str += " where id = ?";
            flag = true;
        }
        if (!name.trim().equals("")) {
            if (flag) {
                str += " and ";
            } else {
                str += " where ";
            }
            str += " name = ?";
        }
        return str;
    }


}