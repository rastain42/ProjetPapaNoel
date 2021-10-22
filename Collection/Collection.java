package Collection;

import java.sql.Date;

public class Collection {
  String m_user_name;
  String m_present;
  Date m_date;
  Collection(String user_name, String present, Date date){
     m_user_name = user_name;
     m_present = present;
     m_date = date;
  }

  public String getUserName(){
    return m_user_name;
  }
  public String getPresent(){
    return m_present;
  }
  public Date getDate(){
    return m_date;
  }
}
