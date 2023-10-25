//aproveleave.html

//getting demo data
const sampleData = [
    {
        employeeName: "John Doe",
        employeeID: "EMP001",
    },
    {
        employeeName: "Jane Smith",
        employeeID: "EMP002",
    },
    // Add more employee data entries as needed
];

function populateNameAndID(employeeName, employeeID) {
    document.getElementById("employeeName").value = employeeName;
    document.getElementById("employeeID").value = employeeID;
}

document.getElementById("searchId").addEventListener("click", function () {
    const searchEmployeeID = document.getElementById("searchEmployee").value;
    const foundEmployee = sampleData.find((employee) => employee.employeeID === searchEmployeeID);

    if (foundEmployee) {
        populateNameAndID(foundEmployee.employeeName, foundEmployee.employeeID);
    } else {
        alert("Employee not found");
    }
});


// <---------------------------->


//getting data from api

// async function fetchEmployeeData(employeeID) {
//     try {
//         const response = await fetch(`${employeeID}`); //place here a api endpoint
//         if (!response.ok) {
//             throw new Error("Network response was not ok");
//         }
//         const data = await response.json();
//         return data;
//     } catch (error) {
//         console.error("API Error:", error);
//         throw error;
//     }
// }
// async function populateNameAndID() {
//     const searchEmployeeID = document.getElementById("searchEmployee").value;

//     try {
//         const foundEmployee = await fetchEmployeeData(searchEmployeeID);
//         document.getElementById("employeeName").value = foundEmployee.employeeName;
//         document.getElementById("employeeID").value = foundEmployee.employeeID;
//     } catch (error) {
//         alert("Employee not found or there was an error.");
//     }
// }

// document.getElementById("searchId").addEventListener("click", populateNameAndID);



// <---------------------------------->


//posting data 
async function postDataToApi(data) {
    try {
        const response = await fetch("", { //place here a api endpoint
            method: "POST",
            headers: {
                "Content-Type": "application/json", 
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
    } catch (error) {
        console.error("API Error:", error);
    }
}
document.getElementById("Approval").addEventListener("click", async function () {
    const employeeName = document.getElementById("employeeName").value;
    const employeeID = document.getElementById("employeeID").value;
    const startDate = document.getElementById("employeePosition").value;
    const endDate = document.getElementById("contactNumber").value;
    const description = document.getElementById("emailAddress").value;

    const formData = {
        employeeName,
        employeeID,
        startDate,
        endDate,
        description,
    };

    await postDataToApi(formData);
});