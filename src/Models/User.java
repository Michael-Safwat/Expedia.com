package Models;

import java.sql.ResultSet;
import java.util.Date;

public class User
{

    private int ID;
    private String FullName;
    private String Password;
    private String EMail;
    private boolean IsDeleted;
    private Date DOB;

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setFullName(String fullName)
    {
        FullName = fullName;
    }

    public void setPassword(String password)
    {
        Password = password;
    }

    public void setEMail(String EMail)
    {
        this.EMail = EMail;
    }

    public void setDeleted(boolean deleted)
    {
        IsDeleted = deleted;
    }

    public void setDOB(Date DOB)
    {
        this.DOB = DOB;
    }

    public void setGeneratedOn(Date generatedOn)
    {
        GeneratedOn = generatedOn;
    }

    public void setDeleteOn(Date deleteOn)
    {
        DeleteOn = deleteOn;
    }

    public void setType(Lookup type)
    {
        Type = type;
    }

    public int getID()
    {
        return ID;
    }

    public String getFullName()
    {
        return FullName;
    }

    public String getPassword()
    {
        return Password;
    }

    public String getEMail()
    {
        return EMail;
    }

    public boolean isDeleted()
    {
        return IsDeleted;
    }

    public Date getDOB()
    {
        return DOB;
    }

    public Date getGeneratedOn()
    {
        return GeneratedOn;
    }

    public Date getDeleteOn()
    {
        return DeleteOn;
    }

    public Lookup getType()
    {
        return Type;
    }

    private Date GeneratedOn;
    private Date DeleteOn;
    Lookup Type;

    public void printUser()
    {
        System.out.println(getID() + " " + getFullName() + " " + getEMail() + " " + getDOB() + " " + getGeneratedOn());
        this.Type.printLookup();
    }
}
