package model;
/**
*The Output class is Model of Output page
*@author SARATHKRISHNA S
*@version 1.0
*@since 2018-07-24
*/
public class Output
{
private String userName;
private int userScore;

public void setUserName(String userName)
{
this.userName=userName;
}

public String getUserName()
{
return userName;
}

public void setUserScore(int userScore)
{
this.userScore=userScore;
}

public int getUserScore()
{
return userScore;
}

}