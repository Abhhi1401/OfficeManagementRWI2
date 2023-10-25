// Emplist.html
//function to get data from api

// function fetchDataAndCreateRows() {
//     fetch('') //place the end point of the get data of employee list 
//         .then(response => response.json())
//         .then(data => {
//             const table = document.querySelector("table");
//             const tbody = table.querySelector("tbody");

//             tbody.innerHTML = "";

//             data.forEach(item => {
//                 const newRow = tbody.insertRow();

//                 const rowData = [
//                     item.employeeName,
//                     item.employeeID,
//                     item.position,
//                     item.contact,
//                     item.email
//                 ];

//                 rowData.forEach((value, index) => {
//                     const cell = newRow.insertCell(index);
//                     cell.innerHTML = value;
//                 });

//                 const removeButtonCell = newRow.insertCell(rowData.length); 
//                 const removeButton = document.createElement("button");
//                 removeButton.innerHTML = "Remove";
//                 removeButton.className = "btn btn-danger";


//                 removeButton.addEventListener("click", function () {
//                     table.deleteRow(newRow.rowIndex); 
//                 });

//                 removeButtonCell.appendChild(removeButton); 
//             });
//         })
//         .catch(error => {
//             console.error("Error fetching data:", error);
//         });
// }

// const addButton = document.getElementById("addButton");

// addButton.addEventListener("click", fetchDataAndCreateRows);

// fetchDataAndCreateRows();

//emplist.html
document.addEventListener('DOMContentLoaded', function () {
    const tbody = document.getElementById("employeeTableBody");

    // Simulated data for demonstration purposes
    const data = [
        {
            name: "John Doe",
            employeeID: "E12345",
            position: "Manager",
            contact: "8778983259",
            email: "john.doe@example.com"
        },
        {
            name: "Jane Smith",
            employeeID: "E54321",
            position: "Supervisor",
            contact: "8734085259",
            email: "jane.smith@example.com"
        },
        {
            name: "Bob Johnson",
            employeeID: "E67890",
            position: "Developer",
            contact: "8734083259",
            email: "bob.johnson@example.com"
        }
    ];

    data.forEach((item, index) => {
        const newRow = tbody.insertRow();

        const rowData = [
            index + 1, 
            item.name, 
            item.employeeID, 
            item.position, 
            item.contact,
            item.email, 
        ];

        rowData.forEach((value, colIndex) => {
            const cell = newRow.insertCell(colIndex); 
            cell.textContent = value; 
        });

        const removeButtonCell = newRow.insertCell(rowData.length);
        const removeButton = document.createElement("button");
        removeButton.textContent = "Remove";
        removeButton.className = "btn btn-danger";

        removeButton.addEventListener("click", function () {
            tbody.deleteRow(newRow.rowIndex); 
        });

        removeButtonCell.appendChild(removeButton);
    });
});


//addemp.html

//function to post data to api.
document.getElementById("addemp").addEventListener("submit", function (e) {
    e.preventDefault(); 

    postData(); 
});

async function postData() {
    try {
        const employeeName = document.getElementById("employeeName").value;
        const employeeID = document.getElementById("employeeID").value;
        const employeePosition = document.getElementById("employeePosition").value;
        const contactNumber = document.getElementById("contactNumber").value;
        const emailAddress = document.getElementById("emailAddress").value;
        const salary = document.getElementById("salary").value;

        const formData = {
            employeeName: employeeName,
            employeeID: employeeID,
            employeePosition: employeePosition,
            contactNumber: contactNumber,
            emailAddress: emailAddress,
            salary: salary
        };

        const jsonData = JSON.stringify(formData);

        const response = await fetch('YOUR_API_ENDPOINT_HERE', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: jsonData
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();

        console.log('Data sent successfully');
    } catch (error) {
        console.error('Error:', error);
    }
}

//updateemp.html

//search logic
document.getElementById("search").addEventListener("click", async function () {
    const searchInput = document.getElementById("searchEmployee").value;

    try {
        const response = await fetch(` //APIkey ?search=${searchInput}`, { 
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const employeeData = await response.json();

        document.getElementById("employeeName").value = employeeData.employeeName;
        document.getElementById("employeeID").value = employeeData.employeeID;
        document.getElementById("employeePosition").value = employeeData.employeePosition;
        document.getElementById("contactNumber").value = employeeData.contactNumber;
        document.getElementById("emailAddress").value = employeeData.emailAddress;
        document.getElementById("salary").value = employeeData.salary;

    } catch (error) {
        console.error('Error:', error);
    }
});


document.getElementById("update").addEventListener("click", async function () {
    const employeeName = document.getElementById("employeeName").value;
    const employeeID = document.getElementById("employeeID").value;
    const employeePosition = document.getElementById("employeePosition").value;
    const contactNumber = document.getElementById("contactNumber").value;
    const emailAddress = document.getElementById("emailAddress").value;
    const salary = document.getElementById("salary").value;

    const formData = {
        employeeName: employeeName,
        employeeID: employeeID,
        employeePosition: employeePosition,
        contactNumber: contactNumber,
        emailAddress: emailAddress,
        salary: salary
    };

    try {
        const response = await fetch('', { //put the update employee APi
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const updatedData = await response.json();

        console.log('Data updated successfully:', updatedData);
    } catch (error) {
        console.error('Error:', error);
    }
});


//attendence.html




  
//
  