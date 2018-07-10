package com.lxisoft.contactApp.service;

/*// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;*/

import java.util.*;
//import java.util.logging.Logger;
import com.lxisoft.contactApp.model.*;


public interface ContactService
{
	Set<Contact> findAll();

	void save(Contact contact);

	Contact findOne(String phnNo);

	void delete(String name);

	void update(Contact contact);

	Set<Contact> findByName(String name);
}