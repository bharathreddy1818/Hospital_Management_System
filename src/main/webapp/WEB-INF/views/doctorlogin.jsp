<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0; /* Remove default margin */
            display: flex;
            flex-direction: column; /* Stack children vertically */
            min-height: 100vh; /* Ensure the body covers the full viewport height */
        }

        .navbar {
            background-color: #2f8f2f;
            padding: 10px;
            height: 70px;
            display: flex; /* Use flexbox for alignment */
            align-items: center; /* Center items vertically */
            justify-content: space-between; /* Space between items */
        }

        .navbar h2 {
            margin: 0; /* Remove default margin */
            color: white; /* Set text color */
        }

        .navbar a {
            padding: 14px 20px;
            text-decoration: none;
            color: white;
            text-align: center;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .login-container {
            flex: 1; /* Take up remaining space */
            display: flex;
            justify-content: center;
            align-items: center; /* Center login container vertically */
            padding: 20px; /* Add padding for spacing */
        }

        .login-box {
            width: 400px;
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .btn {
            width: 100%;
            padding: 10px;
            font-size: 18px;
            color: white;
            background-color: #3cb371;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #249024;
        }

        .error {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 15px;
        }

        .footer {
            background-color: #2f8f2f;
            color: white;
            text-align: center;
            padding: 10px;
        }
    </style>
</head>
<body>
    <%@ include file="homeheader.jsp" %>

    <div class="login-container">
        <div class="login-box">
            <h2>Doctor Login</h2>
		
			 <%
                String errorMessage = (String) request.getAttribute("message");
                if (errorMessage != null) {
            %>
                <div class="error"><%= errorMessage %></div>
            <%
                }
            %>
            <form action="/doctor/doctorCheck" method="get">
                <div class="input-group">
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" required>
                </div>

                <div class="input-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <button type="submit" class="btn">Login</button>

            </form>
        </div>
    </div>

    <%@ include file="homefooter.jsp" %>
</body>
</html>