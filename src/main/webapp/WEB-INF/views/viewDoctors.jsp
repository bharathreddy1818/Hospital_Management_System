<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DOCTOR DETAILS</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2{
        	text-align:center;
        }

        .table-container {
            padding-left: 5%;
            padding-right:5%;
            margin: 0 auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #a0a0a0;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .btn {
		    display: inline-block; 
		    padding: 12px 20px; 
		    font-size: 16px; 
		    font-weight: bold; 
		    color: #fff;
		    background-color: #007bff; 
		    border: none; 
		    border-radius: 5px; 
		    cursor: pointer; 
		    text-align: center; 
		    text-decoration: none;
		}
    </style>
</head>
<body>
 <%@ include file="adminheader.jsp" %>

    <h2>DOCTOR DETAILS</h2>
    <br>
    <div class="table-container">
        <table id="doctorTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Specialization</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Data will be inserted here dynamically -->
            </tbody>
        </table>
    </div>

    <%@ include file="homefooter.jsp" %>
<script>
document.addEventListener("DOMContentLoaded", function () {
    fetch("/admin/displayDoctors")
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#doctorTable tbody");
            tableBody.innerHTML = ""; // Clear existing data

            data.forEach(doctor => {
                // Create a table row
                const row = document.createElement("tr");

                // Create and append TD for doctor.id
                const idCell = document.createElement("td");
                idCell.textContent = doctor.doctor_id;
                row.appendChild(idCell);

                // Create and append TD for doctor.name
                const nameCell = document.createElement("td");
                nameCell.textContent = doctor.fullName;
                row.appendChild(nameCell);

                // Create and append TD for doctor.specialization
                const specializationCell = document.createElement("td");
                specializationCell.textContent = doctor.specialist;
                row.appendChild(specializationCell);

                // Create and append TD for doctor.phone
                const phoneCell = document.createElement("td");
                phoneCell.textContent = doctor.mobno;
                row.appendChild(phoneCell);

                // Create and append TD for doctor.email
                const emailCell = document.createElement("td");
                emailCell.textContent = doctor.email;
                row.appendChild(emailCell);

                // Create TD for actions (Edit and Delete buttons)
                const actionsCell = document.createElement("td");

                // Create and configure the Edit button
                const editButton = document.createElement("button");
                editButton.className = "btn edit-btn";
                editButton.textContent = "Edit";
                editButton.addEventListener("click", function () {
				window.location.href="/eDoctor?id="+doctor.doctor_id;
                });
                actionsCell.appendChild(editButton);

                // Create and configure the Delete button
                const deleteButton = document.createElement("button");
                deleteButton.className = "btn delete-btn";
                deleteButton.textContent = "Delete";
                deleteButton.addEventListener("click", function () {
                    deleteDoctor(doctor.doctor_id);
                });
                actionsCell.appendChild(deleteButton);

                // Append the actions cell to the row
                row.appendChild(actionsCell);

                // Finally, append the row to the table body
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error("Error fetching doctor data:", error));
});

async function deleteDoctor(id) {
    if (!id) {
        alert("Invalid doctor ID.");
        return;
    }

    if (!confirm("Are you sure you want to delete this doctor?")) {
        return;
    }

    try {
        let response = await fetch("/admin/deleteDoctor/"+id, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) {
            let errorMessage = await response.text();
            throw new Error(errorMessage || `Failed to delete doctor (HTTP ${response.status}).`);
        }

        location.reload(); 
    } catch (error) {
        console.error("Error deleting doctor:", error);
        alert(`Error: ${error.message}`);
    }
}
 


</script>
    </body>
</html>