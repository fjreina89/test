<%--
 * action-2.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<display:table name="threads" id="row"

requestURI="customer/listThreads.do"
pagesize="5" class="displaytag" >

<%--
<display:column property="name" />
<display:column property="price"/>
<display:column property="unitsAvaliable"/>
<display:column title="Details"> <a href="customer/itemDetails.do?id=${row.id}">Details</a></display:column>
<display:column title="Edit"> <a href="customer/editItem.do?id=${row.id }">Edit</a></display:column>
 --%>

</display:table>