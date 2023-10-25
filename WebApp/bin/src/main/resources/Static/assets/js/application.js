
// async function applicationData(url, data) {
//     try {
//         const response = await fetch(url, {
//             method: 'post',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(data)
//         });

//         const responseData = await response.json();
//         return responseData;
//     } catch (error) {
//         console.error('Error posting data:', error);
//         return { error: 'An error occurred' };
//     }
// }

// document.getElementById('applicationForm').addEventListener('submit', async function (event) {
//     event.preventDefault();

//     const formData = {
//         firstname: document.getElementById('fname').value,
//         lastname: document.getElementById('lname').value,
//         email: document.getElementById('email').value,
//         contactDetails: document.getElementById('phoneNumber').value,
//         qualifucationDetails : document.getElementById('qualifications').value
//         // Add other form fields here
//     };

//     const response = await postData('localhost:8080/applicant', formData);

//     if (response.error) {
//         console.error('Failed to submit form:', response.error);
//     } else {
//         console.log('Form submitted successfully:', response.message);
//     }
// });

//         fetch('https://jsonplaceholder.typicode.com/posts', {
//   method: 'POST',
//   body: JSON.stringify({
//     title: 'foo',
//     body: 'bar',
//     userId: 1,
//   }),
//   headers: {
//     'Content-type': 'application/json; charset=UTF-8',
//   },
// })
//   .then((response) => response.json())
//   .then((json) => console.log(json));



// Application get table data
// GET data in TOP
const dataArray = [
    "Automotive Verification and Validation",
    "1 to 3 Years",
    "1",
    "11/08/2023",
    "24/08/2023",
    "IT",
    "Raipur (India)",
    "970753",
    "upto 15k to 30k",
    "Full Time",
    "B-Tech/B.E/MCA"
];

// Loop through the dataArray and update span elements
for (let i = 0; i < dataArray.length; i++) {
    const spanId = i + 1;
    const spanElement = document.getElementById(spanId.toString());
    if (spanElement) {
        spanElement.textContent = dataArray[i];
    }
};


// Form data send to Api
document.getElementById('registrationForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent the default form submission

    const formData = new FormData(event.target);

    fetch('https://localhost:8080/applicants', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            console.log('Response from API:', data);
            // Handle the response data here
        })
        .catch(error => {
            console.error('Error:', error);
            // Handle errors here
        });
});
