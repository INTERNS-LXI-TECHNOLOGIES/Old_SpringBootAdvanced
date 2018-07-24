//Import required java libraries
package com.lxisoft.fbapp.model;

/**
 * define Door enitity in the game. 
 * 
 * @author Sarangi Balu
 * 
 * @version $version-stub$
 *
 */
public class Door
{
	/**
     *  Hall to which door opens  
     */
	private Hall openingHall;

	/**
     * Reference to SecurityQuestion class
     */

	private SecurityQuestion securityQuestion;

	/**
     * Unique id of doorId
     */

    private long doorId;

    /**
	 * setter for openingHall
	 * 
	 * @param openingHall
	 *            openingHall of a prison
	 */

	public void setOpeningHall(Hall openingHall)
	{
		this.openingHall = openingHall;
	}
	
	/**
	 * getter for openingHall
	 * 
	 * @return openingHall openingHall of a prison
	 *
	 */

	public Hall getOpeningHall()
	{
		return this.openingHall;
	}


    /**
	 * setter for securityQuestion
	 * 
	 * @param securityQuestion
	 *            securityQuestion of a door
	 */
    
	public void setSecurityQuestion(SecurityQuestion securityQuestion)
	{
		this.securityQuestion = securityQuestion;
	}
	
	/**
	 * getter for securityQuestion
	 * 
	 * @return securityQuestion
	 *            securityQuestion of a door
	 *
	 */

	public SecurityQuestion getSecurityQuestion()
	{
		return this.securityQuestion;
	}

	/**
	 * setter for doorId
	 * 
	 * @param doorId
	 *            unique id of a door
	 */
    
	public void setDoorId(long doorId)
	{
		this.doorId = doorId;
	}
	
	/**
	 * getter for doorId
	 * 
	 * @return doorId
	 *            unique id of a door
	 *
	 */

	public Long getDoorId()
	{
		return this.doorId;
	}

}