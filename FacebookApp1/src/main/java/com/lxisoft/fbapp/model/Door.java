//Import required java libraries
package com.lxisoft.fbapp.model;

import java.util.logging.*;
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

    /**
       * Reference to Logger class to get log messages
     */
      
    private static final Logger log=Logger.getLogger(Door.class.getName());


	public void setOpeningHall(Hall openingHall)
	{
		log.info("Door class..........................setOpeningHall................starts");

		this.openingHall = openingHall;

		log.info("Door class..........................setOpeningHall..................ends");
	}
	
	/**
	 * getter for openingHall
	 * 
	 * @return openingHall openingHall of a prison
	 *
	 */

	public Hall getOpeningHall()
	{
		log.info("Door class..........................getOpeningHall................starts/ends");

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
		log.info("Door class..........................setSecurityQuestion................starts");

		this.securityQuestion = securityQuestion;

		log.info("Door class..........................setSecurityQuestion..................ends");
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
		log.info("Door class..........................getSecurityQuestion................starts/ends");

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
		log.info("Door class..........................setDoorId................starts");

		this.doorId = doorId;

		log.info("Door class..........................setDoorId..................ends");

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
		log.info("Door class..........................getDoorId................starts/ends");

		return this.doorId;
	}

}