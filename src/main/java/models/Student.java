package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by E. Svetozarov on 18.02.2017.
 */
@XmlRootElement(name = "student")
@XmlType(propOrder = {"id", "name","bith_date", "sex", "id_group"})
public class Student {
    private int id;
    private String name;
    private Date bith_date;
    private char sex;
    private int id_group;

    public char getSex() {
        return sex;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Date getBith_date() {
        return bith_date;
    }

    @XmlElement
    public void setBith_date(Date bithDate) {
        this.bith_date = bithDate;
    }



    @XmlElement
    public void setSex(char sex) {
        this.sex = sex;
    }

   /* public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }*/
}
