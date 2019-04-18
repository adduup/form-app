<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>List Students</title>
      <style>
         .access {
         color: red;
         }
      </style>
   </head>
   <body>
      <div id="wrapper">
         <div id="header">
         </div>
      </div>
      <div id="content">
         <br/>
         <input type="button" value="Sort By First Name"
            onclick="window.location.href='listByFirst'; return false;" />
         <br/>
         <input type="button" value="Sort By Last Name"
            onclick="window.location.href='listByLast'; return false;" />
         <br/>
         <input type="button" value="Countries"
            onclick="window.location.href='listCountries'; return false;" />
         <br/>
      </div>
      <br/>
      <div>
         <br/>
         <div class="username">
            Welcome, 
            <security:authentication property="principal.username" />
            <br/>
            <security:authentication property="principal.authorities"/>
            <security:authorize access="hasRole('ADMIN')">
               <br>
               <input type="button" value="Add Student"
                  onclick="window.location.href='showFormForAdd'; return false;" />
            </security:authorize>
         </div>
         <br/>	
      </div>
      <form:form action="search" method="GET">
         Search By First Name: <input type="text" name="searchName" />
         <input type="submit" value="Search" />
      </form:form>
      <table>
         <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
            <security:authorize access="hasRole('MANAGER')">
               <th>Address</th>
            </security:authorize>
            <th>View Information</th>
         </tr>
         <c:forEach var="student" items="${students}">
            <c:url var="updateLink" value="/student/showFormForUpdate">
               <c:param name="studentId" value="${student.id}"/>
            </c:url>
            <c:url var="deleteLink" value="/student/delete">
               <c:param name="studentId" value="${student.id}"/>
            </c:url>
            <c:url var="addressLink" value="/student/addAddress">
               <c:param name="studentId" value="${student.id}"/>
            </c:url>
            <c:url var="showAddress" value="/student/listAddress">
               <c:param name="studentId" value="${student.id}"/>
            </c:url>
            <tr>
               <td>${student.firstName}</td>
               <td>${student.lastName}</td>
               <td>${student.email}</td>
               <td>
                  <a href="${updateLink}">Update</a>
                  |
                  <a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false" 
                     >Delete</a>
               </td>
               <security:authorize access="hasRole('MANAGER')">
                  <td>
                     <a href="${addressLink}">Add Address</a>
                  </td>
               </security:authorize>
               <td>
                  <a href="${showAddress}">View</a>
               </td>
            </tr>
         </c:forEach>
      </table>
      <form:form action="${contextPath}/logout" method="POST">
         <input type="submit" value="Log Out">
      </form:form>
      </div>
   </body>
</html>