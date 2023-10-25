


const employeeData = {
    "employees": [
        {
            "name": "John Doe",
            "id": "001"
        },
        {
            "name": "Jane Smith",
            "id": "002"
        },
        {
            "name": "Bob Johnson",
            "id": "003"
        },
        {
            "name": "Alice Johnson",
            "id": "004"
        },
        {
            "name": "Michael Brown",
            "id": "005"
        }
    ]
};

function createTableRows() {
    const tableBody = document.getElementById('employeeTableBody');
    const employees = employeeData.employees;

    employees.forEach((employee) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td><input type="time" name="time" class="time-input"></td>
            <td><input type="time" name="time" class="time-input"></td>
            <td>
                <select class="form-control">
                    <option>Present</option>
                    <option>Absent</option>
                </select>
            </td>
        `;

        tableBody.appendChild(row);
    });
}
createTableRows();


//when i click on save then post all data with present and absent
document.getElementById("save").addEventListener("click", function() {
    const dateInput = document.getElementById("dateInput").value;
    const data = {
        date: dateInput,
    };
    fetch('', { //place here api endpoint
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
});

//attendancedetail.html

//send date data to api
function sendToAPI(startDate, endDate) {
    const apiEndpoint = ''; // place here api endpoint

    const data = {
        startDate: startDate,
        endDate: endDate
    };

    fetch(apiEndpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); 
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });
}

function handleSearchClick() {
    const startDate = document.getElementById("startDate").value;
    const endDate = document.getElementById("endDate").value;
    if (startDate && endDate) {
        sendToAPI(startDate, endDate);
    } else {
        alert("Please select both start date and end date.");
    }
}

document.getElementById("search").addEventListener("click", handleSearchClick);



//get data in table list

const apiEndpoint = '';//place here api endpoint

function fetchDataAndPopulateTable() {
    fetch(apiEndpoint)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.getElementById('employeedetail');
            data.forEach((employee, index) => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${index + 1}</td>
                    <td>${employee.name}</td>
                    <td>${employee.inTime}</td>
                    <td>${employee.outTime}</td>
                    <td>${employee.percentage}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}
window.onload = fetchDataAndPopulateTable;