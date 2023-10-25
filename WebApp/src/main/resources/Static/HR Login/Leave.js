// leavelist.html

//getting demo data
document.addEventListener("DOMContentLoaded", function() {
    const jsonData = [
        {
            "S.No": 1,
            "Name": "John Doe",
            "ID": "EMP001",
            "Leave Type": "Vacation",
            "Start Date": "2023-10-10",
            "End Date": "2023-10-15",
            "Attach Document": "link/to/document1.pdf",
            "Status": "Pending"
        },
        {
            "S.No": 2,
            "Name": "Alice Johnson",
            "ID": "EMP002",
            "Leave Type": "Sick Leave",
            "Start Date": "2023-11-05",
            "End Date": "2023-11-10",
            "Attach Document": "link/to/document2.pdf",
            "Status": "Approved"
        },
        {
            "S.No": 3,
            "Name": "Bob Smith",
            "ID": "EMP003",
            "Leave Type": "Maternity Leave",
            "Start Date": "2023-12-01",
            "End Date": "2023-12-20",
            "Attach Document": "link/to/document3.pdf",
            "Status": "Rejected"
        }
    ];

    const tableBody = document.getElementById('Leavelist');

    // Loop through the JSON data and populate the table
    jsonData.forEach((data, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${data["S.No"]}</td>
            <td>${data["Name"]}</td>
            <td>${data["ID"]}</td>
            <td>${data["Leave Type"]}</td>
            <td>${data["Start Date"]}</td>
            <td>${data["End Date"]}</td>
            <td><a href="#">${data["Attach Document"]}</a></td>
            <td>
                <select class="form-select" onchange="changeStatus(${index}, this.value)">
                    <option value="Pending" ${data["Change Status"] === "Pending" ? "selected" : ""}>Pending</option>
                    <option value="Approved" ${data["Change Status"] === "Approved" ? "selected" : ""}>Approved</option>
                    <option value="Rejected" ${data["Change Status"] === "Rejected" ? "selected" : ""}>Rejected</option>
                </select>
            </td>
        `;
        tableBody.appendChild(row);
    });
});



//getting data from api
// const apiEndpoint = ''; //place here api endpoint

// const Body = document.getElementById('Leavelist');

// function fetchDataAndPopulateTable() {
//     fetch(apiEndpoint)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Network response was not ok');
//             }
//             return response.json();
//         })
//         .then(data => {
//             data.forEach((item, index) => {
//                 const row = document.createElement('tr');
//                 row.innerHTML = `
//                     <td>${item["S.No"]}</td>
//                     <td>${item["Name"]}</td>
//                     <td>${item["ID"]}</td>
//                     <td>${item["Leave Type"]}</td>
//                     <td>${item["Start Date"]}</td>
//                     <td>${item["End Date"]}</td>
//                     <td><a href="#">${item["Attach Document"]}</a></td>
//                 `;
//                 tableBody.appendChild(row);
//             });
//         })
//         .catch(error => {
//             console.error('There was a problem with the fetch operation:', error);
//         });
// }

// window.onload = fetchDataAndPopulateTable;
