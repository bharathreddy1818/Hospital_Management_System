
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAFE HOMES</title>
   <style>
        .feature-container {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap; 
            margin-top: 100px;
            padding-left:80px;
            padding-right:80px;
        }
        .feature-box {
           width:500px;
            border: 2px solid #ddd; 
            padding: 25px;
            border-radius: 10px; 
            text-align: center;
            box-shadow: 0px 0px 15px 0px #ccc; 
            margin-bottom: 20px; 
            font-size: 18px; 
        }
        .feature-box h3 {
            margin-bottom: 15px;
            color: #333;
            font-size: 24px; 
        }
        .feature-box p {
            color: #555;
            font-size: 16px; 
        }
        .container h2 {
            font-size: 32px;
            text-align: center;
        }
        .s{
        	text-decoration:none;
        	font-size:30px;
        	 color: #333;
        }
       .error{
       text-align:center;
       font-size:22px;
       margin-top:10px;
       }
    </style>
</head>
<body>
<%@ include file="adminheader.jsp" %>
			 <%
			 
                String errorMessage = (String) request.getAttribute("message");
                if (errorMessage != null) {
            %>
                <div class="error"><%= errorMessage %></div>
            <%
                }
            %>
<div class="container">
    <div class="feature-container">
        <div class="feature-box">
            <a href="addDoctor.jsp" class="s">DOCTORS</a><br>
            <div id="doctorsCount" class="s">Loading...</div>
        </div>        
        <div class="feature-box">
            <h3 class="s">PATIENTS</h3>
            <div id="patientsCount" class="s">Loading...</div>
        </div>
        <div class="feature-box">
            <h3 class="s">APPOINTMENTS</h3>
            <div id="appointmentsCount" class="s">Loading...</div>
        </div>
        <div class="feature-box">
            <a href="addSpecialist.jsp" class="s">SPECIALISTS</a><br>
            <div id="specialistsCount" class="s">Loading...</div>
        </div>
    </div>
</div>
<%@ include file="homefooter.jsp" %>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        fetch('/admin/count') // API endpoint
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to fetch data');
                }
                return response.json(); // Parse JSON response
            })
            .then(data => {
               			 document.getElementById('doctorsCount').textContent = data.doctors;
                		document.getElementById('patientsCount').textContent = data.patients;
                        document.getElementById('appointmentsCount').textContent = data.appointments;
                        document.getElementById('specialistsCount').textContent = data.specialists;
                    })
                    .catch(error => {
                        console.error('Error fetching data:', error);
                        alert('Failed to fetch data.');
                    });
            });
        </script>
</body>
</html>
